package com.artivisi.sailorman.ui.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.domain.Sailor.Status;
import com.artivisi.sailorman.service.SailorService;

@Controller
@RequestMapping("/sailor")
public class SailorController {
	
	private static final String LABEL_NEXT_PAGE = "next";

	private static final String SESSION_KEY_EXISTING_PHOTO = "EXISTING_PHOTO";

	private static final String SESSION_KEY_SAILOR_LIST = "sailorList";

	private String uploadDestination = "uploads/";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private SailorService sailorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/list")
	public ModelMap list(@RequestParam(value="name", required=false)String name, 
			@RequestParam(value="page", required=false)String page, 
			HttpSession session){
		if (StringUtils.hasText(name)) {
	        PagedListHolder<Sailor> sailorList = new PagedListHolder<Sailor>(sailorService.findSailors(name));
	        session.setAttribute(SESSION_KEY_SAILOR_LIST, sailorList);
	        return new ModelMap(SESSION_KEY_SAILOR_LIST, sailorList);
	    }
	    else {
	        PagedListHolder<Sailor> sailorList = (PagedListHolder<Sailor>) session.getAttribute(SESSION_KEY_SAILOR_LIST);
	        if (sailorList == null) {
	            return new ModelMap();
	        }
	        if (LABEL_NEXT_PAGE.equals(page)) {
        		sailorList.nextPage();
	        }
	        else if ("previous".equals(page)) {
	            sailorList.previousPage();
	        }
	        return new ModelMap(SESSION_KEY_SAILOR_LIST, sailorList);
	    }
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam Long id, HttpSession session){
		Sailor sailor = sailorService.findSailor(id);
		if(sailor != null) {
			sailorService.delete(sailor);
		}
		session.removeAttribute(SESSION_KEY_SAILOR_LIST);
		return "redirect:list";
	}
	
	@RequestMapping("/export")
	public ModelMap export(@RequestParam Long id, @RequestParam String format){
		ModelMap result = new ModelMap();
		Sailor sailor = sailorService.findSailor(id);
		if(sailor == null) {
			return result;
		}
		
		result.addAttribute("sailor", sailor);
		result.addAttribute("format", format);
		result.addAttribute("assignments", sailorService.findAssignment(sailor));
		
		return result;
	}
	
	@RequestMapping("/view")
	public ModelMap view(@RequestParam Long id){
		Sailor sailor = sailorService.findSailor(id);
		if(sailor == null) {
			return new ModelMap();
		}
		return new ModelMap()
		.addAttribute(sailor)
		.addAttribute(sailorService.findAssignment(sailor));
	}

	@RequestMapping("/select")
	public String select(@RequestParam Long id){
		Sailor sailor = sailorService.findSailor(id);
		if(sailor != null) {
			sailor.setEmploymentStatus(Status.SELECTED);
			sailorService.save(sailor);
		}
		return "redirect:view?id="+id;
	}
	@RequestMapping("/approve")
	public String approve(@RequestParam Long id){
		Sailor sailor = sailorService.findSailor(id);
		if(sailor != null) {
			sailor.setEmploymentStatus(Status.APPROVED);
			sailorService.save(sailor);
		}
		return "redirect:view?id="+id;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam(value="id", required=false)Long id, HttpSession session){
		Sailor sailor = sailorService.findSailor(id);
		if(sailor == null) {
			sailor = new Sailor();
		}
		
		if(sailor.getId() != null) {
			// existing sailor, save photo info
			if(StringUtils.hasText(sailor.getPhoto())){
				session.setAttribute(SESSION_KEY_EXISTING_PHOTO, sailor.getPhoto()); 
			}
		}
		
		return new ModelMap(sailor);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String processForm(HttpSession session, HttpServletRequest request, @ModelAttribute @Valid Sailor sailor, BindingResult errors, SessionStatus status, @RequestParam("photofile") MultipartFile file) throws Exception{
		if(errors.hasErrors()) {
			return "sailor/form";
		}
		
		String photo = (String) session.getAttribute(SESSION_KEY_EXISTING_PHOTO);
		if(StringUtils.hasText(photo)) {
			sailor.setPhoto(photo);
		}
		session.removeAttribute(SESSION_KEY_EXISTING_PHOTO);
		
		sailorService.save(sailor);
		
		if(file != null && !file.isEmpty()) {
			setSailorPhoto(request, sailor, file);
		}
		
		status.setComplete();
		return "redirect:list";
	}

	private void setSailorPhoto(HttpServletRequest request, Sailor sailor,
			MultipartFile file) throws IOException {
		
		String realPath = request.getSession().getServletContext().getRealPath(uploadDestination);
		if(logger.isDebugEnabled()){
			logger.debug("Real path : {}", realPath);
		}
		
		if(StringUtils.hasText(sailor.getPhoto())){
			// remove existing photo
			File existing = new File(request.getSession().getServletContext().getRealPath(sailor.getPhoto()));
			if(existing.exists()) {
				existing.delete();
			}
		}
		
		String originalFilename = file.getOriginalFilename();
		
		if(logger.isDebugEnabled()){
			logger.debug("Original file name : {}", originalFilename);
		}
		int dot = originalFilename.lastIndexOf('.');
		String extension = originalFilename.substring(dot + 1).toLowerCase();
		if(logger.isDebugEnabled()){
			logger.debug("Extension : {}", extension);
		}
		
		File destination = new File(realPath + File.separator +sailor.getId()+"."+extension);
		file.transferTo(destination);
		
		sailor.setPhoto(uploadDestination +sailor.getId()+"."+extension);
		sailorService.save(sailor);
	}
}

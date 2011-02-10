package com.artivisi.sailorman.ui.springmvc.controller;

import java.io.File;
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
import com.artivisi.sailorman.service.SailorService;

@Controller
@RequestMapping("/sailor")
public class SailorController {
	
	private String uploadDestination = "uploads/";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private SailorService sailorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
	public ModelMap list(@RequestParam(value="name", required=false)String name, 
			@RequestParam(value="page", required=false)String page, 
			HttpSession session){
		if (StringUtils.hasText(name)) {
	        PagedListHolder<Sailor> sailorList = new PagedListHolder<Sailor>(sailorService.findSailors(name));
	        session.setAttribute("sailorList", sailorList);
	        return new ModelMap("sailorList", sailorList);
	    }
	    else {
	        PagedListHolder<Sailor> sailorList = (PagedListHolder<Sailor>) session.getAttribute("sailorList");
	        if (sailorList == null) {
	            return new ModelMap();
	        }
	        if ("next".equals(page)) {
        		sailorList.nextPage();
	        }
	        else if ("previous".equals(page)) {
	            sailorList.previousPage();
	        }
	        return new ModelMap("sailorList", sailorList);
	    }
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
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam(value="id", required=false)Long id){
		Sailor sailor = sailorService.findSailor(id);
		if(sailor == null) {
			sailor = new Sailor();
		}
		return new ModelMap(sailor);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String processForm(HttpServletRequest request, @ModelAttribute @Valid Sailor sailor, BindingResult errors, SessionStatus status, @RequestParam("photofile") MultipartFile file) throws Exception{
		if(errors.hasErrors()) {
			return "sailor/form";
		}
		
		String originalFilename = file.getOriginalFilename();
		
		if(logger.isDebugEnabled()){
			logger.debug("Original file name : {}", originalFilename);
		}
		int dot = originalFilename.lastIndexOf('.');
		String extension = originalFilename.substring(dot + 1);
		if(logger.isDebugEnabled()){
			logger.debug("Extension : {}", extension);
		}
		
		sailorService.save(sailor);
		
		String realPath = request.getSession().getServletContext().getRealPath(uploadDestination);
		if(logger.isDebugEnabled()){
			logger.debug("Real path : {}", realPath);
		}
		
		File destination = new File(realPath + "/" +sailor.getId()+"."+extension);
		file.transferTo(destination);
		
		sailor.setPhoto(uploadDestination +sailor.getId()+"."+extension);
		sailorService.save(sailor);
		
		status.setComplete();
		return "redirect:list";
	}
}

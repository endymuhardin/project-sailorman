package com.artivisi.sailorman.ui.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.service.SailorService;

@Controller
@RequestMapping("/sailor")
public class SailorController {
	
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
		PagedListHolder<Sailor> sailorList = (PagedListHolder<Sailor>) session.getAttribute("sailorList");

		if(!StringUtils.hasText(name)) {
			sailorList = new PagedListHolder<Sailor>(sailorService.findSailors(name));
		} else {
			sailorList = new PagedListHolder<Sailor>(sailorService.findSailors());
		}
		
		if("next".equals(page)) {
			sailorList.nextPage();
		}
		
		if("previous".equals(page)){
			sailorList.previousPage();
		}
		
		session.setAttribute("sailorList", sailorList);
		return new ModelMap("sailorList", sailorList);
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
	public String processForm(@ModelAttribute @Valid Sailor sailor, BindingResult errors, SessionStatus status){
		if(errors.hasErrors()) {
			return "sailor/form";
		}
		
		sailorService.save(sailor);
		status.setComplete();
		return "redirect:list";
	}
}
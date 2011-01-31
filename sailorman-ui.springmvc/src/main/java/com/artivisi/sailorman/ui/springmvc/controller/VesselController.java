package com.artivisi.sailorman.ui.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.domain.Vessel;
import com.artivisi.sailorman.service.SailorService;
import com.artivisi.sailorman.ui.springmvc.editor.CountryEditor;

@Controller
@RequestMapping("/vessel")
public class VesselController {
	@Autowired private SailorService sailorService;

	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(sailorService));
	}
	
	@ModelAttribute
	public List<Country> countries(){
		return sailorService.findCountries();
	}
	
	@RequestMapping("/list")
	public ModelMap list(@RequestParam(required=false) Long country){
		List<Vessel> vessels = sailorService.findVessels(sailorService.findCountry(country));
		return new ModelMap(vessels);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam(required=false) Long id){
		Vessel c = sailorService.findVessel(id);
		if(c == null){
			c = new Vessel();
		}
		
		return new ModelMap(c);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String processForm(@ModelAttribute @Valid Vessel vessel, BindingResult errors, SessionStatus sessionStatus){
		
		if(errors.hasErrors()) {
			return "vessel/form";
		}
		sailorService.save(vessel);
		sessionStatus.setComplete();
		return "redirect:list";
	}
}

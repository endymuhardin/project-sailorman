package com.artivisi.sailorman.ui.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.service.SailorService;

@Controller
@RequestMapping("/country")
public class CountryController {
	
	@Autowired private SailorService sailorService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/list")
	public ModelMap list(){
		List<Country> countries = sailorService.findCountries();
		
		logger.debug("Countries : {}",countries.size());
		
		return new ModelMap("countryList", countries);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam(required=false) Long id){
		Country c = sailorService.findCountry(id);
		if(c == null){
			c = new Country();
		}
		
		return new ModelMap(c);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String processForm(@ModelAttribute @Valid Country country, BindingResult errors, SessionStatus sessionStatus){
		
		if(errors.hasErrors()) {
			return "country/form";
		}
		sailorService.save(country);
		sessionStatus.setComplete();
		return "redirect:list";
	}
	
}

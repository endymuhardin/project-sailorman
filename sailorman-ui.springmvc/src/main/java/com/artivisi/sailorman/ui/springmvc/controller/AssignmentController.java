package com.artivisi.sailorman.ui.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.artivisi.sailorman.domain.Assignment;
import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.domain.Vessel;
import com.artivisi.sailorman.service.SailorService;
import com.artivisi.sailorman.ui.springmvc.editor.SailorEditor;
import com.artivisi.sailorman.ui.springmvc.editor.VesselEditor;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	
	@Autowired private SailorService sailorService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Vessel.class, new VesselEditor(sailorService));
		binder.registerCustomEditor(Sailor.class, new SailorEditor(sailorService));
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	@ModelAttribute
	public List<Vessel> vessels(){
		return sailorService.findVessels();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam Long id){
		Assignment ass = sailorService.findAssignment(id);
		if(ass != null) {
			sailorService.delete(ass);
		}
		
		return "redirect:../sailor/view?id="+ass.getSailor().getId();
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public ModelMap displayForm(@RequestParam Long sailor){
		ModelMap mm = new ModelMap();
		
		Sailor s = sailorService.findSailor(sailor);
		if(s == null) {
			mm.addAttribute("error", "Invalid sailor id "+sailor);
			return null;
		}
		
		Assignment ass = new Assignment();
		ass.setSailor(s);
		
		mm.addAttribute("assignment", ass);
		
		return mm;
	}

	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String processForm(@ModelAttribute Assignment assignment, BindingResult errors, SessionStatus status){
		if(errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				System.out.println(error.getCodes());
			}
			return "assignment/form";
		}
		
		sailorService.save(assignment);
		
		status.setComplete();
		return "redirect:../sailor/view?id="+assignment.getSailor().getId();
	}
	
	
}

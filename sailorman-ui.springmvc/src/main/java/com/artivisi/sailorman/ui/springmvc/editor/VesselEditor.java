package com.artivisi.sailorman.ui.springmvc.editor;

import java.beans.PropertyEditorSupport;

import com.artivisi.sailorman.domain.Vessel;
import com.artivisi.sailorman.service.SailorService;

public class VesselEditor extends PropertyEditorSupport {

	private SailorService sailorService;
	
	public VesselEditor(SailorService sailorService) {
		this.sailorService = sailorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Vessel v = sailorService.findVessel(Long.valueOf(text));
		if(v != null) {
			setValue(v);
		}
	}

}
package com.artivisi.sailorman.ui.springmvc.editor;

import java.beans.PropertyEditorSupport;

import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.service.SailorService;

public class SailorEditor extends PropertyEditorSupport {

	private SailorService sailorService;
	
	public SailorEditor(SailorService sailorService) {
		this.sailorService = sailorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Sailor s = sailorService.findSailor(Long.valueOf(text));
		if(s != null) {
			setValue(s);
		}
	}

}
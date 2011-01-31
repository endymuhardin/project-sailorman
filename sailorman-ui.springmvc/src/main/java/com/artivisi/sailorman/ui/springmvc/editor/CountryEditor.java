package com.artivisi.sailorman.ui.springmvc.editor;

import java.beans.PropertyEditorSupport;

import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.service.SailorService;

public class CountryEditor extends PropertyEditorSupport {

	private SailorService sailorService;
	
	public CountryEditor(SailorService sailorService) {
		super();
		this.sailorService = sailorService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Country country = sailorService.findCountry(Long.valueOf(text));
		if(country != null) {
			setValue(country);
		}
	}

}

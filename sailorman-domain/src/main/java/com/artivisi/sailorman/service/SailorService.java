package com.artivisi.sailorman.service;

import java.util.List;

import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.domain.Vessel;

public interface SailorService {
	public void save(Country country);
	public Country findCountry(Long id);
	public List<Country> findCountries();
	
	public void save(Vessel vessel);
	public Vessel findVessel(Long id);
	public List<Vessel> findVessels(Country country);
	
	public void save(Sailor sailor);
	public Sailor findSailor(Long id);
	public List<Sailor> findSailors(Integer start, Integer rows);
	public Long countSailors();
	public List<Sailor> findSailors(Vessel vessel, Integer start, Integer rows);
	public Long countSailors(Vessel vessel);
}

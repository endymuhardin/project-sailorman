package com.artivisi.sailorman.service;

import java.util.List;

import com.artivisi.sailorman.domain.Assignment;
import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.domain.Vessel;

public interface SailorService {
	public void save(Country country);
	public Country findCountry(Long id);
	public List<Country> findCountries();
	
	public void save(Vessel vessel);
	public Vessel findVessel(Long id);
	public List<Vessel> findVessels();
	public List<Vessel> findVessels(Country country);
	
	public void save(Sailor sailor);
	public void delete(Sailor sailor);
	public Sailor findSailor(Long id);
	public List<Sailor> findSailors();
	public Long countSailors();
	public List<Sailor> findSailors(String name);
	public Long countSailors(String name);
	
	public void save(Assignment assignment);
	public Assignment findAssignment(Long id);
	public List<Assignment> findAssignment(Sailor sailor);
	public List<Assignment> findAssignment(Vessel vessel);
	public void delete(Assignment ass);
}

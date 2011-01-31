package com.artivisi.sailorman.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivisi.sailorman.domain.Country;
import com.artivisi.sailorman.domain.Sailor;
import com.artivisi.sailorman.domain.Vessel;
import com.artivisi.sailorman.service.SailorService;

@Service("sailorService") @Transactional
public class SailorServiceImpl implements SailorService {

	@Autowired private SessionFactory sessionFactory;
	
	@Override
	public void save(Country country) {
		sessionFactory.getCurrentSession().saveOrUpdate(country);
	}

	@Override
	public Country findCountry(Long id) {
		if(id == null) return null;
		return (Country) sessionFactory.getCurrentSession().get(Country.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> findCountries() {
		return sessionFactory.getCurrentSession().createQuery("from Country order by code").list();
	}

	@Override
	public void save(Vessel vessel) {
		sessionFactory.getCurrentSession().saveOrUpdate(vessel);

	}

	@Override
	public Vessel findVessel(Long id) {
		if(id == null) return null;
		return (Vessel) sessionFactory.getCurrentSession().get(Vessel.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vessel> findVessels(Country country) {
		if(country == null || country.getId() == null) return new ArrayList<Vessel>();
		return sessionFactory.getCurrentSession().createQuery("from Vessel where country.id = :country order by code")
		.setLong("country", country.getId())
		.list();
	}

	@Override
	public void save(Sailor sailor) {
		sessionFactory.getCurrentSession()
		.saveOrUpdate(sailor);
	}

	@Override
	public Sailor findSailor(Long id) {
		if(id == null) return null;
		return (Sailor) sessionFactory.getCurrentSession().get(Sailor.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sailor> findSailors(Integer start, Integer rows) {
		if(start == null || start < 0) start = 0;
		if(rows == null || rows < 0) rows = 20;
		
		return sessionFactory.getCurrentSession().createQuery("from Sailor s order by s.firstName")
		.setFirstResult(start)
		.setMaxResults(rows)
		.list();
		
	}

	@Override
	public Long countSailors() {
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(s) from Sailor s").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sailor> findSailors(Vessel vessel, Integer start, Integer rows) {
		if(vessel == null || vessel.getId() == null) return new ArrayList<Sailor>();
		if(start == null || start < 0) start = 0;
		if(rows == null || rows < 0) rows = 20;
		
		return sessionFactory.getCurrentSession().createQuery("from Sailor s where s.vessel.id = :vessel order by s.firstName")
		.setLong("vessel", vessel.getId())
		.setFirstResult(start)
		.setMaxResults(rows)
		.list();
	}

	@Override
	public Long countSailors(Vessel vessel) {
		if(vessel == null || vessel.getId() == null) return 0L;
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(s) from Sailor s where s.vessel.id = :vessel")
		.setLong("vessel", vessel.getId()).uniqueResult();
	}

}

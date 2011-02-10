package com.artivisi.sailorman.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.artivisi.sailorman.domain.Assignment;
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
	public List<Vessel> findVessels() {
		return sessionFactory.getCurrentSession().createQuery("from Vessel order by code")
		.list();
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
	public List<Sailor> findSailors() {
		return sessionFactory.getCurrentSession().createQuery("from Sailor s order by s.name")
		.list();
		
	}

	@Override
	public Long countSailors() {
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(s) from Sailor s").uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sailor> findSailors(String name) {
		if(!StringUtils.hasLength(name)) return new ArrayList<Sailor>();
		
		return sessionFactory.getCurrentSession().createQuery("from Sailor s where lower(s.name) like :name order by s.name")
		.setString("name", "%"+name.toLowerCase()+"%")
		.list();
	}

	@Override
	public Long countSailors(String name) {
		if(!StringUtils.hasText(name)) return 0L;
		return (Long) sessionFactory.getCurrentSession().createQuery("select count(s) from Sailor s where s.name like :name")
		.setString("name", "%"+name+"%").uniqueResult();
	}

	@Override
	public void save(Assignment assignment) {
		sessionFactory.getCurrentSession().saveOrUpdate(assignment);
		
	}
	
	@Override
	public void delete(Assignment assignment) {
		if(assignment != null && assignment.getId() != null) {
			sessionFactory.getCurrentSession().delete(assignment);
		}
		
	}
	
	@Override
	public Assignment findAssignment(Long id) {
		if(id == null) return null;
		return (Assignment) sessionFactory.getCurrentSession().get(Assignment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> findAssignment(Sailor sailor) {
		if(sailor == null || sailor.getId() == null) return new ArrayList<Assignment>();
		return sessionFactory.getCurrentSession().createQuery("from Assignment a where a.sailor.id = :sailor order by a.signon ")
		.setLong("sailor", sailor.getId())
		.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Assignment> findAssignment(Vessel vessel) {
		if(vessel == null || vessel.getId() == null) return new ArrayList<Assignment>();
		return sessionFactory.getCurrentSession().createQuery("from Assignment a where a.vessel.id = :vessel order by a.signon ")
		.setLong("vessel", vessel.getId())
		.list();
	}

}

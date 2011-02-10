package com.artivisi.sailorman.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity @Table(name="t_assignment")
public class Assignment {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_sailor", nullable=false)
	@NotNull
	private Sailor sailor;
	@ManyToOne
	@JoinColumn(name="id_vessel", nullable=false)
	@NotNull
	private Vessel vessel;
	
	@Column(name="gt")
	private String assignmentGt;
	
	@Column(name="assignment_type")
	private String type;
	@Column(name="assignment_flag")
	private String flag;
	private String rank;
	
	@Column(name="fishing_area")
	private String fishingArea;
	
	@Temporal(TemporalType.DATE)
	private Date signon;
	@Temporal(TemporalType.DATE)
	private Date signoff;
	private String term;
	private BigDecimal salary;
	private BigDecimal bonus;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Sailor getSailor() {
		return sailor;
	}
	public void setSailor(Sailor sailor) {
		this.sailor = sailor;
	}
	public Vessel getVessel() {
		return vessel;
	}
	public void setVessel(Vessel vessel) {
		this.vessel = vessel;
	}
	public String getAssignmentGt() {
		return assignmentGt;
	}
	public void setAssignmentGt(String assignmentGt) {
		this.assignmentGt = assignmentGt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getFishingArea() {
		return fishingArea;
	}
	public void setFishingArea(String fishingArea) {
		this.fishingArea = fishingArea;
	}
	public Date getSignon() {
		return signon;
	}
	public void setSignon(Date signon) {
		this.signon = signon;
	}
	public Date getSignoff() {
		return signoff;
	}
	public void setSignoff(Date signoff) {
		this.signoff = signoff;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public BigDecimal getBonus() {
		return bonus;
	}
	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}
	
	
	
}

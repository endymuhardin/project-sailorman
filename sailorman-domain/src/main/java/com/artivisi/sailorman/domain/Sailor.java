package com.artivisi.sailorman.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity @Table(name="m_sailor")
public class Sailor {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="name", nullable=false)
	@NotNull
	@NotEmpty
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	@NotNull
	private Date birthdate;
	
	@Column(nullable=false)
	@NotNull
	@NotEmpty
	private String birthplace;
	private String phone;
	private Integer children;
	private String religion;

	@Column(name="passport_number")
	private String passportNumber;
	@Column(name="passport_issue_date")
	@Temporal(TemporalType.DATE)
	private Date passportIssueDate;
	@Column(name="passport_expire_date")
	@Temporal(TemporalType.DATE)
	private Date passportExpireDate;
	@Column(name="passport_issue_place")
	private String passportIssuePlace;
	
	@Column(name="seaman_book_number")
	private String seamanBookNumber;
	@Column(name="seaman_book_issue_date")
	@Temporal(TemporalType.DATE)
	private Date seamanBookIssueDate;
	@Column(name="seaman_book_expire_date")
	@Temporal(TemporalType.DATE)
	private Date seamanBookExpireDate;
	@Column(name="seaman_book_issue_place")
	private String seamanBookIssuePlace;

	@Column(name="license_number")
	private String licenseNumber;
	@Column(name="license_issue_date")
	@Temporal(TemporalType.DATE)
	private Date licenseIssueDate;
	@Column(name="license_expire_date")
	@Temporal(TemporalType.DATE)
	private Date licenseExpireDate;
	@Column(name="license_issue_place")
	private String licenseIssuePlace;
	
	
	private BigDecimal height;
	private BigDecimal weight;
	private String cloth;
	private String glove;
	private BigDecimal shoe;
	private Boolean smoking;
	
	private BigDecimal newSalary;
	
	private String photo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(BigDecimal newSalary) {
		this.newSalary = newSalary;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getPassportIssueDate() {
		return passportIssueDate;
	}

	public void setPassportIssueDate(Date passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}

	public Date getPassportExpireDate() {
		return passportExpireDate;
	}

	public void setPassportExpireDate(Date passportExpireDate) {
		this.passportExpireDate = passportExpireDate;
	}

	public String getPassportIssuePlace() {
		return passportIssuePlace;
	}

	public void setPassportIssuePlace(String passportIssuePlace) {
		this.passportIssuePlace = passportIssuePlace;
	}

	public String getSeamanBookNumber() {
		return seamanBookNumber;
	}

	public void setSeamanBookNumber(String seamanBookNumber) {
		this.seamanBookNumber = seamanBookNumber;
	}

	public Date getSeamanBookIssueDate() {
		return seamanBookIssueDate;
	}

	public void setSeamanBookIssueDate(Date seamanBookIssueDate) {
		this.seamanBookIssueDate = seamanBookIssueDate;
	}

	public Date getSeamanBookExpireDate() {
		return seamanBookExpireDate;
	}

	public void setSeamanBookExpireDate(Date seamanBookExpireDate) {
		this.seamanBookExpireDate = seamanBookExpireDate;
	}

	public String getSeamanBookIssuePlace() {
		return seamanBookIssuePlace;
	}

	public void setSeamanBookIssuePlace(String seamanBookIssuePlace) {
		this.seamanBookIssuePlace = seamanBookIssuePlace;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Date getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(Date licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	public Date getLicenseExpireDate() {
		return licenseExpireDate;
	}

	public void setLicenseExpireDate(Date licenseExpireDate) {
		this.licenseExpireDate = licenseExpireDate;
	}

	public String getLicenseIssuePlace() {
		return licenseIssuePlace;
	}

	public void setLicenseIssuePlace(String licenseIssuePlace) {
		this.licenseIssuePlace = licenseIssuePlace;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getCloth() {
		return cloth;
	}

	public void setCloth(String cloth) {
		this.cloth = cloth;
	}

	public String getGlove() {
		return glove;
	}

	public void setGlove(String glove) {
		this.glove = glove;
	}

	public BigDecimal getShoe() {
		return shoe;
	}

	public void setShoe(BigDecimal shoe) {
		this.shoe = shoe;
	}

	public Boolean getSmoking() {
		return smoking;
	}

	public void setSmoking(Boolean smoking) {
		this.smoking = smoking;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}

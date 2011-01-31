package com.artivisi.sailorman.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@SuppressWarnings("serial")
@Entity @Table(name="m_country")
public class Country implements Serializable {
	
	@Id @GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	@Column(unique=true, nullable=false)
	private String code;
	
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

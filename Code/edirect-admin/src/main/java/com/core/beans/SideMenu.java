package com.core.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SideMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String page;

	@PostConstruct
	public void init() {
		page = "overview"; // Default include.
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

}

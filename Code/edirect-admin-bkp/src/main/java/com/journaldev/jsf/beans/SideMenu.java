package com.journaldev.jsf.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class SideMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private String page;

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		System.out.println("XXXXSUCCESS" + file == null);
		this.file = file;
	}

	public void upload() {
		page = "1";
		if (file != null) {
			System.out.println("Succesful: " + file.getFileName() + " is uploaded.");
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void init() {
		page = "1"; // Default include.
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void navigate(String page) {
		this.page = page;
		// RequestContext.getCurrentInstance().update("content");
		// RequestContext.getCurrentInstance().update("form-content"); // Update
	}

}

package com.journaldev.jsf.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		System.out.println("XXXXSUCCESS" + file == null);
		this.file = file;
	}

	public void upload() {
		System.out.println("success");
		
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/admin/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		file = null;
	}

}

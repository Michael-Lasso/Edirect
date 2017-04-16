/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author gonza
 */
@ManagedBean(name = "login")
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dummyEmail;
	private String dummyPassword;
	private Boolean loggedIn;

	@PostConstruct
	public void init() {
		loggedIn = false;
		dummyEmail = "user@id.com";
		dummyPassword = "123";
	}

	public void login(String email, String pass) {
		if (email.equals(dummyEmail) && pass.equals(dummyPassword)) {
			loggedIn = true; // user correct!
			update();
		} else {
			RequestContext.getCurrentInstance().execute("alert('Email or password wrong!')");
		}
	}

	public void logout() {
		this.loggedIn = false;
		update();
	}

	public void update() {
		RequestContext.getCurrentInstance().update("form-login");
		RequestContext.getCurrentInstance().update("form-content"); // Update
																	// view
		RequestContext.getCurrentInstance()
				.execute("hljs.initHighlighting.called = false;hljs.initHighlightingOnLoad();");
	}

	public String getDummyEmail() {
		return dummyEmail;
	}

	public void setDummyEmail(String dummyEmail) {
		this.dummyEmail = dummyEmail;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	private String beanCode = "bean";

	public String getBeanCode() {
		return beanCode;
	}

	public void setBeanCode(String beanCode) {
		this.beanCode = beanCode;
	}

	private String dependencies = "<dependency>";

	public String getDependencies() {
		return dependencies;
	}

	public void setDependencies(String dependencies) {
		this.dependencies = dependencies;
	}

	private String webXml = "xml";

	public String getWebXml() {
		return webXml;
	}

	public void setWebXml(String webXml) {
		this.webXml = webXml;
	}

	private String js = "js";

	public String getJs() {
		return js;
	}

	public void setJs(String js) {
		this.js = js;
	}

	private String xhtml = "xhtml";

	public String getXhtml() {
		return xhtml;
	}

	public void setXhtml(String xhtml) {
		this.xhtml = xhtml;
	}

}

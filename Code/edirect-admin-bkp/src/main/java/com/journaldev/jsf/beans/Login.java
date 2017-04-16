package com.journaldev.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependency;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.journaldev.jsf.dao.LoginDAO;
import com.journaldev.jsf.util.SessionUtils;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	// validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			return "login";
		}
	}

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

		HttpSession session = SessionUtils.getSession();
		session.invalidate();

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

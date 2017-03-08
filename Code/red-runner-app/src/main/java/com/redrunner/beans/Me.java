package com.redrunner.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class Me implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private Part file;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@PostConstruct
	public void init() {
		name = "Michael";
	}
	
	public void save() {
	    try  {
	    	InputStream input = file.getInputStream();
	    	BufferedReader in = new BufferedReader(new InputStreamReader(input));
	        String line;

	        List<String> responseData = new ArrayList<String>();
	        while ((line = in.readLine()) != null) {
//	           System.out.println(line);
	           responseData.add(line);
	        }
	        System.out.println("file contains the following lines:");
	        responseData.forEach(System.out::println);
//	        Files.copy(input, new File(uploads, filename).toPath());
	    }
	    catch (IOException e) {
	        // Show faces message?
	    }
	}
}

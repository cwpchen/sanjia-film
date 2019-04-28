package com.sj.common.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;	
	private String pass;
	
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

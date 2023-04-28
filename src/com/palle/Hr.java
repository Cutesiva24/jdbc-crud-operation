package com.palle;

public class Hr
{
     private int id;
     private String name ;
     private String email;
     private int exp;
     private long mobile;
	public Hr(int id, String name, String email, int exp, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.exp = exp;
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
     
     
}

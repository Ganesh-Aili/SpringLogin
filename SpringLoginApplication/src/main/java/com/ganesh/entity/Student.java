package com.ganesh.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	@NotEmpty
	private String srollno;
	@NotEmpty
	private String sname;
	@NotEmpty
	private String semail;
	@NotEmpty
	private double smarks;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSrollno() {
		return srollno;
	}
	public void setSrollno(String srollno) {
		this.srollno = srollno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public double getSmarks() {
		return smarks;
	}
	public void setSmarks(double smarks) {
		this.smarks = smarks;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", srollno=" + srollno + ", sname=" + sname + ", semail=" + semail + ", smarks="
				+ smarks + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

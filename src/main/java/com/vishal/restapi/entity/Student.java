package com.vishal.restapi.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "roll_no")
	private int rollNo;

	@Column(name = "student_branch")
	private String branch;

	@Column(name = "student_name")
	private String name;

	@Column(name = "student_percentage")
	private int percentage;

	public Student() {

	}

	public Student(String name, int percentage, String branch) {
		super();
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", percentage=" + percentage + ", branch=" + branch
				+ ", getRollNo()=" + getRollNo() + ", getName()=" + getName() + ", getPercentage()=" + getPercentage()
				+ ", getBranch()=" + getBranch() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}

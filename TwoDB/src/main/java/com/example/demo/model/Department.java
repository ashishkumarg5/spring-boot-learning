package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dept")
public class Department {
	
	@Id
	int deptid;
	
	String deptname;
	int studentcount;
	public int getDeptId() {
		return deptid;
	}
	public void setDeptId(int deptId) {
		this.deptid = deptId;
	}
	public String getDeptName() {
		return deptname;
	}
	public void setDeptName(String deptName) {
		this.deptname = deptName;
	}
	public int getStudentCount() {
		return studentcount;
	}
	public void setStudentCount(int studentCount) {
		this.studentcount = studentCount;
	}
	
	
}

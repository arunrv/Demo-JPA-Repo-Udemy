package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
public class Department 
{
	@Id
	@GeneratedValue
	private long did;
	private String dname;
	private String loc;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="deptdetails")
	Employee emp;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	public Department() {
	}
	
	
	public Department(String dname, String loc) {
		this.dname = dname;
		this.loc = loc;
	}



	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", loc=" + loc + ", emp=" + emp + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

	

	public long getDid() {
		return did;
	}

	public void setDid(long did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	
	

}

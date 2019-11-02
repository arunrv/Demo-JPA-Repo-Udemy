package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PropellerShaftKit")
public class PropellerShaftKit 
{
	@Id
	String kitid;
	String status;
	String areacode;
	public String getKitid() {
		return kitid;
	}
	public void setKitid(String kitid) {
		this.kitid = kitid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	

}

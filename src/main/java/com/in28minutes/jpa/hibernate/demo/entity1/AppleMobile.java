package com.in28minutes.jpa.hibernate.demo.entity1;

import javax.persistence.Entity;

@Entity
public class AppleMobile extends Mobile
{
	String iosVersion;
	int price;
	
	
	public AppleMobile() 
	{
		super();
	}

	public AppleMobile(String brand, String iosVersion, int price) 
	{
		super(brand);
		this.iosVersion = iosVersion;
		this.price = price;
	}

	public String getOperatingSystem() {
		return iosVersion;
	}

	public void setOperatingSystem(String iosVersion) {
		this.iosVersion = iosVersion;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

package com.in28minutes.jpa.hibernate.demo.entity1;

import javax.persistence.Entity;

@Entity
public class SamsungMobile extends Mobile
{
	String androidVersion;
	int price;
	
	
	public SamsungMobile() 
	{
		super();
	}

	public SamsungMobile(String brand, String androidVersion, int price) 
	{
		super(brand);
		this.androidVersion = androidVersion;
		this.price = price;
	}

	public String getOperatingSystem() {
		return androidVersion;
	}

	public void setOperatingSystem(String iosVersion) {
		this.androidVersion = iosVersion;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}


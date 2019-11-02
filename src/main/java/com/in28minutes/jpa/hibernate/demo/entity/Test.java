package com.in28minutes.jpa.hibernate.demo.entity;

enum Beer
{
	KF, KO, SIGNATURE, WHITEOWL
}
public class Test 
{
	public static void main(String[] args) 
	{
		Beer kf = Beer.KF;
		System.out.println(kf);
		
	}
}

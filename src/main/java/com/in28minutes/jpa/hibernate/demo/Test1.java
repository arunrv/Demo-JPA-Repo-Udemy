package com.in28minutes.jpa.hibernate.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test1 
{
	public static void main(String[] args) {
		 
		LocalDate date1 = LocalDate.now();
		LocalDateTime date2=LocalDateTime.now();
		String date3 = LocalDate.now().toString();
		String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
		String date4=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")).toString();
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(today);
		System.out.println(date4);
	}

}

package com.in28minutes.jpa.hibernate.demo;


import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BooksController 
{
	@RequestMapping("/books")
	public List<Book> getBooks()
	{
		return Arrays.asList(new Book(100l, "SpringBoot - 5.01", "Arun"));
	}

}

package com.zwj.book.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwj.book.base.ResultBody;
import com.zwj.book.base.ResultBodyFactory;
import com.zwj.book.entity.Book;
import com.zwj.book.service.BookService;

@RestController
public class BookController {
	@Autowired
	public BookService bookService;

	@PostMapping("/addBook")
	public ResultBody addBook(@RequestBody Book book) {
		bookService.add(book);
		return ResultBodyFactory.createOKResultBody();
	}

	@PostMapping("/updateBook")
	public ResultBody updateBook(@RequestBody Book book) {
		bookService.update(book);
		return ResultBodyFactory.createOKResultBody();
	}

	@PostMapping("/deleteBookById")
	public ResultBody deleteById(String ids) {
		bookService.delete(ids);
		return ResultBodyFactory.createOKResultBody();
	}

	@GetMapping("/getAllBooks")
	public ResultBody getAllBooks(Map<String, Object> map) {
		return ResultBodyFactory.createOKResultBody(bookService.getBooks(map));
	}

	@RequestMapping("/getBookById")
	public ResultBody getBookById(String id) {
		Book Book = bookService.getBookById(id);
		return ResultBodyFactory.createOKResultBody(Book);
	}
}

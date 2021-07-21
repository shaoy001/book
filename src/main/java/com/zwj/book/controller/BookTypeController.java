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
import com.zwj.book.entity.BookType;
import com.zwj.book.service.BookTypeService;

@RestController
public class BookTypeController {
	@Autowired
	public BookTypeService bookTypeService;

	@PostMapping("/addBookType")
	public ResultBody addUser(@RequestBody BookType bookType) {
		bookTypeService.add(bookType);
		return ResultBodyFactory.createOKResultBody();
	}

	@PostMapping("/updateBookType")
	public ResultBody updateUser(@RequestBody BookType bookType) {
		bookTypeService.update(bookType);
		return ResultBodyFactory.createOKResultBody();
	}

	@PostMapping("/deleteBookTypeById")
	public ResultBody deleteById(String ids) {
		bookTypeService.delete(ids);
		return ResultBodyFactory.createOKResultBody();
	}

	@GetMapping("/getAllBookTypes")
	public ResultBody getAllBookTypes(Map<String, Object> map) {
		return ResultBodyFactory.createOKResultBody(bookTypeService.getAllBookTypes(map));
	}

	@GetMapping("/getBookTypes")
	public ResultBody getBookTypes() {
		return ResultBodyFactory.createOKResultBody(bookTypeService.getBookTypes());
	}

	@RequestMapping("/getBookTypeById")
	public ResultBody getBookById(String id) {
		BookType bookType = bookTypeService.getBookTypeById(id);
		return ResultBodyFactory.createOKResultBody(bookType);
	}
}

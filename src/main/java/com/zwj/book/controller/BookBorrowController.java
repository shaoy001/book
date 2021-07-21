package com.zwj.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwj.book.base.ResultBody;
import com.zwj.book.base.ResultBodyFactory;
import com.zwj.book.entity.BookBorrowInfo;
import com.zwj.book.service.BookBorrowService;

@RestController
public class BookBorrowController {
	@Autowired
	public BookBorrowService bookBorrowService;

	@RequestMapping("/getAllBookBorrowInfo")
	public ResultBody getAllBookBorrowInfo() {

		return ResultBodyFactory.createOKResultBody(bookBorrowService.getAllBookBorrowInfo());
	}

	@RequestMapping("/getBorrowInfosByUserId")
	public ResultBody getBorrowInfosByUserId(String userId) {
		return ResultBodyFactory.createOKResultBody(bookBorrowService.getBorrowInfosByUserId(userId));
	}

	@RequestMapping("/insertBookBorrowInfo")
	public ResultBody insertBookBorrowInfo(@RequestBody BookBorrowInfo info) {
		bookBorrowService.insertBookBorrowInfo(info);
		return ResultBodyFactory.createOKResultBody();
	}

	@RequestMapping("/updateBookBorrowInfo")
	public ResultBody getBookById(@RequestBody BookBorrowInfo info) {
		bookBorrowService.updateBookBorrowInfo(info);
		return ResultBodyFactory.createOKResultBody();
	}
}

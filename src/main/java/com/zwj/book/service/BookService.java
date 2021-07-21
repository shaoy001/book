package com.zwj.book.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwj.book.dao.BookMapper;
import com.zwj.book.entity.Book;
import com.zwj.book.entity.BookObj;

@Service
public class BookService {
	@Autowired
	public BookMapper bookMapper;

	@Transactional
	public void add(Book book) {
		bookMapper.insertBook(book);
	}

	@Transactional
	public void update(Book book) {
		bookMapper.updateBook(book);
	}

	@Transactional
	public void delete(String ids) {
		if (ids.contains(",")) {
			String[] idArray = ids.split(",");
			List<String> idList = Arrays.asList(idArray);
			bookMapper.deleteBookByIds(idList);
		} else {
			bookMapper.deleteBookById(Integer.parseInt(ids));
		}
	}

	public List<BookObj> getBooks(Map<String, Object> map) {
		return bookMapper.getBooks(map);
	}

	public Book getBookById(String bookId) {
		return bookMapper.findById(bookId);
	}
}

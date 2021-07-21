package com.zwj.book.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwj.book.dao.BookTypeMapper;
import com.zwj.book.entity.BookType;

@Service
public class BookTypeService {
	@Autowired
	public BookTypeMapper bookTypeMapper;

	@Transactional
	public void add(BookType bookType) {
		bookTypeMapper.insertBookType(bookType);
	}

	@Transactional
	public void update(BookType bookType) {
		bookTypeMapper.updateBookType(bookType);
	}

	@Transactional
	public void delete(String ids) {
		if (ids.contains(",")) {
			String[] idArray = ids.split(",");
			List<String> idList = Arrays.asList(idArray);
			bookTypeMapper.deleteBookTypeByIds(idList);
		} else {
			bookTypeMapper.deleteBookTypeById(Integer.parseInt(ids));
		}
	}

	public List<BookType> getBookTypes() {
		return bookTypeMapper.getBookTypes();
	}

	public List<BookType> getAllBookTypes(Map<String, Object> map) {

		return bookTypeMapper.getAllBookTypes(map);
	}

	public BookType getBookTypeById(String id) {
		return bookTypeMapper.findById(id);
	}
}

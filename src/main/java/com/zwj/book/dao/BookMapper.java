package com.zwj.book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zwj.book.entity.Book;
import com.zwj.book.entity.BookObj;

@Mapper
public interface BookMapper {
	Book findById(String BookId);

	int getBookCnt(Map<String, Object> map);

	List<BookObj> getBooks(Map<String, Object> map);

	int deleteBookByIds(List<String> list);

	int deleteBookById(int id);

	int updateBook(Book b);

	int insertBook(Book b);

}
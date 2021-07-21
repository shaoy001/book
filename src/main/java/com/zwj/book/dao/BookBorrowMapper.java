package com.zwj.book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zwj.book.entity.BookBorrowInfo;

@Mapper
public interface BookBorrowMapper {

	List<BookBorrowInfo> getBookBorrowInfos(Map<String, Object> map);

	List<BookBorrowInfo> getBorrowInfosByUserId(String userId);;

	int updateBookBorrowInfo(BookBorrowInfo info);

	int insertBookBorrowInfo(BookBorrowInfo info);

	int checkBookBorrrow(BookBorrowInfo info);

}
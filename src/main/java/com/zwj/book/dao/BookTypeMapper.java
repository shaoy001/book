package com.zwj.book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zwj.book.entity.BookType;

@Mapper
public interface BookTypeMapper {
	BookType findById(String BookId);

	int getBookTypeCnt(Map<String, Object> map);

	List<BookType> getAllBookTypes(Map<String, Object> map);

	int deleteBookTypeByIds(List<String> list);

	int deleteBookTypeById(int id);

	int updateBookType(BookType b);

	int insertBookType(BookType b);

	List<BookType> getBookTypes();

}
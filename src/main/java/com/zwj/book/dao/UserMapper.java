package com.zwj.book.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.zwj.book.entity.User;

@Mapper
public interface UserMapper {
	User findByName(String username);

	User findById(String userId);

	int getUserCnt(Map<String, Object> map);

	List<User> getUsers(Map<String, Object> map);

	int deleteUserByIds(List<String> list);

	int deleteUserById(int id);

	int updateUser(User u);

	int insertUser(User u);

	List<User> getUsersSelect();

}
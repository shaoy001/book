package com.zwj.book.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwj.book.base.BizException;
import com.zwj.book.dao.UserMapper;
import com.zwj.book.entity.PasswordObj;
import com.zwj.book.entity.User;
import com.zwj.book.entity.UserObj;

@Service
public class UserService {
	@Autowired
	public UserMapper userMapper;

	/**
	 * login
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
		User dbUser = new User();
		try {
			subject.login(token);
			dbUser = (User) subject.getPrincipal();
		} catch (UnknownAccountException e) {
			throw new BizException("101", "用户名不存在");
		} catch (IncorrectCredentialsException e) {
			throw new BizException("102", "密码错误");
		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw new BizException("103", "登录失败，请稍后重试");
		}
		return dbUser;

	}

	@Transactional
	public void add(User user) {
		User user2 = userMapper.findByName(user.getName());
		if (user2 != null) {
			throw new BizException("104", "该用户名已经存在");
		}
		userMapper.insertUser(user);
	}

	@Transactional
	public void update(User user) {
		User user2 = userMapper.findById(String.valueOf(user.getId()));
		if (!user2.getName().equals(user.getName())) {
			User user3 = userMapper.findByName(user.getName());
			if (user3 != null) {
				throw new BizException("105", "该用户名已经存在");
			}
		}
		userMapper.updateUser(user);
	}

	@Transactional
	public void delete(String ids) {
		if (ids.contains(",")) {
			String[] idArray = ids.split(",");
			List<String> idList = Arrays.asList(idArray);
			userMapper.deleteUserByIds(idList);
		} else {
			userMapper.deleteUserById(Integer.parseInt(ids));
		}

	}

	public List<UserObj> getUsers(Map<String, Object> map) {
		List<User> users = userMapper.getUsers(map);
		List<UserObj> userObjs = new ArrayList<>();
		users.stream().forEach(u -> {
			UserObj userObj = new UserObj();
			try {
				BeanUtils.copyProperties(userObj, u);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			if (u.getSex() == 1) {
				userObj.setSex("男");
			} else {
				userObj.setSex("女");
			}
			userObjs.add(userObj);
		});
		return userObjs;
	}

	public User getUserById(String userId) {
		return userMapper.findById(userId);
	}

	public void logout() {
		SecurityUtils.getSubject().logout();

	}

	public void modifyPassword(PasswordObj obj) {
		if (!obj.getPassword().equals(obj.getConfirmPassword())) {
			throw new BizException("106", "新密码和确认密码不一致");
		}
		User updateUser = new User();
		updateUser.setId(obj.getId());
		updateUser.setPassword(obj.getPassword());
		userMapper.updateUser(updateUser);

	}

	public List<User> getUsers() {
		List<User> users = userMapper.getUsersSelect();
		return users;
	}
}

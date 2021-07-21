package com.zwj.book.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zwj.book.base.ResultBody;
import com.zwj.book.base.ResultBodyFactory;
import com.zwj.book.entity.PasswordObj;
import com.zwj.book.entity.User;
import com.zwj.book.service.UserService;

@RestController
public class UserController {
	@Autowired
	public UserService userService;

	@GetMapping("/toLogin")
	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView("/login.html");
		return mav;
	}

	@PostMapping("/login")
	public ResultBody login(@RequestBody User user) {
		return ResultBodyFactory.createOKResultBody(userService.login(user));
	}

	@PostMapping("/addUser")
	public ResultBody addUser(@RequestBody User user) {
		userService.add(user);
		return ResultBodyFactory.createOKResultBody();
	}

	@PostMapping("/updateUser")
	public ResultBody updateUser(@RequestBody User user) {
		userService.update(user);
		return ResultBodyFactory.createOKResultBody();
	}

	@RequestMapping("/getUserById")
	public ResultBody getUserById(String userId) {
		User user = userService.getUserById(userId);
		return ResultBodyFactory.createOKResultBody(user);
	}

	@PostMapping("/deleteUserById")
	public ResultBody deleteById(String ids) {
		userService.delete(ids);
		return ResultBodyFactory.createOKResultBody();
	}

	@GetMapping("/getAllUsers")
	public ResultBody getAllUsers(Map<String, Object> map) {
		return ResultBodyFactory.createOKResultBody(userService.getUsers(map));
	}

	@GetMapping("/getUsers")
	public ResultBody getUsers() {
		return ResultBodyFactory.createOKResultBody(userService.getUsers());
	}

	@GetMapping("/logout")
	public ResultBody logout() {
		userService.logout();
		return ResultBodyFactory.createOKResultBody();
	}

	@PostMapping("/password")
	public ResultBody modifyPassword(@RequestBody PasswordObj obj) {
		userService.modifyPassword(obj);
		return ResultBodyFactory.createOKResultBody();
	}
}

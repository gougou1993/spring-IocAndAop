package com.zhong.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhong.entity.User;
import com.zhong.exception.SpringException;
import com.zhong.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User find(@PathVariable(value = "id") Long id) {
		return this.userService.findById(id);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ExceptionHandler({ SpringException.class })
	public String addUser(@ModelAttribute("user") User user, ModelMap model) {
		if (user.getUsername().length() < 5) {
			throw new SpringException("Given name is too short");
		} else {
			model.addAttribute("name", user.getUsername());
		}

		model.addAttribute("id", user.getId());
		return "result";
	}
}
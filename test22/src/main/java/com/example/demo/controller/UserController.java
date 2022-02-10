package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.GroupOrder;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	  private UserService userService;


//	一覧

	@GetMapping(value = "/user/list")
	  public String displayList(Model model) {
	    List<User> userlist = userService.searchAll();
	    model.addAttribute("userlist", userlist);
	    return "user/list";
	}

	@GetMapping(value = "/user/list/{userid}/delete")
	 public String delete(@PathVariable Long userid, Model model) {
		    userService.delete(userid);
		    return "redirect:/user/list";
	 }



//	新規登録
	@GetMapping(value = "/user/regist")
	  public String displayRegist(Model model) {
	    model.addAttribute("userRequest", new UserRequest());
	    return "user/regist";
	}

	@RequestMapping(value = "/user/regist", method = RequestMethod.POST)
	  public String regist(@Validated(GroupOrder.class) @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			 List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "user/regist";
		    }
		userService.regist(userRequest);
		    return "redirect:/user/list";
	}


//	編集
	@GetMapping(value="/user/{userid}/edit")
	  public String displayEdit(@PathVariable Long userid, Model model) {
	    User user = userService.findById(userid);
	    model.addAttribute("userRequest", user);
	    return "user/edit";
	  }

	@RequestMapping(value = "/user/edit", method = RequestMethod.POST)
	  public String edit(@Validated(GroupOrder.class) @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			 List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
		      model.addAttribute("validationError", errorList);
		      return "user/edit";
		    }
		userService.edit(userRequest);
		    return "redirect:/user/list";
	}

}

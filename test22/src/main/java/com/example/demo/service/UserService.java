package com.example.demo.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

	@Autowired
	  private UserRepository userRepository;

	public List<User> searchAll() {
	    return userRepository.findAll();
	  }

	public void regist(UserRequest userRequest) {
	    Date now = new Date();
	    User user = new User();
	    user.setUsername(userRequest.getUsername());
	    user.setMail(userRequest.getMail());
	    user.setPassword(userRequest.getPassword());
	    user.setPhone(userRequest.getPhone());
	    user.setDate(now);
	    userRepository.save(user);
	  }
	 public User findById(Long userid) {
		    return userRepository.findById(userid).get();
		  }


		public void edit(UserRequest userRequest) {
			User user = findById(userRequest.getUserid());
		    user.setUsername(userRequest.getUsername());
		    user.setMail(userRequest.getMail());
		    user.setPassword(userRequest.getPassword());
		    user.setPhone(userRequest.getPhone());
		    user.setDate(new Date());
		    userRepository.save(user);
		}

		 public void delete(Long userid) {
			    User user = findById(userid);
			    userRepository.delete(user);
			  }


}

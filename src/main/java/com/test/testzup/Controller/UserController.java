package com.test.testzup.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.testzup.Exception.UserDuplicateCpfException;
import com.test.testzup.Exception.UserDuplicateEmailException;
import com.test.testzup.User.User;
import com.test.testzup.User.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Integer> registerUser(@RequestBody @Valid User user) throws UserDuplicateEmailException, UserDuplicateCpfException {
		int id = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}
}

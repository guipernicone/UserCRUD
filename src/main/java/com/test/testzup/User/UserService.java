package com.test.testzup.User;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.testzup.Exception.UserDuplicateCpfException;
import com.test.testzup.Exception.UserDuplicateEmailException;
import com.test.testzup.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	

	@Transactional
	public int saveUser(User user) throws UserDuplicateEmailException, UserDuplicateCpfException {
		
		if (isEmailDuplicate(user)) {
			throw new UserDuplicateEmailException("The email " + user.getEmail() + " is already registered");
		}
		if (isCpfDuplicate(user)) {
			throw new UserDuplicateCpfException("The cpf " + user.getCpf() + " is already registered");
		}
		
		User userSaved = userRepository.save(user);
		return userSaved.getId();
	}
	
	private boolean isEmailDuplicate(User user) {
		
		Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
		
		if (optionalUser.isPresent()) {
			return true;
		}
		return false;
	}

	private boolean isCpfDuplicate(User user) {
		
		Optional<User> optionalUser = userRepository.findByCpf(user.getCpf());
		
		if (optionalUser.isPresent()) {
			return true;
		}
		return false;
	}
}

package com.test.testzup.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.testzup.User.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByCpf(String cpf);
}

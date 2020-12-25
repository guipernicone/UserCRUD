package com.test.testzup.Exception;

@SuppressWarnings("serial")
public class UserDuplicateEmailException extends Exception {
   
	public UserDuplicateEmailException(String errorMessage) {
        super(errorMessage);
    }
}

package com.test.testzup.Exception;

@SuppressWarnings("serial")
public class UserDuplicateCpfException extends Exception{
	
	public UserDuplicateCpfException(String errorMessage) {
        super(errorMessage);
    }
}

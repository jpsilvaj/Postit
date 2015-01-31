package br.edu.ifce.postit.Exception;

public class UserDuplicateException extends Exception{
	
	public UserDuplicateException(){
		super("The user already exists in the database");
	}

}

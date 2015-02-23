package br.edu.ifce.postit.server.exception;

public class UserDuplicateException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6337281422287413666L;

	public UserDuplicateException(){
		super("The user already exists in the database");
	}

}

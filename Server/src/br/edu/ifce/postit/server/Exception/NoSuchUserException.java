package br.edu.ifce.postit.server.Exception;

public class NoSuchUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1349619693559235387L;
	
	public NoSuchUserException(){
		super("The user does not exists in the database");
	}


}

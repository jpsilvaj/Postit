package br.edu.ifce.postit.client.exception;

public class NoteEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1349619693559235387L;
	
	public NoteEmptyException(){
		super("The note has been empty");
	}

}

package br.edu.ifce.postit.client.controller;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import br.edu.ifce.postit.server.controller.NoteController;
import br.edu.ifce.postit.server.controller.UserController;
import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;


public class ClientControllerImpl extends UnicastRemoteObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6974573931541256103L;
	private String username;
	
	
	protected ClientControllerImpl() throws RemoteException {
		super();
		
		// TODO Auto-generated constructor stub
	}

//	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	

}

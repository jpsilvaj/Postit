package br.edu.ifce.postit.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifce.postit.Exception.NoSuchUserException;
import br.edu.ifce.postit.Exception.UserDuplicateException;
import br.edu.ifce.postit.dao.UserDaoImpl;
import br.edu.ifce.postit.model.User;

public class UserControllerImpl extends UnicastRemoteObject implements Serializable,UserController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8916389471925098739L;
	private UserDaoImpl userDao = new UserDaoImpl();
	
	
	protected UserControllerImpl() throws RemoteException {
		super();
	}

	@Override
	public void createUser(User user) {
		try {
			userDao.save(user);
		} catch (UserDuplicateException e) {
			// TODO Informar que o usuário já existe
		}
		
	}

	@Override
	public void deleteUser(User user) {
		try {
			userDao.delete(user);
		} catch (NoSuchUserException e) {
			// TODO Informar que o usuário não existe
		}
	}

}

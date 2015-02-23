package br.edu.ifce.postit.server.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifce.postit.server.dao.UserDaoImpl;
import br.edu.ifce.postit.server.exception.NoSuchUserException;
import br.edu.ifce.postit.server.exception.UserDuplicateException;
import br.edu.ifce.postit.server.model.User;

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
	public void createUser(User user) throws RemoteException{
		try {
			userDao.save(user);
		} catch (UserDuplicateException e) {
			// TODO Informar que o usuário já existe
		}
		
	}

	@Override
	public void deleteUser(User user) throws RemoteException{
		try {
			userDao.delete(user);
		} catch (NoSuchUserException e) {
			// TODO Informar que o usuário não existe
		}
	}

	@Override
	public boolean login(String login, String password) throws RemoteException {
		if(userDao.findByLoginAndPassword(login, password) != null){
			return true;
		}
		return false;
	}

	@Override
	public User findUserByLoginAndPassword(String login, String password)
			throws RemoteException {
		return userDao.findByLoginAndPassword(login, password);
	}
}

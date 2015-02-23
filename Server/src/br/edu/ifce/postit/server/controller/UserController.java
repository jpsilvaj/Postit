package br.edu.ifce.postit.server.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.edu.ifce.postit.server.model.User;

public interface UserController extends Remote{
	public void createUser(User user) throws RemoteException;
	public void deleteUser(User user) throws RemoteException;
	public boolean login(String login, String password) throws RemoteException;
	public User findUserByLoginAndPassword(String login , String password) throws RemoteException;
}

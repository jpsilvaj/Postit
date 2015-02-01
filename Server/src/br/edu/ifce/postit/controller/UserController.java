package br.edu.ifce.postit.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.edu.ifce.postit.model.User;

public interface UserController extends Remote{
	public void createUser(User user) throws RemoteException;
	public void deleteUser(User user) throws RemoteException;
}

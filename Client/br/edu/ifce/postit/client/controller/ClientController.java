package br.edu.ifce.postit.client.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public interface ClientController extends Remote{
	public void exit() throws RemoteException;
	public void createNote(Note note) throws RemoteException;
	public void deleteNote(Note note) throws RemoteException;
	public void createUser(User user) throws RemoteException;
	public void deleteUser(User user) throws RemoteException;
	public void login(String login, String password) throws RemoteException;
}

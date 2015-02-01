package br.edu.ifce.postit.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.edu.ifce.postit.model.Note;
import br.edu.ifce.postit.model.User;

public interface NoteController extends Remote{
	public List<Note> getNotesByUser(User user) throws RemoteException;
	public void updateNote(Note note) throws RemoteException;
}

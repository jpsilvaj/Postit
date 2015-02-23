package br.edu.ifce.postit.server.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public interface NoteController extends Remote{
	public List<Note> getNotesByUser(User user) throws RemoteException;
	public void updateNote(Note note) throws RemoteException;
	public void createNote(Note note) throws RemoteException;
	public void deleteNote(Note note) throws RemoteException;
	public Note findNoteById(int noteInEdition) throws RemoteException;
}

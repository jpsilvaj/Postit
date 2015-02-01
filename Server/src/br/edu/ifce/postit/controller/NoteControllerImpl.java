package br.edu.ifce.postit.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import br.edu.ifce.postit.dao.NoteDaoImpl;
import br.edu.ifce.postit.model.Note;
import br.edu.ifce.postit.model.User;

public class NoteControllerImpl extends UnicastRemoteObject implements Serializable,NoteController{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8716956486794693250L;
	NoteDaoImpl noteDao = new NoteDaoImpl();
	
	protected NoteControllerImpl() throws RemoteException {
		super();
	}

	@Override
	public List<Note> getNotesByUser(User user) {
		return noteDao.listNoteByUser(user);
	}

	@Override
	public void updateNote(Note note) {
		noteDao.update(note);
	}

}

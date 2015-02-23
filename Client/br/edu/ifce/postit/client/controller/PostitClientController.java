package br.edu.ifce.postit.client.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import br.edu.ifce.postit.client.exception.NoteEmptyException;
import br.edu.ifce.postit.client.view.PostitClient;
import br.edu.ifce.postit.server.controller.NoteController;
import br.edu.ifce.postit.server.controller.UserController;
import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public class PostitClientController {

	private static NoteController noteController;
	private static UserController userController;
	private static PostitClient postitClient;
	private static User user;
	private static List<Note> notes;
	
	public static void main(String []args){
		//Naming.rebind("//localhost/"+postitClient.toString(), PostitClient.getClient());
		try {
			noteController = (NoteController) Naming.lookup("//localhost/postitNoteController");
			userController = (UserController) Naming.lookup("//localhost/postitUserController");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		postitClient = new PostitClient();
		if (user != null){
			addNotesToView();
		}
	}
	
	public static void createNote(String noteContent){
		Note note = new Note();
		note.setContent(noteContent);
		note.setUser(user);
		try {
			noteController.createNote(note);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateNote(String noteContent){
		 for(Note note : notes){
			 String contentNoteFromDatabase = note.getContent().substring(1, 5);
			 if (contentNoteFromDatabase.equals(noteContent.substring(1, 5))){
				 note.setContent(noteContent);
				 try {
					noteController.updateNote(note);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 	}
	}
	
	
	
	public static void deleteNote(Note note) {
		try {
			noteController.deleteNote(note);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createUser(String username, String password) {
		User userNew = new User();
		userNew.setLogin(username);
		userNew.setName(username);
		userNew.setPassword(password);
		try {
			userController.createUser(userNew);
			user = userNew;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteUser(User user){
		try {
			userController.deleteUser(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void login(String login, String password){
		try {
			if (userController.login(login, password)){
				user = userController.findUserByLoginAndPassword(login, password);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addNotesToView(){
		try {
			 notes = noteController.getNotesByUser(user);
			 for(Note note : notes){
				 postitClient.getListNotesPanel().addNoteToPanel(note.getContent().substring(0, 5));
				 postitClient.pack();
			 }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String findNoteByContent(String content) throws NoteEmptyException{
		for(Note note: notes){
			String contentFromDatabase = note.getContent().substring(0, 5);
			if (contentFromDatabase.equals(content)){
				return note.getContent();
			}
		}
		throw new NoteEmptyException();
	}

	public static void openNote(String noteTitle) {
		try {
			String note = findNoteByContent(noteTitle);
			postitClient.setNoteInPostitPanel(note);
		} catch (NoteEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

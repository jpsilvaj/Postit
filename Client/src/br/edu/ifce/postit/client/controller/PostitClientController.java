package br.edu.ifce.postit.client.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import br.edu.ifce.postit.client.exception.NoteEmptyException;
import br.edu.ifce.postit.client.util.TimerUpdateListOfNotes;
import br.edu.ifce.postit.client.util.TimerUpdateNoteContent;
import br.edu.ifce.postit.client.view.PostitClient;
import br.edu.ifce.postit.server.controller.NoteController;
import br.edu.ifce.postit.server.controller.UserController;
import br.edu.ifce.postit.server.exception.NoSuchUserException;
import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public class PostitClientController {

	private static NoteController noteController;
	private static UserController userController;
	private static PostitClient postitClient;
	private static User user;
	private static List<Note> notes;
	private static Integer noteInEdition;
	private static Integer userLogged;
	
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
		while(user == null){
			postitClient.login();
			
		}
		addNotesToView();
		postitClient.setTitle("Postit client - RMI - " + user.getLogin());
		Timer timerUpdateClients = new Timer();
		Timer timerUpdateNoteContent = new Timer();
		timerUpdateClients.schedule(new TimerUpdateListOfNotes(), 0, 5*1000);
//		timerUpdateNoteContent.schedule(new TimerUpdateNoteContent(),0, 1*100);
	}
	
	public static void createNote(String noteContent){
		Note note = new Note();
		note.setContent(noteContent);
		note.setUser(user);
		note.setId(null);
		try {
			noteController.createNote(note);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateNote(String noteContent){
		Note note = new Note();
		try {
			note = noteController.findNoteById(noteInEdition);
			if(note != null && !note.getContent().equals(noteContent)){
				note.setContent(noteContent);
				noteController.updateNote(note);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if(user.getId() == userLogged){
				postitClient.showNotAllowedRemoveTheUser();
			}
			else{
				userController.deleteUser(user);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void login(String login, String password){
		try {
			if (userController.login(login, password)){
				user = userController.findUserByLoginAndPassword(login, password);
				userLogged = user.getId();
				if(postitClient != null){
					postitClient.setTitle("Postit client - RMI - " + user.getLogin());
					PostitClientController.addNotesToView();
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NoSuchUserException e) {
			postitClient.login();
			e.printStackTrace();
		}
		
	}
	
	public static void addNotesToView(){
		try {
			 Boolean empty = true;
			 notes = noteController.getNotesByUser(user);
			 postitClient.getListNotesPanel().removeAllLabels();
			 for(Note note : notes){
				 if(note != null){
					 String titleNote = note.getId() + ": " + getTitleFromNote(note.getContent());
					 postitClient.getListNotesPanel().addNoteToPanel(titleNote);
					 empty=false;
				 }
			 }
			 if(empty){
				 postitClient.getPostitPanel().clearNoteContentTextArea();
			 }
			 postitClient.pack();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String findNoteByContent(String content) throws NoteEmptyException{
		for(Note note: notes){
			String contentFromDatabase = note.getContent();
			if (getTitleFromNote(contentFromDatabase).equals(content) ){
				return contentFromDatabase;
			}
		}
		throw new NoteEmptyException();
	}

	public static void openNote(int noteId) {
		try {
			Note note = noteController.findNoteById(noteId);
			postitClient.setNoteInPostitPanel(note.getContent());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static String getTitleFromNote(String note){
		 if(note.length() >=10 )
			 return note.substring(0, 10);
		 else
			 return note;
	}

	public static Integer getNoteInEdition() {
		return noteInEdition;
	}

	public static void setNoteInEdition(Integer noteInEdition) {
		PostitClientController.noteInEdition = noteInEdition;
	}
	
	public static List<String> getNotesTitle(){
		ArrayList<String> notesName = new ArrayList<String>();
		for(Note note : notes){
			String titleOfNote = note.getId()+": " + getTitleFromNote(note.getContent());
			notesName.add(titleOfNote);
		}
		return notesName;
	}

	public static Note findNoteById(int id) {
		try {
			return noteController.findNoteById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<String> getUsernames() {
		try {
			List<User> users = userController.listUsers();
			ArrayList<String> usernames = new ArrayList<String>();
			for(User user : users){
				usernames.add(user.getId() + ": " + user.getLogin());
			}
			return usernames;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static User findUserById(int id) {
		try {
			return userController.findUserById(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int getUserLogged() {
		return userLogged;
	}

	public static void setUserLogged(int userLogged) {
		PostitClientController.userLogged = userLogged;
	}
}

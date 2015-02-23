package br.edu.ifce.postit.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

import br.edu.ifce.postit.client.controller.PostitClientController;
import br.edu.ifce.postit.client.util.Constants;
import br.edu.ifce.postit.client.util.PostitDialogs;
import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "exit"){
			try{
				//TODO:ClientControllerImpl.exit();
			}catch(Exception exception){
				exception.printStackTrace();
			}
			finally{
				System.exit(0);
			}
		}
		else if(e.getActionCommand() == "create_note"){
			PostitClientController.createNote(Constants.NEW_NOTE);
			PostitClientController.addNotesToView();
		}
		else if(e.getActionCommand() == "delete_note"){
			String noteTitleToDelete = inputNoteSelected("Select note to delete");
			int id = new Integer(noteTitleToDelete.split(":")[0]);
			Note note = PostitClientController.findNoteById(id);
			PostitClientController.deleteNote(note);
			PostitClientController.addNotesToView();
		}
		else if(e.getActionCommand() == "login"){
			String username = PostitDialogs.showInputDialog("Insira o nome do usuário");
			String password = PostitDialogs.showInputDialog("Insira a senha do usuário");
			if(username != null && password != null){
				PostitClientController.login(username, password);
			}
		}
		else if(e.getActionCommand() == "create_user"){
			//TODO: Show input to name and password
			String username = PostitDialogs.showInputDialog("Insira o nome do usuário");
			String password = PostitDialogs.showInputDialog("Insira a senha do usuário");
			if(username != null && password != null){
				PostitClientController.createUser(username, password);
			}
		}
		else if(e.getActionCommand() == "delete_user"){
			String userToDelete = inputUserSelected("Select user to delete");
			int id = new Integer(userToDelete.split(":")[0]);
			User user = PostitClientController.findUserById(id);
			PostitClientController.deleteUser(user);
		}
		else if(e.getActionCommand() == "find_note"){
			PostitClientController.addNotesToView();
		}
		else if(e.getActionCommand() == "about"){
			JOptionPane.showMessageDialog(null, Constants.ABOUT);
		}
	}
	
	private String showInputDialog(String message){
	    String inputValue = JOptionPane.showInputDialog(message);
	    if(inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")){
	        inputValue = showInputDialog(message);
	    }
	    return inputValue;
	}

	private String inputNoteSelected(String message){
		JList listOfNotes = new JList(PostitClientController.getNotesTitle().toArray());
		JOptionPane.showMessageDialog(null, listOfNotes, message, JOptionPane.PLAIN_MESSAGE);
		String noteSelected = (String) listOfNotes.getSelectedValue();
		return noteSelected;
	}
	
	private String inputUserSelected(String message) {
		JList listOfUser = new JList(PostitClientController.getUsernames().toArray());
		JOptionPane.showMessageDialog(null, listOfUser, message, JOptionPane.PLAIN_MESSAGE);
		String userSelected = (String) listOfUser.getSelectedValue();
		return userSelected;
	}
}
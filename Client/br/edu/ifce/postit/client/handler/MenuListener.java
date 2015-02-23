package br.edu.ifce.postit.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.edu.ifce.postit.client.controller.PostitClientController;
import br.edu.ifce.postit.client.util.Constants;
import br.edu.ifce.postit.client.util.PostitDialogs;

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
			PostitClientController.createNote("nova nota");
		}
		else if(e.getActionCommand() == "create_user"){
			//TODO: Show input to name and password
			String username = PostitDialogs.showInputDialog("Insira o nome do usuário");
			String password = PostitDialogs.showInputDialog("Insira a senha do usuário");
			PostitClientController.createUser(username, password);
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
	    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")){
	        inputValue = showInputDialog(message);
	    }
	    return inputValue;
	}

	private String inputNoteSelected(String message){
		//TODO:Implement selection of notes
		return null;
	}
}
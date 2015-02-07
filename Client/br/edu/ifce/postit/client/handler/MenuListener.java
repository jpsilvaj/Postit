package br.edu.ifce.postit.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import br.edu.ifce.postit.client.controller.ClientController;
import br.edu.ifce.postit.client.util.Constants;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "exit"){
			try{
				ClientController.exit();
			}catch(Exception exception){
				exception.printStackTrace();
			}
			finally{
				System.exit(0);
			}
		}
		else if(e.getActionCommand() == "create_note"){
			//TODO:Implement create_note
		}
		else if(e.getActionCommand() == "create_user"){
			// TODO:Implement create_user
		}
		else if(e.getActionCommand() == "login"){
			// TODO:Implement login
		}
		else if(e.getActionCommand() == "find_note"){
			//TODO:Implement find_note
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
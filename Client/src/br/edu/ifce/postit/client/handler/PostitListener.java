package br.edu.ifce.postit.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import br.edu.ifce.postit.client.controller.ClientControllerImpl;
import br.edu.ifce.postit.client.controller.PostitClientController;

public class PostitListener implements ActionListener, WindowListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "save_note"){
				//PostitClientController.createNote(noteContent);
			}
			else if(e.getActionCommand() == "edit_note"){
				//TODO:Implementar a busca pelo titulo da nota
//				PostitClientController.updateNote(content);
			}
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Implement address of the URI RMI
		}

		@Override
		public void windowClosing(WindowEvent e) {
			windowClosed(e);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			try{
				//TODO:ClientControllerImpl.exit();
			}catch(Exception exception){
				exception.printStackTrace();
			}
			finally{
				System.exit(0);
			}
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}
}

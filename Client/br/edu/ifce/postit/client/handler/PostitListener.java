package br.edu.ifce.postit.client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import br.edu.ifce.postit.client.controller.ClientController;

public class PostitListener implements ActionListener, WindowListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "save_note"){
			}
			else if(e.getActionCommand() == "save_user"){
			}
			else if(e.getActionCommand() == "delete_note"){
			}
			else if(e.getActionCommand() == "delete_user"){
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
				ClientController.exit();
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

package br.edu.ifce.postit.client.handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import br.edu.ifce.postit.client.controller.PostitClientController;

public class ClickNoteListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JLabel label = (JLabel) arg0.getComponent();
		String noteTitle = label.getText();
		PostitClientController.openNote(noteTitle);
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}

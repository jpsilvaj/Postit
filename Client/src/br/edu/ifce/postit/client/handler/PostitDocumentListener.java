package br.edu.ifce.postit.client.handler;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import br.edu.ifce.postit.client.controller.PostitClientController;

public class PostitDocumentListener implements DocumentListener{

	@Override
	public void changedUpdate(DocumentEvent e) {
		try {
			String noteContent = e.getDocument().getText(0, e.getDocument().getLength());
			PostitClientController.updateNote(noteContent);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		try {
			String noteContent = e.getDocument().getText(0, e.getDocument().getLength());
			PostitClientController.updateNote(noteContent);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		try {
			String noteContent = e.getDocument().getText(0, e.getDocument().getLength());
			PostitClientController.updateNote(noteContent);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

}

package br.edu.ifce.postit.client.view;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import br.edu.ifce.postit.client.controller.PostitClientController;
import br.edu.ifce.postit.client.handler.PostitDocumentListener;

public class PostitPanel extends JPanel{

	private static final long serialVersionUID = -4030816348444626229L;
	
	JScrollPane postitScrolledPane;
	private JTextArea noteContentTextArea;

	public PostitPanel(){
		this.configurePostitPanel();
	}

	private void configurePostitPanel(){
		noteContentTextArea = new JTextArea(35,90);
		noteContentTextArea.setEditable(true);
		noteContentTextArea.setLineWrap(true);
		noteContentTextArea.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		noteContentTextArea.setBackground(new Color(255,250,205));
		noteContentTextArea.getDocument().addDocumentListener(new DocumentListener() {
			
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
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		postitScrolledPane = new JScrollPane(noteContentTextArea);
		postitScrolledPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		postitScrolledPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
	        public void adjustmentValueChanged(AdjustmentEvent e) {  
	            e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
	        }
	    });
	
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		this.add(postitScrolledPane);
		this.setVisible(true);
		
	}

	public JTextArea getNoteContentTextArea() {
		return noteContentTextArea;
	}

	public void setNoteContentTextArea(JTextArea noteContentTextArea) {
		this.noteContentTextArea = noteContentTextArea;
	}
}
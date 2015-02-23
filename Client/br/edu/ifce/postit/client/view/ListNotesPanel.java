package br.edu.ifce.postit.client.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.edu.ifce.postit.client.handler.ClickNoteListener;

public class ListNotesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO:Allow selected a note to edit
	private JPanel listOfNotes;
	
	private Boolean isEmpty=true;
	private JLabel empty = new JLabel("Empty");
	
	public ListNotesPanel(){
		initListNotesPanel();
	}
	
	private void initListNotesPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	
		JLabel listOfNotesLabel = new JLabel("List of notes",JLabel.LEFT);
		listOfNotesLabel.setAlignmentX(LEFT_ALIGNMENT);
		listOfNotesLabel.setHorizontalAlignment(JLabel.LEFT);
		
		listOfNotes = new JPanel();
		listOfNotes.setLayout(new BoxLayout(listOfNotes,BoxLayout.Y_AXIS));
		listOfNotes.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
		
//		this.listOfNotes.add(empty);
		
		this.add(listOfNotesLabel);
		this.add(listOfNotes);
		
	}
	
	public JPanel getListOfClients() {
		return listOfNotes;
	}
	
	public void setListOfClients(JPanel listOfClients) {
		this.listOfNotes = listOfClients;
	}
	
	public void addNoteToPanel(String noteTitle){
		JLabel noteTitleLabel = new JLabel(noteTitle);
		noteTitleLabel.setText(noteTitle);
		noteTitleLabel.setVisible(true);
		noteTitleLabel.addMouseListener(new ClickNoteListener());
		listOfNotes.add(noteTitleLabel);
//		if(this.listOfNotes.getComponents().length > 1 && isEmpty){
//			isEmpty=false;
//			this.listOfNotes.remove(empty);
//		}
	}
}

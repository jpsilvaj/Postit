package br.edu.ifce.postit.client.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ListNotesPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO:Allow selected a note to edit
		private JTextArea listOfClients;

		public ListNotesPanel(){
			initListClientsPanel();
		}
		
		private void initListClientsPanel(){
			this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
			JLabel listOfClientsLabel = new JLabel("List of notes",JLabel.LEFT);
			listOfClientsLabel.setAlignmentX(LEFT_ALIGNMENT);
			listOfClientsLabel.setHorizontalAlignment(JLabel.LEFT);
			listOfClients = new JTextArea(12,12);
			listOfClients.setEditable(false);
			listOfClients.setLineWrap(true);
			listOfClients.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.DARK_GRAY));
			
			this.add(listOfClientsLabel);
			this.add(listOfClients);
			
		}
		
		public JTextArea getListOfClients() {
			return listOfClients;
		}

		public void setListOfClients(JTextArea listOfClients) {
			this.listOfClients = listOfClients;
		}
	
}

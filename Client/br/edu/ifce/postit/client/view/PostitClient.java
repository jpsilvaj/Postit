package br.edu.ifce.postit.client.view;

import java.awt.Container;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import br.edu.ifce.postit.client.handler.PostitListener;


public class PostitClient extends JFrame{

		//private ClientImpl client;
		private PostitMenuPanel postitMenuPanel = new PostitMenuPanel();
		private PostitPanel postitPanel = new PostitPanel();
		private ListNotesPanel listNotesPanel = new ListNotesPanel();
			
		public PostitClient(){
			super("Chat client - RMI");
			this.setSize(1080,720);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false);
			this.setNameClient();
			this.setTitle("Postit client - RMI");
			this.addPanels();
			this.pack();
			this.addWindowListener(new PostitListener());
		}
		
		private void addPanels(){
			Container c = getContentPane();
			c.setLayout(new MigLayout("insets 15 15 15 15"));
			c.add(postitMenuPanel,"dock north");
			c.add(postitPanel,"dock east, gapright 15, gapbottom 20");
			c.add(listNotesPanel,"span");
		}
		
		private void setNameClient(){
			String username = showInputDialog();
			
		}
		
		private String showInputDialog(){
		    String inputValue = JOptionPane.showInputDialog("Insert your username");
		    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")){
		        inputValue = showInputDialog();
		    }
		    return inputValue;
		}

		public PostitMenuPanel getChatMenuPanel() {
			return postitMenuPanel;
		}

		public void setChatMenuPanel(PostitMenuPanel postitMenuPanel) {
			this.postitMenuPanel = postitMenuPanel;
		}

		public PostitPanel getChatPanel() {
			return postitPanel;
		}

		public void setChatPanel(PostitPanel postitPanel) {
			this.postitPanel = postitPanel;
		}

		public ListNotesPanel getClientsPanel() {
			return listNotesPanel;
		}

		public void setClientsPanel(ListNotesPanel listNotesPanel) {
			this.listNotesPanel = listNotesPanel;
		}
	
}

package br.edu.ifce.postit.client.view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import br.edu.ifce.postit.client.controller.PostitClientController;
import br.edu.ifce.postit.client.handler.PostitListener;
import br.edu.ifce.postit.client.util.PostitDialogs;


public class PostitClient extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8069685429796289001L;
	//private ClientImpl client;
	private PostitMenuPanel postitMenuPanel = new PostitMenuPanel();
	private PostitPanel postitPanel = new PostitPanel();
	private ListNotesPanel listNotesPanel = new ListNotesPanel();
	private String username;
	private String password;
		
	public PostitClient(){
		super("Postit client - RMI");
		this.setSize(1080,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Postit client - RMI");
		this.addPanels();
		this.login();
		this.addWindowListener(new PostitListener());
		this.pack();
		this.setVisible(true);
	}
	
	private void addPanels(){
		Container c = getContentPane();
		c.setLayout(new MigLayout("insets 15 15 15 15"));
		c.add(postitMenuPanel,"dock north");
		c.add(postitPanel,"dock east, gapright 15, gapbottom 20");
		c.add(listNotesPanel,"span");
	}
	
	private void login(){
		username = PostitDialogs.showInputDialog("Insert your username");
		password = PostitDialogs.showInputDialog("Insert your password");
		PostitClientController.login(username, password);
	}
	
	public PostitMenuPanel getPostitMenuPanel() {
		return postitMenuPanel;
	}
	
	public void setPostitMenuPanel(PostitMenuPanel postitMenuPanel) {
		this.postitMenuPanel = postitMenuPanel;
	}
	
	public PostitPanel getPostitPanel() {
		return postitPanel;
	}
	
	public void setPostitPanel(PostitPanel postitPanel) {
		this.postitPanel = postitPanel;
	}
	
	public ListNotesPanel getListNotesPanel() {
		return listNotesPanel;
	}
	
	public void setListNotesPanel(ListNotesPanel listNotesPanel) {
		this.listNotesPanel = listNotesPanel;
	}
	
	@Override
	public String toString(){
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNoteInPostitPanel(String noteContent){
		postitPanel.getHistoryMessage().setText(noteContent);
	}
}

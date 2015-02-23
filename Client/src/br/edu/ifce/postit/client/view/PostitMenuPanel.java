package br.edu.ifce.postit.client.view;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.edu.ifce.postit.client.handler.MenuListener;

public class PostitMenuPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -603714265252762724L;

	JMenuBar menuBar;

	public PostitMenuPanel(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT));;
		configureMenuBar();
	}
	
	private void configureMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(Box.createHorizontalGlue());
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		ImageIcon exitIcon = new ImageIcon("exit.png");
		JMenuItem eMenuItem = new JMenuItem("Exit", exitIcon);
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.setActionCommand("exit");
		eMenuItem.addActionListener( new MenuListener());	
		
		JMenu note = new JMenu("Note");
		note.setMnemonic(KeyEvent.VK_R);
		ImageIcon noteIcon = new ImageIcon("note.png");
		
		JMenuItem createNoteMenuItem = new JMenuItem("Create note", noteIcon);
		createNoteMenuItem.setMnemonic(KeyEvent.VK_C);
		createNoteMenuItem.setToolTipText("Create note");
		createNoteMenuItem.setActionCommand("create_note");
		createNoteMenuItem.addActionListener(new MenuListener());
		
		JMenuItem deleteNoteMenuItem = new JMenuItem("Delete note", noteIcon);
		deleteNoteMenuItem.setMnemonic(KeyEvent.VK_Q);
		deleteNoteMenuItem.setToolTipText("Delete note");
		deleteNoteMenuItem.setActionCommand("delete_note");
		deleteNoteMenuItem.addActionListener( new MenuListener());
		
		JMenu user = new JMenu("User");
		note.setMnemonic(KeyEvent.VK_R);
		ImageIcon userIcon = new ImageIcon("user.png");
		
		JMenuItem loginMenuItem = new JMenuItem("Login", noteIcon);
		loginMenuItem.setMnemonic(KeyEvent.VK_D);
		loginMenuItem.setToolTipText("Login");
		loginMenuItem.setActionCommand("login");
		loginMenuItem.addActionListener(new MenuListener());
		
		JMenuItem createUserMenuItem = new JMenuItem("Create user", noteIcon);
		createUserMenuItem.setMnemonic(KeyEvent.VK_D);
		createUserMenuItem.setToolTipText("Create user");
		createUserMenuItem.setActionCommand("create_user");
		createUserMenuItem.addActionListener(new MenuListener());
		
		JMenuItem deleteUserMenuItem = new JMenuItem("Delete user", noteIcon);
		deleteUserMenuItem.setMnemonic(KeyEvent.VK_R);
		deleteUserMenuItem.setToolTipText("Delete user");
		deleteUserMenuItem.setActionCommand("delete_user");
		deleteUserMenuItem.addActionListener(new MenuListener());
	
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		ImageIcon aboutIcon = new ImageIcon("about.png");
		JMenuItem aboutMenuItem = new JMenuItem("About", aboutIcon);
		aboutMenuItem.setMnemonic(KeyEvent.VK_A);
		aboutMenuItem.setToolTipText("About application");
		aboutMenuItem.setActionCommand("about");
		aboutMenuItem.addActionListener(new MenuListener());
		
		file.add(eMenuItem);
		note.add(createNoteMenuItem);
		note.add(deleteNoteMenuItem);
		user.add(loginMenuItem);
		user.add(createUserMenuItem);
		user.add(deleteUserMenuItem);
		help.add(aboutMenuItem);

		menuBar.add(file);
		menuBar.add(note);
		menuBar.add(user);
		menuBar.add(help);
		
		this.add(menuBar);
		this.setVisible(true);
	}
}
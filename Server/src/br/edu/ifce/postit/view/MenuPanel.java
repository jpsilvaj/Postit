package br.edu.ifce.postit.view;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.edu.ifce.postit.handler.MenuListener;

public class MenuPanel extends JPanel{

		private static final long serialVersionUID = 3774041554169510911L;
		JMenuBar menuBar;

		public MenuPanel(){
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
			JMenu room = new JMenu("Room");
			room.setMnemonic(KeyEvent.VK_R);
			
			ImageIcon roomIcon = new ImageIcon("room.png");
			
			JMenuItem connectRoomMenuItem = new JMenuItem("Connect room", roomIcon);
			connectRoomMenuItem.setMnemonic(KeyEvent.VK_C);
			connectRoomMenuItem.setToolTipText("Connect room");
			connectRoomMenuItem.setActionCommand("connect_room");
			connectRoomMenuItem.addActionListener(new MenuListener());
			
			JMenuItem disconnectRoomMenuItem = new JMenuItem("Disconnect room", roomIcon);
			disconnectRoomMenuItem.setMnemonic(KeyEvent.VK_D);
			disconnectRoomMenuItem.setToolTipText("Disconnect room");
			disconnectRoomMenuItem.setActionCommand("disconnect_room");
			disconnectRoomMenuItem.addActionListener(new MenuListener());
			
			JMenuItem createRoomMenuItem = new JMenuItem("Create room", roomIcon);
			createRoomMenuItem.setMnemonic(KeyEvent.VK_R);
			createRoomMenuItem.setToolTipText("Create room");
			createRoomMenuItem.setActionCommand("create_room");
			createRoomMenuItem.addActionListener(new MenuListener());
			
			JMenuItem deleteRoomMenuItem = new JMenuItem("Delete room", roomIcon);
			deleteRoomMenuItem.setMnemonic(KeyEvent.VK_Q);
			deleteRoomMenuItem.setToolTipText("Delete room");
			deleteRoomMenuItem.setActionCommand("delete_room");
			deleteRoomMenuItem.addActionListener( new MenuListener());
			
			JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			
			ImageIcon aboutIcon = new ImageIcon("about.png");
			JMenuItem aboutMenuItem = new JMenuItem("About", aboutIcon);
			aboutMenuItem.setMnemonic(KeyEvent.VK_A);
			aboutMenuItem.setToolTipText("About application");
			aboutMenuItem.setActionCommand("about");
			aboutMenuItem.addActionListener(new MenuListener());
			
			file.add(eMenuItem);
			room.add(connectRoomMenuItem);
			room.add(disconnectRoomMenuItem);
			room.add(createRoomMenuItem);
			room.add(deleteRoomMenuItem);
			help.add(aboutMenuItem);

			menuBar.add(file);
			menuBar.add(room);
			menuBar.add(help);
			
			this.add(menuBar);
			this.setVisible(true);
		}
}

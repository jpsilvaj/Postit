package br.edu.ifce.postit.server.controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class PostitServerController {

	private static NoteControllerImpl postitNoteController;
	private static UserControllerImpl postitUserController;
	
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
//			setChatServer(new ChatServer());
			
			postitNoteController = new NoteControllerImpl();
			postitUserController = new UserControllerImpl();
			
			Naming.rebind("//localhost/postitNoteController", postitNoteController);
			Naming.rebind("//localhost/postitUserController", postitUserController);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
}

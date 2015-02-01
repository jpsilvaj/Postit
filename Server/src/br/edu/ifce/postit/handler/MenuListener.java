package br.edu.ifce.postit.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class MenuListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "exit"){
			try{
//				ClientController.exitFromRoom();
				//TODO: Create ClientController
			}catch(Exception exception){
				exception.printStackTrace();
			}
			finally{
				System.exit(0);
			}
		}
		else if(e.getActionCommand() == "connect_room"){
			
		}
		else if(e.getActionCommand() == "disconnect_room"){
			//TODO: Disconnect from room
		}
		else if(e.getActionCommand() == "about"){
			JOptionPane.showMessageDialog(null,Constants.ABOUT);
		}
		
	}
	
	private String showInputDialog(){
	    String inputValue = JOptionPane.showInputDialog("Insert the room name");
	    if(inputValue == null || inputValue.isEmpty() || !inputValue.matches("[A-Za-z]+[1-9]*")){
	        inputValue = showInputDialog();
	    }
	    return inputValue;
	}

	private String inputRoomSelected(String message){
		JList listRooms = new JList(ClientController.getRoomsName().toArray());
		JOptionPane.showMessageDialog(null, listRooms, message, JOptionPane.PLAIN_MESSAGE);
		String roomNameSelected = (String) listRooms.getSelectedValue();
		return roomNameSelected;
	}
}
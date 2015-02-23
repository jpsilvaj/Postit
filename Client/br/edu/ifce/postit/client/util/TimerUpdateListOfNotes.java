package br.edu.ifce.postit.client.util;

import java.util.TimerTask;

import br.edu.ifce.postit.client.controller.PostitClientController;

public class TimerUpdateListOfNotes extends TimerTask{

	@Override
	public void run() {
		try{
			PostitClientController.addNotesToView();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

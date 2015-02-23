package br.edu.ifce.postit.client.util;

import java.util.TimerTask;

import br.edu.ifce.postit.client.controller.PostitClientController;
import br.edu.ifce.postit.server.model.Note;

public class TimerUpdateNoteContent extends TimerTask{

	@Override
	public void run() {
		if(PostitClientController.getNoteInEdition() != null){
			PostitClientController.openNote(PostitClientController.getNoteInEdition());
		}
	}

}

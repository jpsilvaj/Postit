package br.edu.ifce.postit.server.dao;

import java.util.List;

import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public interface NoteDao {
	
	public void save(Note note);
	public void delete(Note note);
	public List<Note> listNote();
	public List<Note> listNoteByUser(User user);
	public void update(Note note);
	public Note findNoteById(int id);

}

package br.edu.ifce.postit.dao;

import java.util.List;

import br.edu.ifce.postit.model.Note;
import br.edu.ifce.postit.model.User;

public interface NoteDao {
	
	public void save(Note note);
	public void delete(Note note);
	public List<Note> listNote();
	public List<Note> listNoteByUser(User user);
	public void update(Note note);


}

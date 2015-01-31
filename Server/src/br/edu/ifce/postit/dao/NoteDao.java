package br.edu.ifce.postit.dao;

import java.util.List;

import br.edu.ifce.postit.model.Note;

public interface NoteDao {
	
	public void save(Note note);
	public void delete(Note note);
	public List<Note> listNote();
	public void update(Note note);


}

package br.edu.ifce.postit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.exception.ConstraintViolationException;

import br.edu.ifce.postit.dao.database.DatabaseFactory;
import br.edu.ifce.postit.model.Note;

public class NoteDaoImpl extends DatabaseFactory implements NoteDao{

private EntityManager manager = super.getEntityManager();;
	
	@Override
	public void save(Note note) {
		try{
			manager.getTransaction().begin();    
		    manager.persist(note);
		    manager.getTransaction().commit();	
		}catch(Exception e){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Note note) {
		Note noteToRemove = manager.find(Note.class,note.getId());
		try{
			if(noteToRemove != null){
				manager.getTransaction().begin();
				manager.remove(noteToRemove);
				manager.getTransaction().commit();
			}
		}catch(Exception e){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public List<Note> listNote() {
		CriteriaQuery<Note> criteria = manager.getCriteriaBuilder().createQuery(Note.class);
		criteria.select(criteria.from(Note.class));
		List<Note> notes = manager.createQuery(criteria).getResultList(); 
		return notes;
	}

	@Override
	public void update(Note note) {
		Note noteToUpdate = manager.find(Note.class,note.getId());
		try{
			if(noteToUpdate != null){
				manager.getTransaction().begin();
				manager.merge(note);
				manager.getTransaction().commit();
			}
		}catch(Exception e){
			manager.getTransaction().rollback();
		}
	}

}

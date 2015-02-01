package br.edu.ifce.postit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.edu.ifce.postit.dao.database.DatabaseFactory;
import br.edu.ifce.postit.model.Note;
import br.edu.ifce.postit.model.User;

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

	@Override
	public List<Note> listNoteByUser(User user) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Note> criteriaQuery = criteriaBuilder.createQuery(Note.class);
		Root noteRoot = criteriaQuery.from(Note.class);
		
		Predicate predicate = criteriaBuilder.equal(noteRoot.get("user"), user); 
		criteriaQuery.select(noteRoot);
		criteriaQuery.where(criteriaBuilder.and(predicate));
		
		TypedQuery query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}

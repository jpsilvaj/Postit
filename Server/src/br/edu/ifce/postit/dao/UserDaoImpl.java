package br.edu.ifce.postit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.exception.ConstraintViolationException;

import br.edu.ifce.postit.Exception.UserDuplicateException;
import br.edu.ifce.postit.dao.database.DatabaseFactory;
import br.edu.ifce.postit.model.User;

public class UserDaoImpl extends DatabaseFactory implements UserDao{

	private EntityManager manager = super.getEntityManager();;
	
	@Override
	public void save(User user) throws UserDuplicateException {
		try{
			manager.getTransaction().begin();    
		    manager.persist(user);
		    manager.getTransaction().commit();	
		}catch(ConstraintViolationException e){
			throw new UserDuplicateException();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	@Override
	public void delete(User user) {
		User userToRemove = manager.find(User.class,user.getId());
		try{
			if(userToRemove != null){
				manager.getTransaction().begin();
				manager.remove(userToRemove);
				manager.getTransaction().commit();
			}
		}catch(Exception e){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public List<User> listUser() {
		CriteriaQuery<User> criteria = manager.getCriteriaBuilder().createQuery(User.class);
		criteria.select(criteria.from(User.class));
		List<User> users = manager.createQuery(criteria).getResultList(); 
		
		return users;
	}

	@Override
	public void update(User user) throws UserDuplicateException {
		User userToUpdate = manager.find(User.class,user.getId());
		try{
			if(userToUpdate != null){
				manager.getTransaction().begin();
				manager.merge(user);
				manager.getTransaction().commit();
			}
		}catch(ConstraintViolationException e){
			throw new UserDuplicateException();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}
}

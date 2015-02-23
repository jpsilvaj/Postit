package br.edu.ifce.postit.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.exception.ConstraintViolationException;

import br.edu.ifce.postit.server.dao.database.DatabaseFactory;
import br.edu.ifce.postit.server.exception.NoSuchUserException;
import br.edu.ifce.postit.server.exception.UserDuplicateException;
import br.edu.ifce.postit.server.model.Note;
import br.edu.ifce.postit.server.model.User;

public class UserDaoImpl extends DatabaseFactory implements UserDao{

	private EntityManager manager = super.getEntityManager();;
	
	@Override
	public void save(User user) throws UserDuplicateException {
		try{
			manager.getTransaction().begin();    
		    manager.persist(user);
		    manager.flush();
		    manager.getTransaction().commit();
		}catch(ConstraintViolationException e){
			throw new UserDuplicateException();
		}
		catch (Exception e) {
			manager.getTransaction().rollback();
		}
	}

	@Override
	public void delete(User user) throws NoSuchUserException {
		User userToRemove = manager.find(User.class,user.getId());
		try{
			if(userToRemove != null){
				manager.getTransaction().begin();
				manager.remove(userToRemove);
				manager.flush();
				manager.getTransaction().commit();
			}
		}catch(ConstraintViolationException e){
			throw new NoSuchUserException();
		}
		catch (Exception e) {
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
				manager.flush();
				manager.getTransaction().commit();
			}
		}catch(ConstraintViolationException e){
			throw new UserDuplicateException();
		}
		catch (Exception e){
			manager.getTransaction().rollback();
		}
	}

	@Override
	public User findByLoginAndPassword(String login, String password) throws NoSuchUserException{
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
		Root userRoot = criteriaQuery.from(User.class);
		
		Predicate predicateLogin = criteriaBuilder.equal(userRoot.get("login"), login);
		Predicate predicatePassword = criteriaBuilder.equal(userRoot.get("password"), password);
		criteriaQuery.select(userRoot);
		criteriaQuery.where(criteriaBuilder.and(predicateLogin));
		criteriaQuery.where(criteriaBuilder.and(predicatePassword));
		
		TypedQuery query = manager.createQuery(criteriaQuery).setFirstResult(0).setMaxResults(1);
		List<User> result = query.getResultList();
		
		if(result.isEmpty()){
			throw new NoSuchUserException();
		}else{
			return (User) result.get(0);
		}
		
	}

	@Override
	public User findUserById(int id) {
		User user = manager.find(User.class,id);
		return user;
	}
}

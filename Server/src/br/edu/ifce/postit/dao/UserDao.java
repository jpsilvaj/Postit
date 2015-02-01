package br.edu.ifce.postit.dao;

import java.util.List;

import br.edu.ifce.postit.Exception.NoSuchUserException;
import br.edu.ifce.postit.Exception.UserDuplicateException;
import br.edu.ifce.postit.model.User;

public interface UserDao {
	
	public void save(User user) throws UserDuplicateException;
	public void delete(User user) throws NoSuchUserException;
	public List<User> listUser();
	public User findByLogin(String login);
	public void update(User user) throws UserDuplicateException;

}

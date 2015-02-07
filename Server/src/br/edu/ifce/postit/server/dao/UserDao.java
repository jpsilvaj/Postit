package br.edu.ifce.postit.server.dao;

import java.util.List;

import br.edu.ifce.postit.server.Exception.NoSuchUserException;
import br.edu.ifce.postit.server.Exception.UserDuplicateException;
import br.edu.ifce.postit.server.model.User;

public interface UserDao {
	
	public void save(User user) throws UserDuplicateException;
	public void delete(User user) throws NoSuchUserException;
	public List<User> listUser();
	public User findByLogin(String login);
	public void update(User user) throws UserDuplicateException;

}

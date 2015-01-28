package br.edu.ifce.postit.dao;

import java.util.List;
import br.edu.ifce.postit.model.User;

public interface UserDao {
	
	public void save(User user);
	public void delete(User user);
	public List list();
	public User find(String login);

}

package br.edu.ifce.postit.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Note {

	@Id
	@GeneratedValue
	private int id;
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Note(){
	}
	
	public Note(int id, String content, User user){
		this.setId(id);
		this.setContent(content);
		this.setUser(user);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

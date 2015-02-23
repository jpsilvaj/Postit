package br.edu.ifce.postit.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Note implements Serializable{

	@Transient
	private static final long serialVersionUID = 1469909242044226784L;
	
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

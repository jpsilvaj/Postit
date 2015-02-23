package br.edu.ifce.postit.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class User implements Serializable{
	
	@Transient
	private static final long serialVersionUID = -4581972588289806306L;

	@Id
	@GeneratedValue
	private int id;

	@Column(unique=true)
	private String login;
	
	private String name;
	
	private String password;
	
	public User(){
	}
	
	public User(int id, String name, String login, String password){
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return this.name;
	}
}

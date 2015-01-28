package br.edu.ifce.postit.model;

public class Note {

	private int id;
	private String content;
	private int userId;
	
	public Note(){
		
	}
	
	public Note(int id, String content, int userId){
		this.setId(id);
		this.setContent(content);
		this.setUserId(userId);
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}

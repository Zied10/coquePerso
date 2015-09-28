package fr.coque;


public class User {

	private String name;

	private int id = 0;

	public User(String s) {
		this.name = s;
		id++;
	}

	public int getId(){
		return id;
	}


	public String getName() {
		return name;
	}

}

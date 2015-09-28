package fr.coque;


public class User {

	private String name;
	private static int id = 0;

	public User(String s) {
		this.name = s;
		id++;
	}

	public String getName() {
		return name;
	}

	public int getId(){
		return id;
	}

}

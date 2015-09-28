package fr.coque;


public class User {

	private String name;
	private int id;
	private static int nbUserTotal = 0;

	public User(String s) {
		this.name = s;
		id = nbUserTotal;
		nbUserTotal++;
	}

	public String getName() {
		return name;
	}

	public int getId(){
		return id;
	}

}

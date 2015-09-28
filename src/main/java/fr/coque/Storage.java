package fr.coque;


import java.util.Collection;
import java.util.HashMap;

public class Storage {

	// this mocks a database.
	private static HashMap<String, User> users = new HashMap<String, User>();

	public static void createUser(String name) {
		users.put(name, new User(name));
	}

	public static User getUser(String name) {
		return users.get(name);
	}

	public static void deleteUser(String name) {
		users.remove(name);
	}

	public static Collection<User> getAllUsers() {
		return users.values();
	}


	static {
		Storage.createUser("zizou");
		Storage.createUser("marco");
		Storage.createUser("jpp");
	}

}

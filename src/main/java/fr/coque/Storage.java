package fr.coque;


import java.util.Collection;
import java.util.HashMap;

public class Storage {

	// this mocks a database.
	private static HashMap<String, User> contents = new HashMap<String, User>();

	public static void create(String name) {
		contents.put(name, new User(name));
	}

	public static User read(String name) {
		return contents.get(name);
	}

	public static void delete(String name) {
		contents.remove(name);
	}

	public static Collection<User> findAll() {
		return contents.values();
	}


	static {
		Storage.create("demogen");
	}

}

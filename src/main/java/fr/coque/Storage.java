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

	private static HashMap<Integer, Commande> commandes = new HashMap<Integer, Commande>();

	public static void createCommande(Integer commandeId, int userId){
		commandes.put(commandeId, new Commande(userId));
	}

	public static Collection<Commande> getAllCommandes(){
		return commandes.values();
	}

	public static Commande getCommandeFromId(int id){
		return commandes.get(id);
	}

	public static void deleteCommande(int id) {
		commandes.remove(id);
	}


	static {
		Storage.createUser("zizou");
		Storage.createUser("marco");
		Storage.createUser("jpp");

		Storage.createCommande(Commande.getIdent(), 7442);
		Storage.createCommande(Commande.getIdent(), 1234);
	}
}

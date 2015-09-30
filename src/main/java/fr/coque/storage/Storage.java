package fr.coque.storage;


import fr.coque.Commande;
import fr.coque.User;

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

	public static int getUserId(String name){
		return users.get(name).getId();
	}

	public static void deleteUser(String name) {
		users.remove(name);
	}

	public static Collection<User> getAllUsers() {
		return users.values();
	}

	private static HashMap<Integer, Commande> commandes = new HashMap<Integer, Commande>();

	public static void createCommande(Integer commandeId, int userId, String address, int numCard, String expirationDate, int pictogram){
		commandes.put(commandeId, new Commande(userId, address, numCard, expirationDate, pictogram));
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

		Storage.createCommande(Commande.getIdent(), 2, "55 rue barla", 1511522, "11/16", 632);
		Storage.createCommande(Commande.getIdent(), 3, "50 rue barla", 120215, "03/16", 552);
	}
}
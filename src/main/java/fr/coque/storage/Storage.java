package fr.coque.storage;


import fr.coque.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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

	public static void createCommande(Integer commandeId,
									  int userId,
									  String address,
									  List<Product> products,
									  int numCard,
									  String expirationDate,
									  int pictogram,
									  int typeLivraison){
		commandes.put(commandeId, new Commande(userId, address, products, numCard, expirationDate, pictogram, typeLivraison));
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

		// Models
		Model iphone4 = new Model(1, 8.5f);
		Model iphone5 = new Model(2, 9.f);
		Model iphone6 = new Model(3, 9.5f);
		Model samsungS3 = new Model(4, 5.f);
		Model samsungS4 = new Model(5, 6.f);
		Model xperia = new Model(6, 7.f);

		// Motifs
		Motif mario = new Motif(1, 3.f);
		Motif sonic = new Motif(2, 2.f);
		Motif tetris = new Motif(3, 2.5f);
		Motif luigi = new Motif(4, 1.f);
		Motif peach = new Motif(5, 3.f);

		// Products
		Product iphone5Mario = new Product(iphone5, mario);
		Product iphone4Sonic = new Product(iphone4, sonic);
		Product samsungS3Mario = new Product(samsungS3, mario);
		Product samsungS4Sonic = new Product(samsungS4, sonic);
		Product xperiaPeach = new Product(xperia, peach);

		// Products Lists
		List<Product> products1 = new ArrayList<Product>();
		List<Product> products2 = new ArrayList<Product>();
		products1.add(iphone5Mario);
		products1.add(iphone4Sonic);
		products2.add(iphone4Sonic);
		products2.add(samsungS3Mario);
		products2.add(samsungS4Sonic);
		products2.add(xperiaPeach);

		Storage.createCommande(Commande.getIdent(), 1, "44 bd du mont boron", products1, 123456, "0116", 123, 0);
		Storage.createCommande(Commande.getIdent(), 0, "41 av de la republique", products2, 654321, "0116", 456, 1);
	}
}

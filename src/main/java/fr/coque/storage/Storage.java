package fr.coque.storage;


import fr.coque.entities.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Storage {

	private static HashMap<Integer, OrderTracking> orderTrackings = new HashMap<Integer, OrderTracking>();

	public static void createOrderTracking(int orderId){
		orderTrackings.put(orderId, new OrderTracking(orderId));
	}

	public static OrderTracking getOrderTracking(int orderId){
		return orderTrackings.get(orderId);
	}

	public static Collection<OrderTracking> getAllOrderTrackings(){
		return orderTrackings.values();
	}

	public static void deleteOrderTracking(int id) {
		orderTrackings.remove(id);
	}

	private static HashMap<Integer, Delivery> deliveries = new HashMap<Integer, Delivery>();

	public static void createDelivery(int orderId, String address, int deliveryType){
		deliveries.put(orderId, new Delivery(orderId, address, deliveryType));
	}

	public static Delivery getDelivery(int orderId){
		return deliveries.get(orderId);
	}

	public static Collection<Delivery> getAlldeliveries(){
		return deliveries.values();
	}

	public static void deleteDelivery(int orderId){
		deliveries.remove(orderId);
	}

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


	private static HashMap<Integer, Model> modelStorage = new HashMap<Integer, Model>();

	public static Model getModelFromId(int id){
		return modelStorage.get(id);
	}

	private static HashMap<Integer, Motif> motifStorage = new HashMap<Integer, Motif>();

	public static Motif getMotifFromId(int id){
		return motifStorage.get(id);
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

		modelStorage.put(iphone4.getId(), iphone4);
		modelStorage.put(iphone5.getId(), iphone5);
		modelStorage.put(xperia.getId(), xperia);
		modelStorage.put(iphone6.getId(), iphone6);

		motifStorage.put(mario.getId(), mario);
		motifStorage.put(sonic.getId(), sonic);
		motifStorage.put(tetris.getId(), tetris);
		motifStorage.put(peach.getId(), peach);
	}
}

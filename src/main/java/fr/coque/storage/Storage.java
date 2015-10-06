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

	public static int woodQuantity;

	public static int getWoodQuantity(){
		return woodQuantity;
	}

	public static void setWoodQuantity(int newWoodQuantity){
		woodQuantity = newWoodQuantity;
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

	private static HashMap<Integer, Order> orders = new HashMap<Integer, Order>();

	public static void createOrder(int orderId,
									  int userId,
									  List<Product> products,
									  int typeLivraison){
		orders.put(orderId, new Order(userId, products, typeLivraison));
	}

	public static Collection<Order> getAllOrders(){
		return orders.values();
	}

	public static Order getOrderFromId(int id){
		return orders.get(id);
	}

	public static void deleteOrder(int id) {
		orders.remove(id);
	}


	private static HashMap<Integer, Model> modelStorage = new HashMap<Integer, Model>();

	public static Model getModelFromId(int id){
		return modelStorage.get(id);
	}

	public static Collection<Model> getAllModel(){
		return modelStorage.values();
	}

	private static HashMap<Integer, Motif> motifStorage = new HashMap<Integer, Motif>();

	public static Motif getMotifFromId(int id){
		return motifStorage.get(id);
	}

	public static Collection<Motif> getAllMotif(){
		return motifStorage.values();
	}

	private static HashMap<Integer, Payment> payments = new HashMap<Integer, Payment>();

	public static void createPayment(int orderId,
									  int numCard,
									  String expirationDate,
									  int pictogram,
									 float price) {
		payments.put(orderId, new Payment(orderId, numCard, expirationDate, pictogram, price));
	}

	public static Collection<Payment> getAllPayment(){
		return payments.values();
	}

	public static Payment getPaymentFromId(int id){
		return payments.get(id);
	}

	public static void deletePayment(int id){
		payments.remove(id);
	}

	private static HashMap<Integer, Assembly> assemblies = new HashMap<Integer, Assembly>();

	public static void createAssembly(int orderId){
		assemblies.put(orderId, new Assembly(orderId));
	}

	public static Assembly getAssemblyById(int orderId){
		return assemblies.get(orderId);
	}

	public static Collection<Assembly> getAllAssembly(){
		return assemblies.values();
	}



	static {
		woodQuantity = 100;

		Storage.createUser("zizou");
		Storage.createUser("marco");
		Storage.createUser("jpp");

		// Models
		Model iphone4 = new Model(1,"image.iphone4.com", 8.5f);
		Model iphone5 = new Model(2, "image.iphone5.com",9.f);
		Model iphone6 = new Model(3, "image.iphone6.com",9.5f);
		Model samsungS3 = new Model(4, "image.samsungs3.com",5.f);
		Model samsungS4 = new Model(5, "image.samsungs4.com",6.f);
		Model xperia = new Model(6, "image.xperia.com",7.f);

		// Motifs
		Motif mario = new Motif(1, "image.mario.com", 3.f);
		Motif sonic = new Motif(2, "image.sonic.com", 2.f);
		Motif tetris = new Motif(3, "image.tetris.com", 2.5f);
		Motif luigi = new Motif(4, "image.luigi.com", 1.f);
		Motif peach = new Motif(5, "image.peach.com", 3.f);

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

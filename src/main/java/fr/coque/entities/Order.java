package fr.coque.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Marc on 28/09/2015.
 */
public class Order {

    private int userId;
    private int id;
    private static int nbOrdersTotale = 0;
    private int state;
    private List<Product> products;
    private float price;
    private int typeLivraison;
    private String dateOrder;
    private String estimationArrivalDate;
    private int estimationAssemblyDuration;
    private int estimationDeliveryDuration;


    public Order(int userId,
                 List<Product> products,
                 int typeLivraison){
        this.userId = userId;
        this.id = this.nbOrdersTotale;
        this.nbOrdersTotale++;
        state = 0;
        this.products = products;
        this.typeLivraison = typeLivraison;
        dateOrder = computeDateBeginOrder();
        estimationAssemblyDuration = computeEstimationAssemblyDuration();
        estimationDeliveryDuration = computeEstimationDeliveryDuration();
        estimationArrivalDate = computeDateDeLivraison();
        price = computeProductPrice();
    }

    public int computeEstimationAssemblyDuration(){
        int nbProducts = products.size();
        if(nbProducts == 1) {
            estimationAssemblyDuration = 1;
        } else if(nbProducts == 2){
            estimationAssemblyDuration = 2;
        } else if(nbProducts < 5){
            estimationAssemblyDuration = 3;
        } else if(nbProducts < 20){
            estimationAssemblyDuration = 5;
        } else if(nbProducts < 50){
            estimationAssemblyDuration = 8;
        } else{
            estimationAssemblyDuration = 15;
        }
        return estimationAssemblyDuration;
    }

    public int computeEstimationDeliveryDuration(){
        int estim = 0;
        if(typeLivraison == 0){
            estim = 5;
        } else{
            estim = 2;
        }
        return estim;
    }

    public String computeDateBeginOrder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return sdf.format(c.getTime());
    }

    public String computeDateDeLivraison(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int estimProcessDuration = estimationAssemblyDuration + estimationDeliveryDuration;
        c.add(Calendar.DATE, estimProcessDuration);
        return sdf.format(c.getTime());
    }

    public int getId(){
        return id;
    }

    public int getUserId(){
        return userId;
    }

    public static Integer getIdent(){
        return nbOrdersTotale;
    }

    public void setState(int newState){
        state = newState;
    }

    public int getState(){
        return state;
    }

    public float getPrice(){
        return price;
    }

    private float computeProductPrice(){
        float total = 0;
        for(Product p : products){
            total += p.getPrice();
        }
        return total;
    }

    public String getDateOrder(){
        return dateOrder;
    }

    public int getTypeLivraison(){
        return typeLivraison;
    }

    public String getDateLivraison(){
        return estimationArrivalDate;
    }

    public String toString(){
       return "{" +
                "\"id\":" + getId() + "," +
                "\"userId\":" + getUserId() + "," +
                "\"state\":" + getState() + "," +
                "\"dateOrder\":" + getDateOrder() + "," +
                "\"dateLivraison\":" + getDateLivraison() + "," +
                "\"typeLivraison\":" + getTypeLivraison() + "," +
                "\"price\":" + getPrice() +
                "}";
    }
}

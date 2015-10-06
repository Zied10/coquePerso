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
    private String dateDeOrder;
    private String dateDeLivraison;

    public Order(int userId,
                 String address,
                 List<Product> products,
                 int typeLivraison){
        this.userId = userId;
        this.id = this.nbOrdersTotale;
        this.nbOrdersTotale++;
        state = 0;
        this.products = products;
        this.typeLivraison = typeLivraison;
        dateDeOrder = computeDateBeginOrder();
        dateDeLivraison = computeDateDeLivraison();
        price = computeProductPrice();
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
        if(typeLivraison == 1){
            c.add(Calendar.DATE, 2);
        } else {
            c.add(Calendar.DATE, 5);
        }
        return sdf.format(c.getTime());
    }

    public List<Product> getProducts() {
        return products;
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
        return dateDeOrder;
    }

    public int getTypeLivraison(){
        return typeLivraison;
    }

    public String getDateLivraison(){
        return dateDeLivraison;
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

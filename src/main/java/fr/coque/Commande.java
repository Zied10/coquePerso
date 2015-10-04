package fr.coque;

import java.util.List;

/**
 * Created by Marc on 28/09/2015.
 */
public class Commande {

    private int userId;
    private int id;
    private static int nbCommandesTotale = 0;
    private int state;
    private String address;
    private List<Product> products;
    private float price;
    private int numCard;
    private String expirationDate;
    private int pictogram;

    public Commande(int userId, String address, List<Product> products, int numCard, String expirationDate, int pictogram){
        this.userId = userId;
        this.id = this.nbCommandesTotale;
        this.nbCommandesTotale++;
        state = 0;
        this.address = address;
        this.products = products;
        price = computeProductPrice();
        this.numCard = numCard;
        this.expirationDate = expirationDate;
        this.pictogram = pictogram;
    }

    public int getId(){
        return id;
    }

    public int getUserId(){
        return userId;
    }

    public String getAddress() {
        return address;
    }

    public int getNumCard() {
        return numCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getPictogram() {
        return pictogram;
    }

    public static Integer getIdent(){
        return nbCommandesTotale;
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
}

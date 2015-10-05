package fr.coque.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    private int typeLivraison;
    private String dateDeCommande;
    private String dateDeLivraison;
// discerner les ressources : commande, payer, suivre la commande, livraison
    public Commande(int userId,
                    String address,
                    List<Product> products,
                    int numCard,
                    String expirationDate,
                    int pictogram,
                    int typeLivraison){
        this.userId = userId;
        this.id = this.nbCommandesTotale;
        this.nbCommandesTotale++;
        state = 0;
        this.address = address;
        this.products = products;
        this.numCard = numCard;
        this.expirationDate = expirationDate;
        this.pictogram = pictogram;
        this.typeLivraison = typeLivraison;
        dateDeCommande = computeDateBeginCommande();
        dateDeLivraison = computeDateDeLivraison();
        price = computeProductPrice();
    }

    public String computeDateBeginCommande(){
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

    public String getDateCommande(){
        return dateDeCommande;
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
                "\"address\":" + getAddress() + "," +
                "\"state\":" + getState() + "," +
                "\"numCard\":" + getNumCard() + "," +
                "\"expirationDate\":" + getExpirationDate() + "," +
                "\"pictogram\":" + getPictogram() + "," +
                "\"dateCommande\":" + getDateCommande() + "," +
                "\"dateLivraison\":" + getDateLivraison() + "," +
                "\"typeLivraison\":" + getTypeLivraison() + "," +
                "\"price\":" + getPrice() +
                "}";
    }
}

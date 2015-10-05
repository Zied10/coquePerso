package fr.coque.entities;

/**
 * Created by Zizou on 05/10/2015.
 */
public class Payment {

    private static int generatedId = 1;
    private int id;
    private int idOrder;
    private int numCard;
    private String expirationDate;
    private int pictogram;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Payment(int idOrder, int numCard, String expirationDate, int pictogram, float price){
        this.idOrder = idOrder;
        this.numCard = numCard;
        this.expirationDate = expirationDate;
        this.pictogram = pictogram;
        this.price = price;

        id = idOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getNumCard() {
        return numCard;
    }

    public void setNumCard(int numCard) {
        this.numCard = numCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPictogram() {
        return pictogram;
    }

    public void setPictogram(int pictogram) {
        this.pictogram = pictogram;
    }

    public String toString(){
        return "{" +
                "\"id\":" + getId() + "," +
                "\"numCard\":" + getNumCard() + "," +
                "\"expirationDate\":" + getExpirationDate() + "," +
                "\"pictogram\":" + getPictogram() + "," +
                "\"price\":" + getPrice() +
                "}";
    }
}

package fr.coque.entities;

/**
 * Created by Marc on 30/09/2015.
 */
public class Motif {
    private int id;
    private float price;
    private String url;

    public Motif(int id, String url, float price){
        this.price = price;
        this.id = id;
        this.url = url;
    }

    public float getPrice(){
        return price;
    }

    public String getUrl() {
        return url;
    }

    public int getId(){
        return id;
    }

    public String toString(){
        return "{" +
                "\"id\":" + getId() + "," +
                "\"url\":" + getUrl() + "," +
                "\"price\":" + getPrice() +
                "}";
    }
}

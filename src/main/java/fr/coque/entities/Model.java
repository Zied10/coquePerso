package fr.coque.entities;

/**
 * Created by Marc on 30/09/2015.
 */
public class Model {
    private int id;
    private float price;
    private String url;

    public Model(int id, String url, float price){
        this.price = price;
        this.id = id;
        this.url = url;
    }

    public float getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String toString(){
        return "{" +
                "\"id\":" + getId() + "," +
                "\"url\":" + getUrl() + "," +
                "\"price\":" + getPrice() +
                "}";
    }
}

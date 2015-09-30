package fr.coque;

/**
 * Created by Marc on 30/09/2015.
 */
public class Motif {

    private int id;
    private float price;
    private String urlImage;
    private String name;
    private static int generatedId = 1;

    public Motif(String name, String urlImage, float price){
        this.name = name;
        this.urlImage = urlImage;
        this.price = price;
        this.id = generatedId;
        generatedId++;
    }

    public float getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }

    public String getUrlImage(){
        return urlImage;
    }

    public String getName(){
        return name;
    }
}

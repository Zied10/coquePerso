package fr.coque.entities;

/**
 * Created by Marc on 30/09/2015.
 */
public class Model {
    private int id;
    private float price;

    public Model(int id, float price){
        this.price = price;
        this.id = id;
    }

    public float getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }
}
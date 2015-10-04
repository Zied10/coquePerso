package fr.coque.entities;

import fr.coque.storage.Storage;

/**
 * Created by Zizou on 28/09/2015.
 */
public class Product {
    private int modelId;
    private int motifId;
    private float price;
    private int id;
    private static int generatedId = 1;

    public Product(int modelId, int motifId){
        this.modelId = modelId;
        this.motifId = motifId;
        id = generatedId;
        generatedId++;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId(){
        return id;
    }
}

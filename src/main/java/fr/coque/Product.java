package fr.coque;

/**
 * Created by Zizou on 28/09/2015.
 */
public class Product {
    private Model model;
    private Motif motif;
    private float price;
    private int id;
    private static int generatedId = 1;

    public Product(Model model, Motif motif){
        this.model = model;
        this.motif = motif;
        price = model.getPrice() + motif.getPrice();
        id = generatedId;
        generatedId++;
    }

    public float getPrice(){
        return price;
    }

    public int getId(){
        return id;
    }
}

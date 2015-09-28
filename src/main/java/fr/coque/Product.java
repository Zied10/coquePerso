package fr.coque;

/**
 * Created by Zizou on 28/09/2015.
 */
public class Product {
    private int idModel;
    private int idMotif;

    public Product(int idModel, int idMotif){
        this.idModel = idModel;
        this.idMotif = idMotif;
    }

    public int getIdModel() {
        return idModel;
    }

    public int getIdMotif() {
        return idMotif;
    }
}

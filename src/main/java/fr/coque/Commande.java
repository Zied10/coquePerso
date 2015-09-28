package fr.coque;

/**
 * Created by Marc on 28/09/2015.
 */
public class Commande {

    private int userId;
    private int id = 0;
    private static int nbCommandesTotale = 0;

    public Commande(int userId){
        this.userId = userId;
        this.id = this.nbCommandesTotale;
        this.nbCommandesTotale++;
    }

    public int getId(){
        return id;
    }

    public int getUserId(){
        return userId;
    }

    public static Integer getIdent(){
        return nbCommandesTotale;
    }
}

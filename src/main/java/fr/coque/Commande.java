package fr.coque;

/**
 * Created by Marc on 28/09/2015.
 */
public class Commande {

    private int userId;
    private int id = 0;
    private static int nbCommandesTotale = 0;
    private String address;

    public Commande(int userId, String address){
        this.userId = userId;
        this.id = this.nbCommandesTotale;
        this.nbCommandesTotale++;
        this.address = address;
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

    public static Integer getIdent(){
        return nbCommandesTotale;
    }
}

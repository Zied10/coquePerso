package fr.coque;

/**
 * Created by Marc on 28/09/2015.
 */
public class Commande {

    private int userId;
    private int id = 0;
    private static int nbCommandesTotale = 0;
    private String address;
    private int numCard;
    private String expirationDate;
    private int pictogram;

    public Commande(int userId, String address, int numCard, String expirationDate, int pictogram){
        this.userId = userId;
        this.id = this.nbCommandesTotale;
        this.nbCommandesTotale++;
        this.address = address;
        this.numCard = numCard;
        this.expirationDate = expirationDate;
        this.pictogram = pictogram;
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

    public int getNumCard() {
        return numCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getPictogram() {
        return pictogram;
    }

    public static Integer getIdent(){
        return nbCommandesTotale;
    }
}

package fr.coque.entities;

import fr.coque.storage.Storage;

/**
 * Created by marcd on 04/10/2015.
 */
public class Assembly {
    private int duration;
    private int orderId;
    Assembly(int orderId){
        this.orderId = orderId;
    }

    public int getAssemblyDuration(){
        Order order = Storage.getOrderFromId(orderId);
        int nbProducts = order.getProducts().size();
        if(nbProducts == 1) {
            duration = 1;
        } else if(nbProducts == 2){
            duration = 2;
        } else if(nbProducts < 5){
            duration = 3;
        } else if(nbProducts < 20){
            duration = 5;
        } else if(nbProducts < 50){
            duration = 8;
        } else{
            duration = 15;
        }
        return duration;
    }

    public void setAssemblyDuration(int duration){
        this.duration = duration;
    }
}

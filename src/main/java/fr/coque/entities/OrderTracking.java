package fr.coque.entities;


/**
 * Created by marcd on 05/10/2015.
 */
public class OrderTracking {
    private int orderId;
    private int state;

    public OrderTracking(int orderId){
        this.orderId = orderId;
    }

    public int getOrderId(){
        return orderId;
    }

    public void setState(int newState){
        state = newState;
    }

    public int getState(){
        return state;
    }
}

package fr.coque.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by marcd on 05/10/2015.
 */
public class Delivery {
    private int orderId;
    private String address;
    private int state;
    private int deliveryType;
    private String departureDate;
    private String arrivalDate;

    public Delivery(int orderId, String address, int deliveryType){
        this.orderId = orderId;
        this.address = address;
        this.deliveryType = deliveryType;
        departureDate = computeDepartureDate();
        arrivalDate = computeArrivalDate();
    }

    public String computeDepartureDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return sdf.format(c.getTime());
    }

    public String computeArrivalDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        if(deliveryType == 1){
            c.add(Calendar.DATE, 2);
        } else {
            c.add(Calendar.DATE, 5);
        }
        return sdf.format(c.getTime());
    }

    public int getOrderId(){
        return orderId;
    }

    public String getAddress(){
        return address;
    }

    public void setState(int newState){
        state = newState;
    }

    public int getState(){
        return state;
    }

    public String getArrivalDate(){
        return arrivalDate;
    }

    public void setArrivalDate(String newArrivalDate){
        arrivalDate = newArrivalDate;
    }

    public int getDeliveryType(){
        return deliveryType;
    }

    public String getDepartureDate(){
        return departureDate;
    }

    public String toString(){
        return "{" +
                "\"orderId\":" + getOrderId() + "," +
                "\"address\":" + getAddress() + "," +
                "\"arrivalDate\":" + getArrivalDate() + "," +
                "\"departureDate\":" + getDepartureDate() + "," +
                "\"deliveryType\":" + getDeliveryType() + "," +
                "\"state\":" + getState() +
                "}";
    }
}

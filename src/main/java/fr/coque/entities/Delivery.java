package fr.coque.entities;

import fr.coque.storage.Storage;

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
    private String orderDate;
    private String arrivalDate;
    private int deliveryDuration;
    private int assemblyDuration;

    public Delivery(int orderId, String address, int deliveryType){
        this.orderId = orderId;
        this.address = address;
        this.deliveryType = deliveryType;
        deliveryDuration = computeEstimationDeliveryDuration();
        assemblyDuration = Storage.getOrderFromId(orderId).computeEstimationAssemblyDuration();
        orderDate = computeOrderDate();
        arrivalDate = computeArrivalDate();
        state = 0;
    }

    public String computeArrivalDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        int estimProcessDuration = deliveryDuration + assemblyDuration;
        c.add(Calendar.DATE, estimProcessDuration);
        return sdf.format(c.getTime());
    }

    public int computeEstimationDeliveryDuration(){
        int estim = 0;
        if(deliveryType == 0){
            estim = 5;
        } else{
            estim = 2;
        }
        return estim;
    }

    public String computeOrderDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
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

    public void setAssemblyDuration(int newAssemblyDuration){
        assemblyDuration = newAssemblyDuration;
        arrivalDate = computeArrivalDate();
    }

    public void setDeliveryDuration(int newDeliveryDuration){
        deliveryDuration = newDeliveryDuration;
        arrivalDate = computeArrivalDate();
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

    public String getOrderDate(){
        return orderDate;
    }

    public String toString(){
        return "{" +
                "\"orderId\":" + getOrderId() + "," +
                "\"address\":" + getAddress() + "," +
                "\"arrivalDate\":" + getArrivalDate() + "," +
                "\"orderDate\":" + getOrderDate() + "," +
                "\"deliveryType\":" + getDeliveryType() + "," +
                "\"state\":" + getState() +
                "}";
    }
}

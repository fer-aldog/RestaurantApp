package org.pattersonclippers.restaurantapp;

//https://www.akiraramenizakaya.com/menu

public class Ramen {

    private boolean hasChashu, hasSoftEgg;
    private double price;
    private String ramenName;
    private int quantity;

    public Ramen() {
        ramenName = "";
        price = 0.00;
        hasChashu = false;
        hasSoftEgg = false;
        quantity = 0;
    }

    public Ramen(String newName, int newQuantity) {
        ramenName = newName;
        if(ramenName.equals("Akira Volcano Ramen Spicy")){
            price = 13.50;
        }
        if(ramenName.equals("Vegetable Ramen")){
            price = 11.00;
        }
        hasChashu = false;
        hasSoftEgg = false;
        quantity = newQuantity;
    }

    public String getRamenName() {
        return ramenName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() { return quantity; }

    public boolean doesHaveChashu() {
        return hasChashu;
    }

    public boolean doesHaveSoftEgg() {
        return hasSoftEgg;
    }

    public void setRamenName(String ramenName) {
        this.ramenName = ramenName;
    }

    public void setPrice(double price) { this.price = price; }
    public void addPrice(double priceToAdd) { price += priceToAdd; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void setHasChashu(boolean hasChashu) {
        this.hasChashu = hasChashu;
    }

    public void setHasSoftEgg(boolean hasSoftEgg) {
        this.hasSoftEgg = hasSoftEgg;
    }

    @Override
    public String toString() {
        String fullDeets = quantity + " of " + ramenName;
        if(hasSoftEgg) {
            fullDeets += ", with egg";
        }
        if(hasChashu) {
            fullDeets += ", with chashu";
        }
        return fullDeets;
    }
}
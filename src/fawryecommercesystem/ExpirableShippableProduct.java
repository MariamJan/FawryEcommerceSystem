package fawryecommercesystem;

import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class ExpirableShippableProduct extends Product implements Shippable {
     double weight;
    Date expiryDate;

    public ExpirableShippableProduct(String name, double price, int quantity, double weight, Date expiryDate) {
        super(name, price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    boolean isExpired() {
        return new Date().after(expiryDate);
    }

    @Override
    boolean isShippable() {
        return true;
    }

     @Override
    public double getWeight() {
        return weight;
    }
}

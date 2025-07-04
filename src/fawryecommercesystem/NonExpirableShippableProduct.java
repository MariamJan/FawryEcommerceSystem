package fawryecommercesystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class NonExpirableShippableProduct extends Product implements Shippable {
    double weight;

    public NonExpirableShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    boolean isExpired() {
        return false;
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

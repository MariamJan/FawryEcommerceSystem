package fawryecommercesystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class NonShippableProduct extends Product {
     public NonShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    boolean isExpired() {
        return false;
    }

    @Override
    boolean isShippable() {
        return false;
    }
}

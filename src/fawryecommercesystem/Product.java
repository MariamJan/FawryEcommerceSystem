package fawryecommercesystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public abstract class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isAvailable(int requestedQty) {
        return quantity >= requestedQty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void reduceQuantity(int qty) {
        this.quantity -= qty;
    }

    abstract boolean isExpired();
    abstract boolean isShippable();
}

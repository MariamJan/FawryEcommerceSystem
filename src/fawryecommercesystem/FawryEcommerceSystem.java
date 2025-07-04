/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fawryecommercesystem;

import java.util.Calendar;

/**
 *
 * @author hp
 */
public class FawryEcommerceSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 10, 0.2, cal.getTime());
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 5, 0.7, cal.getTime());
        Product tv = new NonExpirableShippableProduct("TV", 3000, 3, 5);
        Product scratchCard = new NonShippableProduct("ScratchCard", 50, 100);

        Customer customer = new Customer("Ali", 5000);
        Cart cart = new Cart();

        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        CheckoutSystem.checkout(customer, cart);
    }
    
}

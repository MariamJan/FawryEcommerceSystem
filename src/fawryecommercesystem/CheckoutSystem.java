package fawryecommercesystem;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class CheckoutSystem {
     public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0.0;
        double shipping = 0.0;
        List<Shippable> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            if (item.product.isExpired()) {
                throw new IllegalStateException(item.product.getName() + " is expired.");
            }
            if (!item.product.isAvailable(item.quantity)) {
                throw new IllegalStateException(item.product.getName() + " is out of stock.");
            }

            subtotal += item.product.getPrice() * item.quantity;
            if (item.product.isShippable()) {
                for (int i = 0; i < item.quantity; i++) {
                    shippableItems.add((Shippable) item.product);
                }
                shipping += item.quantity * 10; // assume 10 per item
            }
        }

        double total = subtotal + shipping;
        if (!customer.canAfford(total)) {
            throw new IllegalStateException("Customer balance insufficient.");
        }

        // Deduct and reduce stock
        customer.deduct(total);
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        if (!shippableItems.isEmpty()) {
            ShippingService.ship(shippableItems);
        }

        // Print receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f\n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", shipping);
        System.out.printf("Amount           %.0f\n", total);
        System.out.printf("Balance          %.0f\n", customer.getBalance());
    }
}

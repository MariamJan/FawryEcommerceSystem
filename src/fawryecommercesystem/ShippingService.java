package fawryecommercesystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hp
 */
public class ShippingService {
     public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        Map<String, Double> nameToWeight = new HashMap<>();
        Map<String, Integer> nameToQty = new HashMap<>();

        for (Shippable item : items) {
            nameToWeight.put(item.getName(), nameToWeight.getOrDefault(item.getName(), 0.0) + item.getWeight());
            nameToQty.put(item.getName(), nameToQty.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        for (String name : nameToQty.keySet()) {
            System.out.printf("%dx %-12s %.0fg\n", nameToQty.get(name), name, nameToWeight.get(name) * 1000 / nameToQty.get(name));
        }

        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }
}

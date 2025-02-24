/**********************************************
 Workshop 3
 Course:CPP - Semester 4
 Last Name:Sharma
 First Name:Sujan
 ID:157775222
 Section:NDD
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date:23rd Feb 2025
 **********************************************/
package com.pizzashop.model;

public class Pizza {
    public enum Type {
        CHEESE, VEGETARIAN, MEAT_LOVER
    }

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private Type type;
    private Size size;
    private int quantity;

    public Pizza(Type type, Size size, int quantity) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
    }

    public double calculatePrice() {
        double basePrice;
        switch (type) {
            case CHEESE:
                basePrice = 10.99;
                break;
            case VEGETARIAN:
                basePrice = 11.99;
                break;
            case MEAT_LOVER:
                basePrice = 13.99;
                break;
            default:
                basePrice = 0.0;
        }

        // apply size multiplier
        switch (size) {
            case MEDIUM:
                basePrice *= 1.2;
                break;
            case LARGE:
                basePrice *= 1.4;
                break;
        }

        return basePrice * quantity;
    }

    // getters and setters
    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }
}
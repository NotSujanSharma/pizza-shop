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

public class Order {
    private static final double TAX_RATE = 0.13; // 13% tax
    private Customer customer;
    private Pizza pizza;
    private String orderId;
    private static int orderCounter = 0;

    public Order(Customer customer, Pizza pizza) {
        this.customer = customer;
        this.pizza = pizza;
        this.orderId = generateOrderId();
    }

    private String generateOrderId() {
        return "ORD" + String.format("%04d", ++orderCounter);
    }

    public double calculateTotalBeforeTax() {
        return pizza.calculatePrice();
    }

    public double calculateTax() {
        return calculateTotalBeforeTax() * TAX_RATE;
    }

    public double calculateTotalWithTax() {
        return calculateTotalBeforeTax() + calculateTax();
    }

    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderId).append("\n");
        summary.append("Customer Name: ").append(customer.getName()).append("\n");
        summary.append("Customer Phone: ").append(customer.getPhone()).append("\n");
        summary.append("Pizza Type: ").append(pizza.getType()).append("\n");
        summary.append("Pizza Size: ").append(pizza.getSize()).append("\n");
        summary.append("Quantity: ").append(pizza.getQuantity()).append("\n");
        summary.append(String.format("Total before tax: $%.2f\n", calculateTotalBeforeTax()));
        summary.append(String.format("Tax amount: $%.2f\n", calculateTax()));
        summary.append(String.format("Total to be paid: $%.2f", calculateTotalWithTax()));
        return summary.toString();
    }

    // getters
    public Customer getCustomer() {
        return customer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getOrderId() {
        return orderId;
    }
}
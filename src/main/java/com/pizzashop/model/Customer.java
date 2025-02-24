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

public class Customer {
    private String name;
    private String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
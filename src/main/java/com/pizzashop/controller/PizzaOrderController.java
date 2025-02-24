package com.pizzashop.controller;

import com.pizzashop.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;

public class PizzaOrderController {
    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private RadioButton cheeseRadio;
    @FXML private RadioButton vegetarianRadio;
    @FXML private RadioButton meatLoverRadio;
    @FXML private ComboBox<String> sizeComboBox;
    @FXML private TextField quantityField;
    @FXML private TextArea orderSummaryArea;

    private List<Order> orders = new ArrayList<>();

    @FXML
    public void initialize() {
        // initializing size combo box
        sizeComboBox.getItems().addAll("Small", "Medium", "Large");
        sizeComboBox.setValue("Small");

        // creating toggle group for pizza type
        ToggleGroup pizzaTypeGroup = new ToggleGroup();
        cheeseRadio.setToggleGroup(pizzaTypeGroup);
        vegetarianRadio.setToggleGroup(pizzaTypeGroup);
        meatLoverRadio.setToggleGroup(pizzaTypeGroup);
        cheeseRadio.setSelected(true);
    }

    @FXML
    private void handlePlaceOrder() {
        try {
            // validate inputs
            if (!validateInputs()) {
                return;
            }

            // vreate customer
            Customer customer = new Customer(
                    nameField.getText().trim(),
                    phoneField.getText().trim()
            );

            // determine pizza type
            Pizza.Type pizzaType;
            if (cheeseRadio.isSelected()) {
                pizzaType = Pizza.Type.CHEESE;
            } else if (vegetarianRadio.isSelected()) {
                pizzaType = Pizza.Type.VEGETARIAN;
            } else {
                pizzaType = Pizza.Type.MEAT_LOVER;
            }

            // determine pizza size
            Pizza.Size pizzaSize;
            switch (sizeComboBox.getValue().toUpperCase()) {
                case "MEDIUM":
                    pizzaSize = Pizza.Size.MEDIUM;
                    break;
                case "LARGE":
                    pizzaSize = Pizza.Size.LARGE;
                    break;
                default:
                    pizzaSize = Pizza.Size.SMALL;
            }

            // create pizza
            Pizza pizza = new Pizza(
                    pizzaType,
                    pizzaSize,
                    Integer.parseInt(quantityField.getText().trim())
            );

            // create and store order
            Order order = new Order(customer, pizza);
            orders.add(order);

            // display order summary
            orderSummaryArea.setText(order.generateOrderSummary());

        } catch (NumberFormatException e) {
            showError("Please enter a valid quantity");
        } catch (Exception e) {
            showError("An error occurred while placing the order");
        }
    }

    @FXML
    private void handleClear() {
        nameField.clear();
        phoneField.clear();
        cheeseRadio.setSelected(true);
        sizeComboBox.setValue("Small");
        quantityField.clear();
        orderSummaryArea.clear();
    }

    private boolean validateInputs() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String quantity = quantityField.getText().trim();

        if (name.isEmpty()) {
            showError("Please enter customer name");
            return false;
        }

        if (phone.isEmpty()) {
            showError("Please enter phone number");
            return false;
        }

        if (quantity.isEmpty()) {
            showError("Please enter quantity");
            return false;
        }

        try {
            int qty = Integer.parseInt(quantity);
            if (qty <= 0) {
                showError("Quantity must be greater than 0");
                return false;
            }
        } catch (NumberFormatException e) {
            showError("Please enter a valid quantity");
            return false;
        }

        return true;
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
module com.pizzashop {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pizzashop to javafx.fxml;
    opens com.pizzashop.controller to javafx.fxml;

    exports com.pizzashop;
    exports com.pizzashop.controller;
    exports com.pizzashop.model;
}
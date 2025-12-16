package com.currencyConverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("ABC Converter");
        
        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount in INR");

        Button convertButton = new Button("Convert to USD");
        Label resultLabel = new Label();

        convertButton.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                double usd = amount / 83.0; // Static conversion rate
                resultLabel.setText("USD: " + String.format("%.2f", usd));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input!");
            }
        });

        VBox root = new VBox(10, title, amountField, convertButton, resultLabel);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Currency Converter App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

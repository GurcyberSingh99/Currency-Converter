package com.currency;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CurrencyController {

    @FXML private ComboBox<String> fromCurrency;
    @FXML private ComboBox<String> toCurrency;
    @FXML private TextField amountField;
    @FXML private Label resultLabel;

    @FXML
    public void initialize() {
        fromCurrency.getItems().addAll("USD", "INR", "EUR");
        toCurrency.getItems().addAll("USD", "INR", "EUR");

        fromCurrency.setValue("USD");
        toCurrency.setValue("INR");
    }

    @FXML
    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String from = fromCurrency.getValue();
            String to = toCurrency.getValue();

            double rate = getRate(from, to);
            double result = amount * rate;

            resultLabel.setText(String.format("%.2f %s", result, to));
        } catch (Exception e) {
            resultLabel.setText("Invalid amount");
        }
    }

    private double getRate(String from, String to) {
        if (from.equals("USD") && to.equals("INR")) return 83.10;
        if (from.equals("INR") && to.equals("USD")) return 0.012;
        if (from.equals("USD") && to.equals("EUR")) return 0.92;
        if (from.equals("EUR") && to.equals("USD")) return 1.08;
        if (from.equals("EUR") && to.equals("INR")) return 90.25;
        if (from.equals("INR") && to.equals("EUR")) return 0.011;
        return 1.0;
    }
}

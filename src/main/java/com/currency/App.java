package com.currency;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        // Load FXML layout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/currency/currency.fxml"));
        Parent root = loader.load();

        // Apply dark theme to root container
        root.getStyleClass().add("dark");

        // Create scene
        Scene scene = new Scene(root, 450, 300);

        // DEBUG: Check if CSS is loading
        System.out.println("DEBUG CSS PATH = " + getClass().getResource("/com/currency/styles.css"));

        // Load CSS stylesheet (UPDATED)
        String css = getClass().getResource("/com/currency/styles.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Window setup
        stage.setTitle("Abc Converter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

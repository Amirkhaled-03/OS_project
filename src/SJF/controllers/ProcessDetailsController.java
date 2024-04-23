package SJF.controllers;

import javafx.scene.control.Label;

import javafx.fxml.FXML;

public class ProcessDetailsController {
    @FXML
    private Label nameLabel;

    public void displayName(String name) {
        nameLabel.setText("hello: " + name);
    }

}

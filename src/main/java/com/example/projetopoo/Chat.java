package com.example.projetopoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Chat {

    @FXML
    private Label msgBot;

    @FXML
    private Label msgUser;

    @FXML
    private TextField msg;

    @FXML
    void send(ActionEvent event) {
        if(msg.getText().equalsIgnoreCase("Olá") || msg.getText().equalsIgnoreCase("Oi")
                || msg.getText().equalsIgnoreCase("Hi") || msg.getText().equalsIgnoreCase("Hello")){

            msgUser.setText(msg.getText());
            msgBot.setText("Olá, como vai?");
            msg.setText("");

        } else  if(msg.getText().equalsIgnoreCase("Bem, e você?") || msg.getText().equalsIgnoreCase("Vou bem, e você?")
                || msg.getText().equalsIgnoreCase("Estou bem, e você?") || msg.getText().equalsIgnoreCase("Ótimo, e você?")){

            msgUser.setText(msg.getText());
            msgBot.setText("Vou bem também :)");
            msg.setText("");
        }
    }

    }


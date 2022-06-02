package com.example.projetopoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Cadastro {


    @FXML
    private Button confirme;

    @FXML
    private PasswordField confisenha;


    @FXML
    private TextField idade;

    @FXML
    private TextField email;

    @FXML
    private TextField nick;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField sex;

    @FXML
    private TextField username;

    @FXML
    void entrar(ActionEvent event) {
        String insertuser = "insert into user(username,email,password,sexo,idade)values(?,?,?,?,?)";

        Connection conexao = ConexaoBD.getConnection();
        try {
            PreparedStatement stmInsert = conexao.prepareStatement(insertuser);
            stmInsert.setString(1,username.getText() );
            stmInsert.setString(2,email.getText());
            stmInsert.setString(3,senha.getText() );
            stmInsert.setString(4,sex.getText());
            stmInsert.setString(5,idade.getText() );
            stmInsert.execute();

            Alert log = new Alert(Alert.AlertType.CONFIRMATION);
            log.setHeaderText("Cadastrado");
            log.setContentText("Cadastrado com susesso");
            log.showAndWait();

            Stage stage = (Stage) confirme.getScene().getWindow();
            stage.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}

package com.example.projetopoo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoController {

    @FXML
    private PasswordField password;

    @FXML
    private TextField user;

    @FXML
    void cadastro(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Loggin.class.getResource("Cadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void entrar(ActionEvent event) {
        String insertuser = "select * from user where username=(?)";
        String username=null;
        String senha=null;

        Connection conexao = ConexaoBD.getConnection();
        try {
            PreparedStatement teste = conexao.prepareStatement(insertuser);
            teste.setString(1,user.getText() );
            ResultSet rs = teste.executeQuery();

            while (rs.next()){
                username=rs.getString("username");
                senha=rs.getString("password");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(user.getText().equals(username)&&password.getText().equals(senha)){
            FXMLLoader fxmlLoader = new FXMLLoader(Loggin.class.getResource("Chat.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage=new Stage();
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        }
        else{

            Alert log = new Alert(Alert.AlertType.ERROR);
            log.setHeaderText("Erro");
            log.setContentText("Usuario não encontrado");
            log.showAndWait();
        }


    }

    @FXML
    void esenha(ActionEvent event) {

    }

}
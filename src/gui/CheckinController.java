/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import db.DB;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class CheckinController implements Initializable {

    @FXML
    private TextField nameId;
    @FXML
    private TextField cpfId;
    @FXML
    private TextField rgId;
    @FXML
    private TextField codId;
    @FXML
    private Label medico1;
    @FXML
    private Label consulta1;
    @FXML
    private Label data1;
    @FXML
    private Label data2;
    @FXML
    private Label consulta2;
    @FXML
    private Label medico2;
    @FXML
    private Label data3;
    @FXML
    private Label consulta3;
    @FXML
    private Label medico3;

    private Connection conn = DB.getConnection();
    private PreparedStatement st;
    private ResultSet rs;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void OnBuscaAction(ActionEvent event) {
        
    }

    @FXML
    private void OnConClick1(MouseEvent event) {
    }

    @FXML
    private void OnConClick2(MouseEvent event) {
    }

    @FXML
    private void OnConClick3(MouseEvent event) {
    }

    @FXML
    private void OnCheckAction(ActionEvent event) {
    }

    @FXML
    private void OnCanAction(ActionEvent event) {
    }
    
}

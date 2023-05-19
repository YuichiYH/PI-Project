/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author rodri
 */
public class PagamentoController implements Initializable {

    @FXML
    private Group cartao_pagamento;
    @FXML
    private TextField numero_cartao;
    @FXML
    private TextField titular_cartao;
    @FXML
    private TextField juros;
    @FXML
    private RadioButton debito;
    @FXML
    private ToggleGroup forma_pagamento;
    @FXML
    private RadioButton credito;
    @FXML
    private TextField cvv;
    @FXML
    private TextField dt_nascimento;
    @FXML
    private TextField cpf;
    @FXML
    private Button confirmar;
    @FXML
    private TextField valor;
    @FXML
    private RadioButton cartao;
    @FXML
    private ToggleGroup pagamento;
    @FXML
    private RadioButton boleto;
    @FXML
    private RadioButton pix;
    @FXML
    private Button gerar_boleto;
    @FXML
    private Button qr_code;
    @FXML
    private ImageView qr_code_img;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        valor.setText("R$0,00");
    }    

    @FXML
    private void confirmar(ActionEvent event) {
        
    }

    @FXML
    private void click(ActionEvent event) {
        if (pagamento.getSelectedToggle() == cartao) {
            cartao_pagamento.setDisable(false);
            gerar_boleto.setDisable(true);
            qr_code.setDisable(true);
            qr_code_img.setOpacity(0);
        }
        else if(pagamento.getSelectedToggle() == boleto){
            gerar_boleto.setDisable(false);
            cartao_pagamento.setDisable(true);
            qr_code.setDisable(true);
            qr_code_img.setOpacity(0);
        }
        else if(pagamento.getSelectedToggle() == pix){
            qr_code.setDisable(false);
            gerar_boleto.setDisable(true);
            cartao_pagamento.setDisable(true);
            qr_code_img.setOpacity(0);
        }
    }

    @FXML
    private void botao(ActionEvent event) {
        qr_code_img.setOpacity(1);
    }
    @FXML
    private void botao_boleto(ActionEvent event) {
        
    }
}

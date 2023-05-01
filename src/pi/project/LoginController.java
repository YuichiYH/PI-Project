/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pi.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class LoginController implements Initializable {

    String usuario = "Admin";
    String senha = "Admin";
    
    
    
    @FXML
    private TextField tfUser;
    @FXML
    private TextField tfPassword;
    
    @FXML
    private Text BadStats;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickRegister(MouseEvent event) {
        // TODO
    }

    @FXML
    private void onClickEnter(ActionEvent event) throws IOException {
            if (usuario.equals(tfUser.getText()) && senha.equals(tfPassword.getText())){
                root = FXMLLoader.load(getClass().getResource("AgendaCalendar.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Agenda");
                stage.setScene(scene);
                stage.show();
            }
            else {
                BadStats.setOpacity(1);
            }
    }
    
}

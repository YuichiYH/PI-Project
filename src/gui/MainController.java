/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import gui.util.Constraints;
import gui.util.alerts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafxapplication1.LoginController;
import javafxapplication1.tela;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class MainController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;
    @FXML
    private MenuBar menubar;
    
    private Stage stage;
    private Scene scene;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onMenuItemLogout(ActionEvent event) throws IOException {
    stage = (Stage)((MenuItem)event.getSource()).getParentPopup().getOwnerWindow();

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxapplication1/Login.fxml"));
    AnchorPane newPane = loader.load();

    scene = new Scene(newPane);
    stage.setTitle("Cadastro Paciente");
    stage.setScene(scene);
    stage.show();
    }

    @FXML
    private void onMenuItemSellerAction(ActionEvent event) {
        loadView("/gui/Paciente.fxml");
    }

    @FXML
    private void onMenuItemDepartmentAction(ActionEvent event) {
        loadView("/gui/Funcionario.fxml");
    }

    @FXML
    private void onMenuItemAboutAction(ActionEvent event) {
        loadView("/gui/Checkin.fxml");
    }
    
    private synchronized void loadView(String absoluteName){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();
            
            Scene mainScene = LoginController.getMainScene();
            
            VBox mainVBox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent();
            
            Node mainMenu= mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());
        }
        catch(IOException e){
            alerts.showAlert("IO Exception", "ERROR Loading View", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}

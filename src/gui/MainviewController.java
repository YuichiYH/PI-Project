
package gui;



import gui.util.Constraints;
import gui.util.alerts;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafxapplication1.LoginController;
import javafxapplication1.tela;



public class MainviewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        loadView("/gui/Paciente.fxml");
    }

    @FXML
    public void onMenuItemDepartmentAction() {
       loadView("/gui/Funcionario.fxml");
    }
    
    @FXML
    public void onMenuItemAboutAction() {
       loadView("/gui/Checkin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

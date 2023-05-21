
package javafxapplication1;

import db.DB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField tfUser;
    @FXML
    private TextField tfPassword;
    
    @FXML
    private Text BadStats;
    
    private Stage stage;
    private static Scene scene;
    private Parent root;

    private Connection conn;
    private PreparedStatement st = null;
    private ResultSet rs = null;
    
    private String usuario;
    private String senha;
    private String cargo;
    
    private FXMLLoader loader;
    ScrollPane scrollPane;
    VBox vbox;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickRegister(MouseEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PacienteLogin.fxml"));
        VBox newVBox = loader.load();
        
        scene = new Scene(newVBox);
        stage.setTitle("Cadastro Paciente");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void onClickEnter(ActionEvent event) throws IOException, SQLException {
        
        conn = DB.getConnection();
        
        try{
        
            st = conn.prepareStatement("select email, senha, cargo from pessoa where email = ?");
            st.setString(1, tfUser.getText());

            rs = st.executeQuery();

            rs.next();
            usuario = rs.getString("email");
            senha = rs.getString("senha");
            cargo = rs.getString("cargo");
        }
        catch(SQLException e){
            e.printStackTrace();
            BadStats.setOpacity(1);
        }
        
        if (usuario.equals(tfUser.getText()) && senha.equals(tfPassword.getText())){
            try {
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            switch(cargo){
                case "M":
                    loader = new FXMLLoader(getClass().getResource("/gui/TelaMedico.fxml"));
                    vbox = loader.load();
                    scene = new Scene(vbox);
                    break;
                case "P":
                    loader = new FXMLLoader(getClass().getResource("/gui/Main.fxml"));
                    scrollPane = loader.load();

                    scrollPane.setFitToHeight(true);
                    scrollPane.setFitToWidth(true);
                    scene = new Scene(scrollPane);
                    break;
                case "A":
                    loader = new FXMLLoader(getClass().getResource("/gui/Main.fxml"));
                    scrollPane = loader.load();

                    scrollPane.setFitToHeight(true);
                    scrollPane.setFitToWidth(true);
                    scene = new Scene(scrollPane);
                    break;
            }
            
            
            stage.setTitle("Tela Principal");
            stage.setScene(scene);
            stage.show();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            BadStats.setOpacity(1);
        }
    }
    
    public static Scene getMainScene(){
        return scene;
    }
    
}

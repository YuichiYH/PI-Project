/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import db.DB;
import gui.util.Constraints;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Pc
 */
public class FuncionarioController implements Initializable {

    @FXML
    private TextField nome;
    @FXML
    private TextField cfpid;
    @FXML
    private TextField cepid;
    @FXML
    private TextField emailid;
    @FXML
    private TextField rgid;
    @FXML
    private TextField orgaoid;
    @FXML
    private DatePicker dataid;
    @FXML
    private RadioButton mascid;
    @FXML
    private ToggleGroup groupSex;
    @FXML
    private RadioButton femid;
    @FXML
    private RadioButton radioAtendee;
    @FXML
    private ToggleGroup groupCargo;
    @FXML
    private RadioButton radioMedic;
    @FXML
    private TextField ruaid;
    @FXML
    private TextField cidadeid;
    @FXML
    private TextField numberid;
    @FXML
    private TextField estadoid;
    @FXML
    private TextField bairroid;
    @FXML
    private TextField compid;
    @FXML
    private TextField telid;
    @FXML
    private MenuButton civilid;
    @FXML
    private Button botao;
    @FXML
    private PasswordField passwordId;

        
    private Connection conn;
    private PreparedStatement st;
    private ResultSet rs;
    private int rows;
    
    private int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Constraints.setTexFieldCharacter(nome);
        Constraints.setTexFieldCharacter(ruaid);
        Constraints.setTexFieldCharacter(cidadeid);
        Constraints.setTexFieldCharacter(estadoid);
        Constraints.setTexFieldCharacter(bairroid);
        Constraints.setTexFieldCharacter(compid);
        Constraints.setTextFieldDouble(cfpid);
        Constraints.setTextFieldDouble(cepid);
        Constraints.setTextFieldDouble(rgid);
        Constraints.setTextFieldDouble(numberid);
        Constraints.setTextFieldDouble(telid);
        Constraints.setTextFieldDouble(passwordId);
        
        Constraints.setTextFieldMaxLength(nome, 50);
        Constraints.setTextFieldMaxLength(cfpid, 11);
        Constraints.setTextFieldMaxLength(rgid, 7);
        Constraints.setTextFieldMaxLength(telid, 11);
        Constraints.setTextFieldMaxLength(passwordId, 20);
    }    

    @FXML
    private void onRadioSex(ActionEvent event) {
    }

    @FXML
    private void onsolteiroAction(ActionEvent event) {
    }

    @FXML
    private void oncasadoAction(ActionEvent event) {
    }

    @FXML
    private void onBotaoAction(ActionEvent event) throws SQLException {
        conn = DB.getConnection();
            
        rs = conn.prepareStatement("select id from pessoa order by id desc limit 1").executeQuery();

        rs.next();

        id = rs.getInt("id");

        st = conn.prepareStatement("insert into pessoa Values("+ 
                "?, \n" +   //id
                "?,\n" +    //name
                "?,\n" +    //sex
                "?, \n" +   //date
                "?, \n" +   //civil
                "?, \n" +   //rg
                "?,\n" +    //cpf
                "?,\n" +    //tel
                "?,\n" +    //email
                "?,\n" +    //senha
                "?)");      //cargo



        st.setInt(1, (id + 1));
        st.setString(2, nome.getText());
        st.setString(3, checkSex(groupSex));
        st.setDate(4, java.sql.Date.valueOf(dataid.getValue()));
        st.setBoolean(5, getCivil(civilid));
        st.setString(6, rgid.getText());
        st.setString(7, cfpid.getText());
        st.setString(8, telid.getText());
        st.setString(9, emailid.getText());
        st.setString(10, passwordId.getText());
        st.setString(11, checkCargo(groupCargo));

        rows = st.executeUpdate();

        conn.close();
    }
    private String checkSex(ToggleGroup radioSex){
        return(radioSex.getSelectedToggle() == mascid ? "M" : "F");
    }
    private boolean getCivil(MenuButton civil){
        return(civil.getText().equals("Solteiro"));
    }
    
    private String checkCargo(ToggleGroup groupCargo){
        return(groupCargo.getSelectedToggle() == radioMedic ? "M" : "A");
    }
}

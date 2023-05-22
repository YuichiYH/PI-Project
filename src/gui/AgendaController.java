/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author 00342605
 */
public class AgendaController implements Initializable {

    int month = Calendar.getInstance().get(Calendar.MONTH);
    int year = Calendar.getInstance().get(Calendar.YEAR);
    
    @FXML
    private TextField ExamName;
    @FXML
    private DatePicker ExamDate;
    @FXML
    private Text BadStats;
    @FXML
    private Text Month;
    @FXML
    private Text Number10;
    @FXML
    private Text Number20;
    @FXML
    private Text Number30;
    @FXML
    private Text Number40;
    @FXML
    private Text Number50;
    @FXML
    private Text Number60;
    @FXML
    private Text Number70;
    @FXML
    private Text Desc10;
    @FXML
    private Text Desc20;
    @FXML
    private Text Desc30;
    @FXML
    private Text Desc40;
    @FXML
    private Text Desc50;
    @FXML
    private Text Desc60;
    @FXML
    private Text Desc70;
    @FXML
    private Text Desc71;
    @FXML
    private Text Desc61;
    @FXML
    private Text Desc51;
    @FXML
    private Text Desc41;
    @FXML
    private Text Desc31;
    @FXML
    private Text Desc21;
    @FXML
    private Text Desc11;
    @FXML
    private Text Number71;
    @FXML
    private Text Number61;
    @FXML
    private Text Number51;
    @FXML
    private Text Number41;
    @FXML
    private Text Number31;
    @FXML
    private Text Number21;
    @FXML
    private Text Number11;
    @FXML
    private Text Desc72;
    @FXML
    private Text Desc62;
    @FXML
    private Text Desc52;
    @FXML
    private Text Desc42;
    @FXML
    private Text Desc32;
    @FXML
    private Text Desc22;
    @FXML
    private Text Desc12;
    @FXML
    private Text Number72;
    @FXML
    private Text Number62;
    @FXML
    private Text Number52;
    @FXML
    private Text Number42;
    @FXML
    private Text Number32;
    @FXML
    private Text Number22;
    @FXML
    private Text Number12;
    @FXML
    private Text Desc73;
    @FXML
    private Text Desc63;
    @FXML
    private Text Desc53;
    @FXML
    private Text Desc43;
    @FXML
    private Text Desc33;
    @FXML
    private Text Desc23;
    @FXML
    private Text Desc13;
    @FXML
    private Text Number73;
    @FXML
    private Text Number63;
    @FXML
    private Text Number53;
    @FXML
    private Text Number43;
    @FXML
    private Text Number33;
    @FXML
    private Text Number23;
    @FXML
    private Text Number13;
    @FXML
    private Text Desc74;
    @FXML
    private Text Desc64;
    @FXML
    private Text Desc54;
    @FXML
    private Text Desc44;
    @FXML
    private Text Desc34;
    @FXML
    private Text Desc24;
    @FXML
    private Text Desc14;
    @FXML
    private Text Number74;
    @FXML
    private Text Number64;
    @FXML
    private Text Number54;
    @FXML
    private Text Number44;
    @FXML
    private Text Number34;
    @FXML
    private Text Number24;
    @FXML
    private Text Number14;
    @FXML
    private Text Desc75;
    @FXML
    private Text Desc65;
    @FXML
    private Text Desc55;
    @FXML
    private Text Desc45;
    @FXML
    private Text Desc35;
    @FXML
    private Text Desc25;
    @FXML
    private Text Desc15;
    @FXML
    private Text Number75;
    @FXML
    private Text Number65;
    @FXML
    private Text Number55;
    @FXML
    private Text Number45;
    @FXML
    private Text Number35;
    @FXML
    private Text Number25;
    @FXML
    private Text Number15;
    
    Hashtable<String, String> agenda = new Hashtable<String, String>(); 

    Text[] dayDesc, dayNumber;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dayDesc = new Text[]{Desc10, Desc20, Desc30, Desc40, Desc50, Desc60, Desc70, Desc11, Desc21, Desc31, Desc41, Desc51, Desc61, Desc71, Desc12, Desc22, Desc32, Desc42, Desc52, Desc62, Desc72, Desc13, Desc23, Desc33, Desc43, Desc53, Desc63, Desc73, Desc14, Desc24, Desc34, Desc44, Desc54, Desc64, Desc74, Desc15, Desc25, Desc35, Desc45, Desc55, Desc65, Desc75};
        dayNumber = new Text[]{Number10, Number20, Number30, Number40, Number50, Number60, Number70, Number11, Number21, Number31, Number41, Number51, Number61, Number71, Number12, Number22, Number32, Number42, Number52, Number62, Number72, Number13, Number23, Number33, Number43, Number53, Number63, Number73, Number14, Number24, Number34, Number44, Number54, Number64, Number74, Number15, Number25, Number35, Number45, Number55, Number65, Number75};


        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        
        ResetMonth();
        SetMonth(month);
        try {
            UpdateDays(month, year);

        } catch (ParseException ex) {
            Logger.getLogger(AgendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void Add_Consulta(ActionEvent event) throws ParseException {
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("dd-M-yyyy").parse("01-" + (month+1) + "-"+ year));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.DATE, 10);
        
        if(!(ExamDate.getValue().toString().length() == 0 || ExamName.getText().length() == 0)){
            BadStats.setOpacity(0);
            agenda.put(ExamDate.getValue().toString(), ExamName.getText());
            
        }
        else{
            BadStats.setOpacity(1);
            ExamDate.setValue(null);
            ExamName.setText(null);
        }
        
        UpdateDays(month, year);
    }

    @FXML
    private void MinusMonth(MouseEvent event) {

        Text[] dayDesc = {Desc10, Desc20, Desc30, Desc40, Desc50, Desc60, Desc70, Desc11, Desc21, Desc31, Desc41, Desc51, Desc61, Desc71, Desc12, Desc22, Desc32, Desc42, Desc52, Desc62, Desc72, Desc13, Desc23, Desc33, Desc43, Desc53, Desc63, Desc73, Desc14, Desc24, Desc34, Desc44, Desc54, Desc64, Desc74, Desc15, Desc25, Desc35, Desc45, Desc55, Desc65, Desc75};

        Text[] dayNumber = {Number10, Number20, Number30, Number40, Number50, Number60, Number70, Number11, Number21, Number31, Number41, Number51, Number61, Number71, Number12, Number22, Number32, Number42, Number52, Number62, Number72, Number13, Number23, Number33, Number43, Number53, Number63, Number73, Number14, Number24, Number34, Number44, Number54, Number64, Number74, Number15, Number25, Number35, Number45, Number55, Number65, Number75};
    
        
        if(month-1 <0){
            month = 11;
            year--;
        }
        else{
            month--;
        }
        ResetMonth();
        SetMonth(month);
        try {
            UpdateDays(month, year);
        } catch (ParseException ex) {
            Logger.getLogger(AgendaController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @FXML
    private void AddMonth(MouseEvent event) {
    
        Text[] dayDesc = {Desc10, Desc20, Desc30, Desc40, Desc50, Desc60, Desc70, Desc11, Desc21, Desc31, Desc41, Desc51, Desc61, Desc71, Desc12, Desc22, Desc32, Desc42, Desc52, Desc62, Desc72, Desc13, Desc23, Desc33, Desc43, Desc53, Desc63, Desc73, Desc14, Desc24, Desc34, Desc44, Desc54, Desc64, Desc74, Desc15, Desc25, Desc35, Desc45, Desc55, Desc65, Desc75};

        Text[] dayNumber = {Number10, Number20, Number30, Number40, Number50, Number60, Number70, Number11, Number21, Number31, Number41, Number51, Number61, Number71, Number12, Number22, Number32, Number42, Number52, Number62, Number72, Number13, Number23, Number33, Number43, Number53, Number63, Number73, Number14, Number24, Number34, Number44, Number54, Number64, Number74, Number15, Number25, Number35, Number45, Number55, Number65, Number75};
    
        if(month+1 >11){
            month = 0;
            year++;
        }
        else{
            month++;
        }
        ResetMonth();
        SetMonth(month);
        try {
            UpdateDays(month, year);
        } catch (ParseException ex) {
            Logger.getLogger(AgendaController.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    @FXML
    private void ResetMonth(){
        for(int i = 0; i<dayNumber.length;i++){
            dayNumber[i].setText("");
            dayDesc[i].setText("");
        }
    }
    
    @FXML
    private void SetMonth(int month){
        
        // tem maneiras melhores porem ficam em ingles
        switch(month){
            case 0:
                Month.setText("Janeiro");
                break;
            case 1:
                Month.setText("Fevereiro");
                break;
            case 2:
                Month.setText("Março");
                break;
            case 3:
                Month.setText("Abril");
                break;
            case 4:
                Month.setText("Maio");
                break;
            case 5:
                Month.setText("Junho");
                break;
            case 6:
                Month.setText("Julho");
                break;
            case 7:
                Month.setText("Agosto");
                break;
            case 8:
                Month.setText("Setembro");
                break;
            case 9:
                Month.setText("Outubro");
                break;
            case 10:
                Month.setText("Novembro");
                break;
            case 11:
                Month.setText("Dezembro");
                break;
            default:
                Month.setText("ERROR");
                break;
        }
    }
    
    @FXML
    private void UpdateDays(int month, int year) throws ParseException{
        Calendar c = Calendar.getInstance();
        c.setTime(new SimpleDateFormat("dd-M-yyyy").parse("01-" + (month+1) + "-"+ year));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int modifier = c.get(Calendar.DAY_OF_WEEK);
        
        YearMonth yearMonthObject = YearMonth.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
        
        // debug
        // dayNumber[41].setText(String.valueOf(c.get(Calendar.MONTH)+ 1));
        
        for(int i = 1; i<=yearMonthObject.lengthOfMonth(); i++){
            c.add(Calendar.DATE, 1);
            dayNumber[i+modifier-2].setText(String.valueOf(i));

            if(agenda.containsKey(sdf.format(c.getTime()))){
                dayDesc[i+modifier-1].setText(agenda.get(sdf.format(c.getTime())));
            }
        }
    }
}

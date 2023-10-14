/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Jabo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LessCostFXMLController extends Test implements Initializable {

    @FXML
    private TextArea lessCostText;
    @FXML
    private TextArea LessCostDes;

  
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        
        
    }    

    @FXML
    private void clickMeAction(ActionEvent event) throws IOException 
    {
           Test tt=new Test();
      Lesscost ls=new Lesscost(getTestSource(),getTestdetination());
      ls.solve();
      lessCostText.setText(ls.pathAns);
        
    }
    
}

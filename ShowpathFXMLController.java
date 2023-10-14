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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ShowpathFXMLController implements Initializable {

    @FXML
    private TextField sourceInput;
    @FXML
    private TextField destinationInput;
    @FXML
    private AnchorPane showPathMain;

    /**
     * Initializes the controller class.
     */
    String source1,destination1;
    @FXML
    private TextArea lessscostText;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        
        
        
    }    

    @FXML
    private void lessCostAction(ActionEvent event) throws IOException 
    {
       source1=sourceInput.getText();
       String so="";
       int pos;
       pos=0;
       for(int i=(int)source1.length()-1;i>=0;i--)
       {
            if(source1.charAt(i)==' '&&pos==0)
            {
                continue;
                
            }
            else if(source1.charAt(i)==' ') 
            {
                so+="_";
            }
            else
            {
                pos=1;
                so+=source1.charAt(i);
            }
            
       }
       source1="";
       for(int i=so.length()-1;i>=0;i--)
       {
           source1+=so.charAt(i);
       }
       
       
       destination1=destinationInput.getText();
       //commentable
       so="";
       pos=0;
       for(int i=(int)destination1.length()-1;i>=0;i--)
       {
            if(destination1.charAt(i)==' '&&pos==0)
            {
                continue;
                
            }
            else if(destination1.charAt(i)==' ') 
            {
                so+="_";
            }
            else
            {
                pos=1;
                so+=destination1.charAt(i);
            }
            
       }
       destination1="";
       for(int i=so.length()-1;i>=0;i--)
       {
           destination1+=so.charAt(i);
       }
       
        //System.out.println(source1+" "+destination1);
       Lesscost less=new Lesscost(source1,destination1);
       less.solve();
       if(less.check==1)
       {
            lessscostText.setText("Sorry This Path is not at my database.Hopefully this will be Connect soon\nThanks for use JABO. If you will Somehow konw the path Please Add My \ndatabase. You can Add path in my database by clicking ADD PATH button\nYou can add any path that you know.");
            return;
       }
       lessscostText.setText(less.pathAns);
       
    }

    @FXML
    private void lessTimeAction(ActionEvent event) throws IOException 
    {
        source1=sourceInput.getText();
        
        String so="";
       int pos;
       pos=0;
       for(int i=(int)source1.length()-1;i>=0;i--)
       {
            if(source1.charAt(i)==' '&&pos==0)
            {
                continue;
                
            }
            else if(source1.charAt(i)==' ') 
            {
                so+="_";
            }
            else
            {
                pos=1;
                so+=source1.charAt(i);
            }
            
       }
       source1="";
       for(int i=so.length()-1;i>=0;i--)
       {
           source1+=so.charAt(i);
       }
        
       destination1=destinationInput.getText();
       
         //commentable
       so="";
       pos=0;
       for(int i=(int)destination1.length()-1;i>=0;i--)
       {
            if(destination1.charAt(i)==' '&&pos==0)
            {
                continue;
                
            }
            else if(destination1.charAt(i)==' ') 
            {
                so+="_";
            }
            else
            {
                pos=1;
                so+=destination1.charAt(i);
            }
            
       }
       destination1="";
       for(int i=so.length()-1;i>=0;i--)
       {
           destination1+=so.charAt(i);
       }
       
       Lesstime less=new Lesstime(source1,destination1);
       less.solve();
       if(less.check==1)
       {
            lessscostText.setText("Sorry This Path is not at my database.Hopefully this will be Connect soon\nThanks for use JABO. If you will Somehow konw the path Please Add My \ndatabase. You can Add path in my database by clicking ADD PATH button\nYou can add any path that you know.");
            return;
       }
       lessscostText.setText(less.pathAns);
          
    }

    @FXML
    private void lessStopesAction(ActionEvent event) throws IOException 
    {
        source1=sourceInput.getText();
        
        String so="";
       int pos;
       pos=0;
       for(int i=(int)source1.length()-1;i>=0;i--)
       {
            if(source1.charAt(i)==' '&&pos==0)
            {
                continue;
                
            }
            else if(source1.charAt(i)==' ') 
            {
                so+="_";
            }
            else
            {
                pos=1;
                so+=source1.charAt(i);
            }
            
       }
       source1="";
       for(int i=so.length()-1;i>=0;i--)
       {
           source1+=so.charAt(i);
       }
        
        
        
       destination1=destinationInput.getText();
       
       
       //commentable
       so="";
       pos=0;
       for(int i=(int)destination1.length()-1;i>=0;i--)
       {
            if(destination1.charAt(i)==' '&&pos==0)
            {
                continue;
                
            }
            else if(destination1.charAt(i)==' ') 
            {
                so+="_";
            }
            else
            {
                pos=1;
                so+=destination1.charAt(i);
            }
            
       }
       destination1="";
       for(int i=so.length()-1;i>=0;i--)
       {
           destination1+=so.charAt(i);
       }
       
       
       Lessstopes less=new Lessstopes(source1,destination1);
       less.solve();
       if(less.check==1)
       {
            lessscostText.setText("Sorry This Path is not at my database.Hopefully this will be Connect soon\nThanks for use JABO. If you will Somehow konw the path Please Add My \ndatabase. You can Add path in my database by clicking ADD PATH button\nYou can add any path that you know.");
            return;
       }
       lessscostText.setText(less.pathAns);
        
    }
    
    
    
}

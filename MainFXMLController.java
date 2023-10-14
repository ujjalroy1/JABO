
package Jabo;

import java.io.IOException;
import java.net.URL;
import static java.time.Clock.system;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class MainFXMLController implements Initializable {

    @FXML
    private AnchorPane mainScene;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
        try {
           Parent pane = FXMLLoader.load(getClass().getResource("homeFXML.fxml"));
            mainScene.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    

    @FXML
    private void homeAction(ActionEvent event) throws IOException 
    {
        Parent pane = FXMLLoader.load(getClass().getResource("homeFXML.fxml"));
            mainScene.getChildren().setAll(pane);
        
    }

    @FXML
    private void exitAction(ActionEvent event) 
    {
        System.exit(0);
        
    }

    @FXML
    private void addpathAction(ActionEvent event) throws IOException
    {
         Parent pane = FXMLLoader.load(getClass().getResource("addpathFXML.fxml"));
            mainScene.getChildren().setAll(pane);
        
    }

    @FXML
    private void commentAction(ActionEvent event) throws IOException 
    {
        Parent pane = FXMLLoader.load(getClass().getResource("commentFXML.fxml"));
            mainScene.getChildren().setAll(pane);
        
    }

    @FXML
    private void contactAction(ActionEvent event) throws IOException 
    {
         Parent pane = FXMLLoader.load(getClass().getResource("contactFXML.fxml"));
            mainScene.getChildren().setAll(pane);
        
        
    }

    @FXML
    private void showPathAction(ActionEvent event) throws IOException
    {
        Parent pane=FXMLLoader.load(getClass().getResource("ShowpathFXML.fxml"));
        mainScene.getChildren().setAll(pane);
        
    }
    
    
}

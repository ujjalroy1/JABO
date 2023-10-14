
package Jabo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainClass extends Application
{
    public static void main(String[] args) 
    {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception 
    {
        
        Parent pane=FXMLLoader.load(getClass().getResource("mainFXML.fxml"));
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

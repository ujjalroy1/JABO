
package Jabo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddpathFXMLController implements Initializable 
{

    @FXML
    private TextField addSource;
    @FXML
    private TextField addDestination;
   // private TextField addTime;
    @FXML
    private TextField addCost;
    @FXML
    private TextArea addNote;
   // private Object mainScene;
    @FXML
    private AnchorPane mainaddpath;
    @FXML
    private TextField addHour;
    @FXML
    private TextField addMinutes;
    @FXML
    private TextField addSecond;
    @FXML
    private TextField addMedium;
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        
        
    }    

    @FXML
    private void sumbitAction(ActionEvent event) throws IOException
    {
        String source=addSource.getText();
        String destination=addDestination.getText();
       // String times=addTime.getText();
        String note=addNote.getText();
        String cost=addCost.getText();
        String minutes=addMinutes.getText();
        String hour=addHour.getText();  
        String second=addSecond.getText();
        String medium=addMedium.getText();
        if(medium.equals("")||hour.equals("")||minutes.equals("")||second.equals("")||source.equals("")||destination.equals("")||note.equals("")||cost.equals(""))
        {
             Parent pane = FXMLLoader.load(getClass().getResource("wrongFXML.fxml"));
             mainaddpath.getChildren().setAll(pane);
             return;
        }
        if(medium.contains(" ")||hour.contains(" ")||minutes.contains(" ")||second.contains(" ")||source.contains(" ")||destination.contains(" ")||note.contains("\n")||cost.contains(" "))
        {
            Parent pane = FXMLLoader.load(getClass().getResource("wrongFXML.fxml"));
             mainaddpath.getChildren().setAll(pane);
             return;
             
        }
        int c=0;
        //check number or not given hour
        for(int i=0;i<hour.length();i++)
        {
            if(hour.charAt(i)>='0'&&hour.charAt(i)<='9')continue;
            else 
            {
                c=1;
                break;
            }
            
        }
        //check number or not given minutes
         for(int i=0;i<minutes.length();i++)
        {
            if(minutes.charAt(i)>='0'&&minutes.charAt(i)<='9')continue;
            else 
            {
                c=1;
                break;
            }
            
        }
         
          //check number or not given seconds
         for(int i=0;i<second.length();i++)
        {
            if(second.charAt(i)>='0'&&second.charAt(i)<='9')continue;
            else 
            {
                c=1;
                break;
            }
            
        }
          //check number or not given cost
          int dot=0;
         for(int i=0;i<cost.length();i++)
        {
            if(cost.charAt(i)=='.')dot++;
            if((cost.charAt(i)>='0'&&cost.charAt(i)<='9')||(dot<=1))continue;
            else 
            {
                c=1;
                break;
            }
            
        }
         if(c==1)
         {
              Parent pane = FXMLLoader.load(getClass().getResource("wrongFXML.fxml"));
               mainaddpath.getChildren().setAll(pane);
             return;
         }
         File file=new File("Data.txt");
         if(!file.exists())
         {
             file.createNewFile();
             
         }
//         Lesscost less= new Lesscost(source,destination);
//         less.solve();
//         if(less.check==1)
//         {
//              Parent pane = FXMLLoader.load(getClass().getResource("rightFXML.fxml"));
//               mainaddpath.getChildren().setAll(pane);
//             return;
//         }
         

          
         FileWriter filewriter=new FileWriter(file,true);
         int timess=0;
         
         timess+=(Integer.parseInt(second));
         timess+=((Integer.parseInt(minutes))*60);
         timess+=((Integer.parseInt(hour))*60*60);
         
           int validityCheck=0;
            File file1 = new File("Data.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }
        Scanner input = new Scanner(file1);
        source=source.toLowerCase();
        destination=destination.toLowerCase();
        while (input.hasNext()) {
            String from, to, medium1, note1;
            int timee1, cost1;
            from = input.next();
            to = input.next();
            medium1 = input.next();
            timee1 = input.nextInt();
            cost1 = input.nextInt();
            note1 = input.nextLine();
            from = from.toLowerCase();
            to = to.toLowerCase();
            int costekhane=Integer.parseInt(cost);
            if(((source.equals(from)==true&&destination.equals(to)==true)||(source.equals(to)==true&&destination.equals(from)==true))&&medium.equals(medium1)==true&&timess==timee1&&costekhane==cost1)
            {
                validityCheck=1;
                //System.out.println("OKK\n");
                break;
            }
            
        }
         
         
         
         
         if(validityCheck==1)
         {
             Parent pane = FXMLLoader.load(getClass().getResource("rightFXML.fxml"));
               mainaddpath.getChildren().setAll(pane);
               return;
             
         }
         filewriter.write(source+" "+destination+" "+medium+" "+timess+" "+cost+" "+note+"\n");
         filewriter.close();
         Parent pane = FXMLLoader.load(getClass().getResource("rightFXML.fxml"));
               mainaddpath.getChildren().setAll(pane);
    }
    
}

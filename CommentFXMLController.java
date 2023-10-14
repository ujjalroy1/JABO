
package Jabo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class CommentFXMLController implements Initializable 
{

    @FXML
    private TextArea commenttext;
    @FXML
    private Label commentlabel;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
        
        
    }    

    @FXML
    private void commentsubmitAction(ActionEvent event) throws IOException 
    {
        String comment=commenttext.getText();
        if(comment.equals(""))
        {
            return;
        }
        File file=new File("Comment.txt");
        if(!file.exists())
        {
            file.createNewFile();
        }
        FileWriter filewriter=new FileWriter(file,true);
        filewriter.write(comment+"\n");
        filewriter.close();
        commenttext.clear();
        commentlabel.setText("Successfully add your commnet");
        
    }
    
}

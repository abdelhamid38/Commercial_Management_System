package test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Update_buttomController implements Initializable {

    @FXML
    void Go_gs(ActionEvent event) throws IOException {
        
                             Stage stage= new Stage();
                             Parent root=FXMLLoader.load(getClass().getResource("/test/Update_forniseur.fxml"));
                             Scene scene=new Scene(root);
                             stage.setScene(scene);
                             stage.show();
                             
    }

    @FXML
    void Go_to_up(ActionEvent event) throws IOException {
        
                             Stage stage= new Stage();
                             Parent root=FXMLLoader.load(getClass().getResource("@../test/Update.fxml"));
                             Scene scene=new Scene(root);
                             stage.setScene(scene);
                             stage.show();
                             
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

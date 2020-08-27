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
 
public class SuppremerController implements Initializable {
    
    @FXML
    void supp_forniseur(ActionEvent event) throws IOException {
     Stage stage= new Stage();
                             Parent root=FXMLLoader.load(getClass().getResource("/test/Update.fxml"));
                             Scene scene=new Scene(root);
                             stage.setScene(scene);
                             stage.show();
    }

    @FXML
    void supp_produit(ActionEvent event) throws IOException {
        Stage stage= new Stage();
                             Parent root=FXMLLoader.load(getClass().getResource("@../test/Update.fxml"));
                             Scene scene=new Scene(root);
                             stage.setScene(scene);
                             stage.show();

    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

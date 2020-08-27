package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
public class login extends Application {
    
    @Override
    public void start(Stage stage)  {
        try {
          Parent root=FXMLLoader.load(getClass().getResource("/FXML/project.fxml"));
          Scene scene=new Scene(root);
          stage.setScene(scene);
          stage.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
       
       }

    public static void main(String[] args) {
        launch(args);
    }
}

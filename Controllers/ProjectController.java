package test;

import DB.DB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class ProjectController extends login implements Initializable {
   @FXML
    private JFXButton login;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label st;

    @FXML
    private JFXButton check;

    @FXML
    private Label check1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.addEventFilter(MouseEvent.MOUSE_CLICKED, eventFilter->{
            
            
              PreparedStatement ps1;
              ResultSet rs1 ;
              Connection con ;
              PreparedStatement ps2;
              ResultSet rs2 ;
      
              PreparedStatement ps3;
              ResultSet rs3 ;
       
       
       try{
           con = DB.getConnection();
           String sql1 = "SELECT * FROM admin WHERE username ='" +username.getText() +"' AND password = '"+password.getText()+"'AND cas_utiliser='Admin'";
           ps1 = con.prepareStatement(sql1);
           rs1 = ps1.executeQuery();
           
           String sql2 = "SELECT * FROM Admin WHERE username ='" +username.getText() +"' AND password = '"+password.getText()+"'AND cas_utiliser='Vendeur'";
           ps2 = con.prepareStatement(sql2);
           rs2 = ps2.executeQuery();
           
           String sql3 = "SELECT * FROM Admin WHERE username ='" +username.getText() +"' AND password = '"+password.getText()+"'AND cas_utiliser='Stock'";
           ps3 = con.prepareStatement(sql3);
           rs3 = ps3.executeQuery();
           
           try {
                if(rs1.next()){
                  Parent Root=FXMLLoader.load(getClass().getResource("/test/consultadmin.fxml"));
                  Scene vent= new Scene(Root);
                  Stage admin= (Stage)login.getScene().getWindow();
                  admin.setScene(vent);
                  admin.show();  
                              }else 
                if (rs2.next()){
            
                  Parent Root=FXMLLoader.load(getClass().getResource("/test/cr.fxml"));
                  Scene vent= new Scene(Root);
                  Stage admin= (Stage) login.getScene().getWindow();
                  admin.setScene(vent);
                  admin.show(); 
                              }else
                if (rs3.next()){
                             
                  Parent Root=FXMLLoader.load(getClass().getResource("/test/Stock.fxml"));
                  Scene vent= new Scene(Root);
                  Stage admin= (Stage) login.getScene().getWindow();
                  admin.setScene(vent);
                  admin.show();         
                         
                               }else {
                             
                  st.setText("Failed try again");
                  username.setText(null);
                  password.setText(null);         
         }  
           } catch (SQLException | IOException e) {
           }
           
          
       }catch(ClassNotFoundException|SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }  
        });
    check.addEventFilter(MouseEvent.MOUSE_CLICKED, eventFilter->{
           try {
                    Connection c=DB.getConnection(); 
           if(!c.isClosed()){
                    check1.setText("Connect");
           }else{
                    check1.setText("! Connect");
          }  
        } catch (ClassNotFoundException | SQLException e) {
      }
    });
  }
}
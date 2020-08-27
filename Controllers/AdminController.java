package test;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class AdminController implements Initializable {

    @FXML
    private JFXTextField ID;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXTextField Password;

    @FXML
    private JFXTextField Cas_utiliser;

    @FXML
    private JFXTextField Date;

    @FXML
    void Appliquer(ActionEvent event) {
      try {
            Connection con=DB.DB.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM `admin` WHERE ID='"+ID.getText()+"'");
            ResultSet rs=ps.executeQuery();
            rs.next();
          } catch (ClassNotFoundException | SQLException e) {
        }
    }

    @FXML
    void Get_information(ActionEvent event) {
        try {
            Connection con=DB.DB.getConnection();
            PreparedStatement ps=con.prepareStatement("DELETE FROM `admin` WHERE ID='"+ID.getText()+"'");
            ResultSet rs=ps.executeQuery();
            Boolean a=false;
            while(rs.next()){
                if(rs.getInt(1)==Integer.parseInt(ID.getText())){
                    a=true;
                }
                }
            
                if(a== true && Integer.parseInt(ID.getText())==rs.getInt(1)){
                    
                    
                    Username.setText(rs.getString(2));
                    Password.setText(rs.getString(3));
                    Cas_utiliser.setText(rs.getString(4));
                    Date.setText(rs.getString(5));
                    
                } else {
                }
            
            
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

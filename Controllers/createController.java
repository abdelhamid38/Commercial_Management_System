package test;

import DB.DB;
import DB.produit;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class createController implements Initializable {

    @FXML
    private JFXComboBox<Label> comp;

    @FXML
    private JFXTextField quantity;

    @FXML
    private TableColumn<produit,Integer> id_prod;

    @FXML
    private TableColumn<produit,String> nom_prod;

    @FXML
    private TableColumn<produit,Integer> prix;

    @FXML
    private TableColumn<produit,Integer> Quantity;
    
    @FXML
    private Label prix_total;
    
    @FXML
    private TableView<produit> table;
    
    AnchorPane anchorpane;
    
    int prixtotal=0;
   
    ObservableList<produit>data1 =FXCollections.observableArrayList();
    
    Connection con =null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    public void inserteproduits() throws ClassNotFoundException, SQLException{
      
    }
    @FXML
    void Add(ActionEvent event) {
      if(comp.getSelectionModel().isEmpty() && quantity.getText().isEmpty()){
       JOptionPane.showMessageDialog(null,"please shoose a product and quantity");
      }else{
        try {
                
              con=DB.getConnection();
              ps=con.prepareStatement("SELECT * FROM produits WHERE nom = '"+comp.getSelectionModel().getSelectedItem().getText()+"'");
              rs=ps.executeQuery();
              rs.next();
              
             
              if(rs.getInt(5)>=Integer.parseInt(quantity.getText())){
                  
                  
              data1.add(new produit(rs.getInt(1),rs.getString(2),rs.getInt(3),Integer.parseInt(quantity.getText()) ));
             
              
              nom_prod.setCellValueFactory(new PropertyValueFactory <> ("nom_pro"));
              prix.setCellValueFactory(new PropertyValueFactory <> ("prix"));
              Quantity.setCellValueFactory(new PropertyValueFactory <> ("contity"));
              id_prod.setCellValueFactory(new PropertyValueFactory <> ("id_prod"));
             
             table.setItems(data1);
             
             prixtotal=prixtotal+(rs.getInt(3)*Integer.parseInt(quantity.getText()));
             prix_total.setText("  Prix total"+"  "+prixtotal+"  DA");
             
              }else{
                  JOptionPane.showMessageDialog(null,"Quantity not exsist");
              }
              
            } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
             
                JOptionPane.showMessageDialog(null,e.getMessage()); 
             
            
            }
      }
      
        quantity.setText("");
        comp.getSelectionModel().clearSelection();
        
    }
    @FXML
    void Reset(ActionEvent e){
       
       comp.getSelectionModel().clearSelection();
       prix_total.setText(null);
       quantity.setText(null);
       table.getItems().removeAll(data1);
      
    }
    
     @FXML
    void Update(ActionEvent event) throws IOException {
      Stage stage= new Stage();
      Parent root=FXMLLoader.load(getClass().getResource("/test/Print.fxml"));
      Scene scene=new Scene(root);
      stage.setScene(scene);
      stage.show();
    }

    @FXML
    void Save(ActionEvent e)throws IOException{
 
           Stage stage= new Stage();
           Parent root=FXMLLoader.load(getClass().getResource("/test/impremer.fxml"));
           Scene scene=new Scene(root);
           stage.setScene(scene);
           stage.show();
         
        }
    
    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    ObservableList<Object> data= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label L=new Label();
        L.setFont(Font.font("Tahoma",18));
        L.setGraphic(new ImageView("1.png"));
        comp.getItems().add(L);
        L.setPrefSize(100,25);
        try {
            con=DB.getConnection();
            ps=con.prepareStatement("SELECT nom,prix FROM produits");
            rs=ps.executeQuery();
            while (rs.next()){
                
                //Label l=new Label("nom :"+rs.getString(1)+"  prix = "+rs.getInt(2));
                Label l= new Label(rs.getString(1));
                l.setPrefSize(100,25);
                l.setAlignment(Pos.CENTER);
                l.setFont(Font.font("Tahoma",18));
                l.setGraphic(new ImageView("Images/4.png"));
           //     l.setTooltip(new Tooltip("prix"+rs.getInt(3)));
                comp.getItems().add(l);
                
            } 
        } catch (ClassNotFoundException | SQLException e) {
        }finally{
            try {
                con.close();
            } catch (Exception e) {
            }
        }  
    }
 private void print(Node node) {

    javafx.print.PrinterJob job = javafx.print.PrinterJob.createPrinterJob();
    if (job != null) {

      boolean printed = job.printPage(node);
      if (printed) {
        job.endJob();
      } else {
      }
    } else {
    }
    }    
}
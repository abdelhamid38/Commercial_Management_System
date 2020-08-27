package test;

import DB.DB;
import DB.forniseur;
import DB.produit;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ConsultadminController implements Initializable {
    
    @FXML
    private TableView<forniseur> table2;

    @FXML
    private TableColumn<forniseur,Integer> idf;

    @FXML
    private TableColumn<forniseur,String> prenom_de_forniseur;
    
    @FXML
    private TableColumn<forniseur,String> nom_de_forniseurs;

    @FXML
    private TableColumn<forniseur,String> nom_de_produits;

    @FXML
    private TableColumn<forniseur,Integer> ntlf;

    @FXML
    private TableColumn<forniseur,Date> datef;
    
    @FXML
    private TableView<produit> table;
     
    @FXML
    private TableColumn<produit,Integer> ID;

    @FXML
    private TableColumn<produit,String> nom_de_produit;

    @FXML
    private TableColumn<produit,String> nom_de_forniseur;

    @FXML
    private TableColumn<produit,Integer> prix_de_produit;

    @FXML
    private TableColumn<produit,Integer> quantity;

    @FXML
    private TableColumn<produit,Date> date;
    
     @FXML
    private JFXDrawer slider1;

    @FXML
    private JFXHamburger hamp;
    
    @FXML
    AnchorPane paneprimiter;

    public ObservableList<produit> data =FXCollections.observableArrayList();
    public ObservableList<forniseur> data1 =FXCollections.observableArrayList();
    
//    @FXML
//    void Add_Vendeur(ActionEvent event) {
//        
//        try {
//            Connection con=DB.getConnection();
//            PreparedStatement ps= con.prepareStatement("INSERT INTO `admin`(`username`, `password`,`cas_utiliser`) VALUES ('boucif','boucif','Vendeur')");
//            ResultSet rs=ps.executeQuery();
//        } catch (ClassNotFoundException | SQLException e) {
//        }
//
//    }
    
       @FXML
    void back(ActionEvent event) throws IOException{
        
        
             Parent Root=FXMLLoader.load(getClass().getResource("/test/adminisrateur.fxml"));
             Scene vent= new Scene(Root);
             Stage admin= (Stage) ((Node) event.getSource()).getScene().getWindow();
             admin.setScene(vent);
             admin.show();           
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            
            
             Connection con=DB.getConnection();
             String SQL="SELECT * FROM produits";
             PreparedStatement ps=con.prepareStatement(SQL);
             ResultSet rs= ps.executeQuery();
             
             while(rs.next()){
                 
                 data.add(new produit(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getInt(3),rs.getInt(5),rs.getDate(6)));
                 
             }  
             ID.setCellValueFactory(new PropertyValueFactory <> ("Id"));
             nom_de_produit.setCellValueFactory(new PropertyValueFactory <> ("nom_pro"));
             nom_de_forniseur.setCellValueFactory(new PropertyValueFactory <> ("nom_for"));
             prix_de_produit.setCellValueFactory(new PropertyValueFactory <> ("prix"));
             quantity.setCellValueFactory(new PropertyValueFactory <> ("contity"));
             date.setCellValueFactory(new PropertyValueFactory <> ("date"));
            
             table.setItems(data);
             
             
             } catch (ClassNotFoundException | SQLException e) {
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
         try {
             Connection con=DB.getConnection();
            String SQL1="SELECT * FROM forniseur";
            PreparedStatement ps =con.prepareStatement(SQL1);
            ResultSet rs=ps.executeQuery();
             while(rs.next()){
                data1.add(new forniseur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDate(6)));
             }
            
             idf.setCellValueFactory(new PropertyValueFactory <> ("IDF"));
             prenom_de_forniseur.setCellValueFactory(new PropertyValueFactory <> ("pre_nom"));
             nom_de_forniseurs.setCellValueFactory(new PropertyValueFactory <> ("nom_for"));
             nom_de_produits.setCellValueFactory(new PropertyValueFactory <> ("nom_pro"));
             ntlf.setCellValueFactory(new PropertyValueFactory <> ("num_tlf"));
             datef.setCellValueFactory(new PropertyValueFactory <> ("date"));
             
             table2.setItems(data1);
        } catch (ClassNotFoundException | SQLException e) {
        }
            try {
             Pane A=FXMLLoader.load(getClass().getResource("Bottom.fxml"));
             slider1.setSidePane(A);
             for(Node n:A.getChildren()){
             
               n.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
                
                     try {  
                         
                         switch (n.getAccessibleText()){
                             
                             case "Add_admin":
                               
                                 slider1.close();
                                 break;
                                 
                             case "Add_vandeur":
                                 
                                
                                 break;
                             case "Add_stock":
                                 
                                
                                 slider1.close();
                                 break;
                             case "Remove_admin":
                                 Stage stage= new Stage();
                                 Parent root=FXMLLoader.load(getClass().getResource("/test/Admin.fxml"));
                                 Scene scene=new Scene(root);
                                 stage.setScene(scene);
                                 stage.show();
                                 slider1.close();
                                 
                                 break;
                             case "Remove_vendeur":
                                 Stage stage1= new Stage();
                                 Parent root1=FXMLLoader.load(getClass().getResource("/test/Admin.fxml"));
                                 Scene scene1=new Scene(root1);
                                 stage1.setScene(scene1);
                                 stage1.show();
                                 slider1.close();
                                 
                                 break;
                             case "Remove_stock":
                                 Stage stage2= new Stage();
                                 Parent root2=FXMLLoader.load(getClass().getResource("/test/Admin.fxml"));
                                 Scene scene2=new Scene(root2);
                                 stage2.setScene(scene2);
                                 stage2.show(); 
                                 slider1.close();
                                 
                                 break;
                            case "Go_to_vente":
                                 
                                 Parent Roote=FXMLLoader.load(getClass().getResource("/test/cr.fxml"));
                                 Scene vente= new Scene(Roote);
                                 Stage adminss= (Stage) ((Node) e.getSource()).getScene().getWindow();
                                 adminss.setScene(vente);
                                 adminss.show();  
                                 
                                 break;
                            case "Go_to_stock":
                                 
                                Parent Rootes=FXMLLoader.load(getClass().getResource("/test/Stock.fxml"));
                                Scene ventes= new Scene(Rootes);
                                Stage admins= (Stage) ((Node) e.getSource()).getScene().getWindow();
                                admins.setScene(ventes);
                                admins.show();
                                
                                 break;
                         }
                     } catch (IOException | HeadlessException ee) {
                     }
                 
             });
         }}
              catch (IOException ex) {
        }
         
            
          HamburgerBasicCloseTransition ab=new HamburgerBasicCloseTransition(hamp);
          ab.setRate(-1);
          hamp.addEventFilter(MouseEvent.MOUSE_CLICKED,e-> {
                ab.setRate(ab.getRate()*-1);
                ab.play();
                if(!slider1.isHidden()){
                    slider1.close();
                    
                }else{
                    slider1.open();
                    
                }
            }); 
       
        }    
    }

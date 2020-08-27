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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class StockController implements Initializable {

    @FXML
    private JFXHamburger hmb;

    @FXML
    private JFXDrawer sliders;
    
    @FXML
    private Pane pane;
    
    @FXML
    private TableView<produit> table1;

    @FXML
    private TableColumn<produit,Integer> idv;

    @FXML
    private TableColumn<produit,String> nom_prov;

    @FXML
    private TableColumn<produit,String> nom_forv;

    @FXML
    private TableColumn<produit,Integer> prix_prov;

    @FXML
    private TableColumn<produit,Integer> Quantityv;

    @FXML
    private TableColumn<produit,Date> datepv;

    @FXML
    private TableView<forniseur> table2;

    @FXML
    private TableColumn<forniseur,Integer> idfv;

    @FXML
    private TableColumn<forniseur, String> nom_for;

    @FXML
    private TableColumn<forniseur,String> re_nomf;

    @FXML
    private TableColumn<forniseur,String> nom_profv;

    @FXML
    private TableColumn<forniseur,Integer> numtlff;

    @FXML
    private TableColumn<forniseur,Date> datev;
    
    public ObservableList<produit> data =FXCollections.observableArrayList();
    public ObservableList<forniseur> data1 =FXCollections.observableArrayList();
    
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
             idv.setCellValueFactory(new PropertyValueFactory <> ("Id"));
             nom_prov.setCellValueFactory(new PropertyValueFactory <> ("nom_pro"));
             nom_forv.setCellValueFactory(new PropertyValueFactory <> ("nom_for"));
             prix_prov.setCellValueFactory(new PropertyValueFactory <> ("prix"));
             Quantityv.setCellValueFactory(new PropertyValueFactory <> ("contity"));
             datepv.setCellValueFactory(new PropertyValueFactory <> ("date"));
            
             table1.setItems(data);
             
             
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
            
             idfv.setCellValueFactory(new PropertyValueFactory <> ("IDF"));
             re_nomf.setCellValueFactory(new PropertyValueFactory <> ("pre_nom"));
             nom_for.setCellValueFactory(new PropertyValueFactory <> ("nom_for"));
             nom_profv.setCellValueFactory(new PropertyValueFactory <> ("nom_pro"));
             numtlff.setCellValueFactory(new PropertyValueFactory <> ("num_tlf"));
             datev.setCellValueFactory(new PropertyValueFactory <> ("date"));
             
             table2.setItems(data1);
        } catch (ClassNotFoundException | SQLException e) {
        }
        
         try {
          
             VBox vb=FXMLLoader.load(getClass().getResource("/test/menu_stock.fxml")); 
             sliders.setSidePane(vb);
             
         for(Node n:vb.getChildren()){
             
             n.addEventHandler(MouseEvent.MOUSE_CLICKED, e->{
                 
                 
                 try {
                     
                      switch (n.getAccessibleText()){
                        
                        case "Creates":
                      
                        
                                                          
                             JOptionPane.showMessageDialog(null, "hallo");
                              
                          
                               break;
                         
                        case "Updates":
                            
                             Stage stage= new Stage();
                             Parent root=FXMLLoader.load(getClass().getResource("/test/Update_buttom.fxml"));
                             Scene scene=new Scene(root);
                             stage.setScene(scene);
                             stage.show();
                             
                              break;
                        case "removes":
                                    
                         
                             Stage stag= new Stage();
                             Parent r=FXMLLoader.load(getClass().getResource("/test/suppremer.fxml"));
                             Scene s=new Scene(r);
                             stag.setScene(s);
                             stag.show();
                             
                             break;
                    
                        case "Exits":
                            
                               Platform.exit();
                               
                      }
                 } catch (HeadlessException | IOException ee) {
                 }
             });
         }   
         
            
          HamburgerBasicCloseTransition ab=new HamburgerBasicCloseTransition(hmb);
          ab.setRate(-1);
           hmb.addEventFilter(MouseEvent.MOUSE_CLICKED,e-> {
                ab.setRate(ab.getRate()*-1);
                ab.play();
                if(!sliders.isHidden()){
                    sliders.close();
                    
                }else{
                    sliders.open();       
                }
            });  
        } 
        catch (IOException ex) {
        }  
        }
    }        
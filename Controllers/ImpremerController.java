package test;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ImpremerController implements Initializable {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Pane bull;
    @FXML
    public void printInvoice() {
        
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    void impremer() throws IOException {
//        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//            a.setContentText( "vouler vous imprimer  ?");
//            a.showAndWait();
//      a.setOnCloseRequest(e->{
//          ButtonType rs = a.getResult();
//          
//          if(rs == ButtonType.OK){
//              
              print(bull);
//          }else{
//              
//          }
//      });
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

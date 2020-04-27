package airline;
import java.sql.Connection;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.ResultSet;
import static airline.CustomerController.i;


public class PaymentController implements Initializable {
   public PaymentModel paymentmodel= new PaymentModel();
    @FXML
    private TextField cardno;

    @FXML
    private TextField cardname;

    @FXML
    private PasswordField cvvv;

    @FXML
    private TextField mont;

    @FXML
    private TextField yr;

    
    
    @FXML
    private Label Total;
    @FXML
    private Label alertLabel;
  
    Connection con ;
    
  

    public PaymentController(){
     con = SqlConnection.Connector();
  }
  @Override
  public void initialize(URL url, ResourceBundle rb) {
     i= LoginController.cust_id;//customer id which is primary key
       //ze= MenuController.i;
       System.out.println(""+i);
      
       if(paymentmodel.isDbConnected()){
           System.out.println("Db connected");
      }else{
           System.out.println("Db not connected");
      }
       calculate();
       
  }    
  public void calculate(){
      try {
          
          String query="SELECT sum(p.childprice) AS child_amount FROM booking b ,price p WHERE b.classid=p.classid and b.category='Child' AND b.customer_id='"+i+"'";
          String query1="SELECT sum(p.adultprice) AS adult_amount FROM booking b ,price p WHERE b.classid=p.classid and b.category='Adult' AND b.customer_id='"+i+"';";
          ResultSet rs =con.createStatement().executeQuery(query);
          ResultSet rs1 =con.createStatement().executeQuery(query1);
          int totalamount;
          int totalamount1;
          while(rs.next()&& rs1.next()){
           
               totalamount=rs.getInt("child_amount");
               totalamount1=rs1.getInt("adult_amount");
              
              Total.setText(Integer.toString(totalamount1+totalamount));
              
         
          }
      } catch (SQLException ex) {
          Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
    @FXML
    public void pay(ActionEvent event){
    	
        String cardnumber=cardno.getText();
        String cardholdername=cardname.getText();
        String  cvv=cvvv.getText();
        String month=mont.getText();
        String year=yr.getText();
       
     
        
        
       try {
            if((cardnumber.isEmpty()||cardholdername.isEmpty()||cvv.isEmpty()||month.isEmpty()||year.isEmpty())){
                
                    
                if(!(cardno.getText().length()==16)){
                	alertLabel.setText("enter valid card numder");
                    return;
                }else if(!(cvvv.getText().length()==3)){
                	alertLabel.setText("enter valid CVV");
                    return;
                }else if(!((mont.getText()).matches("0?[1-9]|1[012]"))){
                	alertLabel.setText("Enter valid month");
                    return;
                }else if(!((yr.getText()).matches("1[8-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9]"))){
                	alertLabel.setText("Enter valid year");
                    return;
                }
                
           }
               else{
            	  
               alertLabel.setText("");
               paymentmodel.paying(cardnumber, cardholdername, cvv, month, year); 
               alertLabel.setText("Payment Sucessfull");
               infoBox("Ordered",null,"Success" );
               Node node = (Node)event.getSource();
               Stage dialogStage = (Stage) node.getScene().getWindow();
               dialogStage.close();
               dialogStage.getIcons().add(new Image("/images/icon.png"));
               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Customer.fxml")));
               dialogStage.setScene(scene);
               dialogStage.show();
               Mail.main(new String[0]);
           }
           
       } catch (SQLException ex) {
           alertLabel.setText("Please fill balnk fields");
           Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
       }catch(IOException ex){
           System.out.println(""+ex);
       }
        
        
        
    }
 public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
 
 public static void infoBox1(String infoMessage, String headerText, String title){
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setContentText(infoMessage);
     alert.setTitle(title);
     alert.setHeaderText(headerText);
     alert.showAndWait();
 }

    
}

package airline;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static airline.CustomerController.i;

public class BookingController implements Initializable {
   public BookingModel Addf= new BookingModel();
    @FXML
    private JFXTextField passport;
    private String radioButtonLabel;
    private String radioButtonLabel1;

    @FXML
    private JFXTextField fname;

    @FXML
    private JFXTextField lname;

    @FXML
    private JFXTextField flightno;

    @FXML
    private JFXTextField source;

    @FXML
    private JFXTextField destination;

    @FXML
   private JFXDatePicker textdate;

    @FXML
    private JFXButton save;
    
    @FXML
    private JFXTextField phone;

    @FXML
    private JFXRadioButton adultprice;
    @FXML
    private JFXRadioButton childprice;
    @FXML
    private JFXRadioButton fclass;
    @FXML
    private JFXRadioButton bclass;
    @FXML
    private JFXRadioButton eclass;

    /*@FXML
    private Label custLabel;
  */
    
    
   
    private String date;
    @FXML
    private ToggleGroup group1;
    @FXML
    private ToggleGroup group2;
    @FXML
    private Label alertLabel;
  
    private double xOffset = 0;
    private double yOffset = 0;
   
   @FXML
   private void exitScreen(ActionEvent event){
        System.exit(0);
    }
   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    	 group1 = new ToggleGroup();
    	 fclass.setToggleGroup(group1);
    	 bclass.setToggleGroup(group1);
    	eclass.setToggleGroup(group1);
    	
    	 adultprice.setToggleGroup(group2);
     	childprice.setToggleGroup(group2);
     	
    	
    	i= LoginController.cust_id;//customer id which is primary key
         
    	
    	if(Addf.isDbConnected()){
            System.out.println("connected");
        }else{
            System.out.println("not connected");
        }
    }  
    
    
    
    @FXML
    public void Save(ActionEvent event) {
    	
    	String message="";
    	String message1="";
    	if(adultprice.isSelected())
        {
        	childprice.setSelected(false);
        	
        	message = adultprice.getText();
        }
        
        if(childprice.isSelected())
        {
        	adultprice.setSelected(false);
        	
        	message = childprice.getText();
        }

    	
    	
    	
    	

    	if(fclass.isSelected())
        {
        	bclass.setSelected(false);
        	eclass.setSelected(false);
        	message1 = "1";
        }
        
        if(bclass.isSelected())
        {
        	fclass.setSelected(false);
        	eclass.setSelected(false);
        	message1 = "2";
        }
        
        if(eclass.isSelected())
        {
        	fclass.setSelected(false);
        	eclass.setSelected(false);
        	message1 ="3";
        }

        String pno=passport.getText();
        String fn=fname.getText();
        String  ln=lname.getText();
        String fno=flightno.getText();
        String src=source.getText();
        String dest=destination.getText();
       String phon=phone.getText();
      
      try {
           if((pno.isEmpty() || fn.isEmpty() || ln.isEmpty() || fno.isEmpty() || src.isEmpty() || dest.isEmpty() || phon.isEmpty() ||  message.isEmpty() || message1.isEmpty()  ))  
        		   {
              alertLabel.setText("Please fill blank fields");
        		   
           }
         
           else{
              Addf.book(pno , fn, ln, fno, src, dest, phon,textdate.getValue().toString(),message,message1);  
               alertLabel.setText(" Sucessfully saved");
               infoBox("Saved Successfull",null,"Success" );
               Node node = (Node)event.getSource();
               Stage dialogStage = (Stage) node.getScene().getWindow();
               dialogStage.close();
               dialogStage.getIcons().add(new Image("/images/icon.png"));
               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Customer.fxml")));
               dialogStage.setScene(scene);
               dialogStage.show();
             
             
           
           }
       } catch (SQLException ex) {
           alertLabel.setText("Please fill blanks fields");
           
           ex.printStackTrace();
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
 
  
    
}

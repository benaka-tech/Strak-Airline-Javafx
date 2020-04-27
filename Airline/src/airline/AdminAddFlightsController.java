package airline;

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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AdminAddFlightsController implements Initializable {
   public AdminAddFlights Addf= new AdminAddFlights();
    @FXML
    private JFXTextField textfno;

    @FXML
    private JFXTextField textmodel;

    @FXML
    private JFXTextField textsrc;

    @FXML
    private JFXTextField textdest;

    @FXML
    private JFXTextField textdtime;

    @FXML
    private JFXTextField textatime;

    @FXML
    private JFXDatePicker textdate;
    @FXML
    private JFXTextField capacity;

    
    @FXML
    private CheckBox mcheck;
    @FXML
    private CheckBox ercheck;
    @FXML
    private CheckBox wcheck;
    
    private String Label1;
    private String Label2;
    private String Label3;
   
    
    @FXML
    private Label alertLabel;
  
   ObservableList<String> checkBoxList = FXCollections.observableArrayList();
    
   @FXML
   public void exitScreen(ActionEvent event) throws Exception{
		Stage primaryStage =new Stage();
       primaryStage.initStyle(StageStyle.UNDECORATED);
       primaryStage.getIcons().add(new Image("/images/icon.png"));
Parent root =FXMLLoader.load(getClass().getResource("Adminmenu.fxml"));
Scene scene = new Scene(root);
primaryStage.setScene(scene);
primaryStage.show();
((Node)(event.getSource())).getScene().getWindow().hide();

   }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Addf.isDbConnected()){
            System.out.println("connected");
        }else{
            System.out.println("not connected");
        }
    }  
    
    
    
    @FXML
    public void Save(ActionEvent event) {

   
    


String message1="";
String message2="";
String message3="";

        String fno=textfno.getText();
        String model=textmodel.getText();
        String  src=textsrc.getText();
        String dest=textdest.getText();
        String dtime=textdtime.getText();
        String atime=textatime.getText();
      







        
String cap=capacity.getText();
        
      try {
          if(( fno.isEmpty() || model.isEmpty() || src.isEmpty() || dest.isEmpty() || dtime.isEmpty() || atime.isEmpty() || cap.isEmpty() ))  
        		   {
              alertLabel.setText("Please fill blank fields");
        		   
           }
         
          
          else {
        	  

if(mcheck.isSelected())
{
	
	message1 += mcheck.getText();
}

if(ercheck.isSelected())
{
	
	message2 += ercheck.getText();
}
if(wcheck.isSelected())
{
	
	message3 += wcheck.getText();
}

alertLabel.setText(" ");
              Addf.AddFlights(fno , model, src, dest, dtime, atime,textdate.getValue().toString(),message1,message2,message3,cap);  
               alertLabel.setText(" Sucessfully saved");
               infoBox("Saved Successfull",null,"Success" );
               Node node = (Node)event.getSource();
               Stage dialogStage = (Stage) node.getScene().getWindow();
               dialogStage.close();
               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Adminmenu.fxml")));
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

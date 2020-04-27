package airline;

import static airline.CustomerController.i;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PriceController  implements Initializable {
	 public PriceModel pricee= new PriceModel();
    private String radioButtonLabel;
    //private String radioButtonLabel2;
    //private String radioButtonLabel3;
    
    
    @FXML
    private JFXRadioButton fclass;
    @FXML
    private JFXRadioButton bclass;
    @FXML
    private JFXRadioButton eclass;
    @FXML
    private Label alertLabel;
    @FXML
    private ToggleGroup group1;
    @FXML
    private TextArea area;
    @FXML
    private JFXTextField adultprice;
    @FXML
    private JFXTextField childprice;
    
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
       
    	
    	 group1 = new ToggleGroup();
    	 fclass.setToggleGroup(group1);
    	 bclass.setToggleGroup(group1);
    	eclass.setToggleGroup(group1);
    	
    	if(pricee.isDbConnected()){
            System.out.println("connected");
        }else{
            System.out.println("not connected");
        }
    }  
    @FXML
    public void Save(ActionEvent event) {

    	
    	
    	
    	String message="";
    	 if(fclass.isSelected())
         {
         	bclass.setSelected(false);
         	eclass.setSelected(false);
         	message = fclass.getText();
         }
         
         if(bclass.isSelected())
         {
         	fclass.setSelected(false);
         	eclass.setSelected(false);
         	message = bclass.getText();
         }
         
         if(eclass.isSelected())
         {
         	fclass.setSelected(false);
         	eclass.setSelected(false);
         	message = eclass.getText();
         }
       
     
    	
    	
        String adp=adultprice.getText();
        String cdp=childprice.getText();
        
        try {
        if( message.isEmpty()  )
        
        {
            alertLabel.setText("Please fill blank fields");
      		   
         }
        
        else {
        	
             alertLabel.setText(" ");    
        pricee.saving(message,adp,cdp);  
        alertLabel.setText(" Sucessfully saved");
        infoBox("Saved Successfull",null,"Success" );
        Node node = (Node)event.getSource();
        Stage dialogStage = (Stage) node.getScene().getWindow();
        dialogStage.close();
        dialogStage.getIcons().add(new Image("/images/icon.png"));
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
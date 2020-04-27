package airline;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Label progress;
    
    public static Label label;
    
    
    @FXML
    private ProgressBar progressBar;
    
    public static ProgressBar statProgressBar;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       
        
    }
    
    
     public void loginScreen(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
                primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent root =FXMLLoader.load(getClass().getResource("Login.fxml"));
		 primaryStage.getIcons().add(new Image("/images/icon.png"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
                
           
            ((Node)(event.getSource())).getScene().getWindow().hide();
	}
     @FXML
      public void signupScreen(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
                primaryStage.initStyle(StageStyle.UNDECORATED);
                primaryStage.getIcons().add(new Image("/images/icon.png"));
		Parent root =FXMLLoader.load(getClass().getResource("Signup.fxml"));
		 
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
                
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
	}
      
     @FXML
     public void adminScreen(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
               primaryStage.initStyle(StageStyle.UNDECORATED);
               primaryStage.getIcons().add(new Image("/images/icon.png"));
		Parent root =FXMLLoader.load(getClass().getResource("admin.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
               
          
           ((Node)(event.getSource())).getScene().getWindow().hide();
	}
     
    /* @FXML
     public void Flightadd(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
               primaryStage.initStyle(StageStyle.UNDECORATED);
               primaryStage.getIcons().add(new Image("/images/icon.png"));
		Parent root =FXMLLoader.load(getClass().getResource("AddFlights.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
               
           
           ((Node)(event.getSource())).getScene().getWindow().hide();
	}
     */
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	label = progress;
        statProgressBar = progressBar;
    }    
    
}

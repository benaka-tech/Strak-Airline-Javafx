package airline;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import static airline.SignupController.infoBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AdminLoginController implements Initializable {
    public AdminModel adminModel=new AdminModel();
   
    @FXML
    private JFXTextField textemail;

    @FXML
    private JFXPasswordField textpass;
    
    @FXML
    private Label alertLabel;
    public static int ad_id;
    public static String name;
   
  @FXML
  public void exitScreen(ActionEvent event) throws Exception{
		Stage primaryStage =new Stage();
      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.getIcons().add(new Image("/images/icon.png"));
      Parent root =FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

Scene scene = new Scene(root);
primaryStage.setScene(scene);
primaryStage.show();
((Node)(event.getSource())).getScene().getWindow().hide();
    }
      @FXML
     public void MenuScreen(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
		primaryStage.getIcons().add(new Image("/images/icon.png"));
		Parent root =FXMLLoader.load(getClass().getResource("Menu.fxml"));
                primaryStage.setTitle("Welcome To Foody Menu");
                
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
                
         
            ((Node)(event.getSource())).getScene().getWindow().hide();
	}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if(adminModel.isDbConnected()){
             System.out.println("Db connected");
        }else{
             System.out.println("Db not connected");
        }
    } 
    
     public static void AdminId(int cusst){
        ad_id=AdminModel.admin_id;
        
    }
     public static void Name(String cusname){
    	 name=AdminModel.first_name;
         
     } 
     
    public void AdminLogin(ActionEvent event){
     try {
            if(adminModel.AdminLogin(textemail.getText(), textpass.getText())){
                infoBox("Login Successfull.Welcome "+name,null,"Success" );
                
                Node node = (Node)event.getSource();
                Stage primaryStage =new Stage();
               Stage dialogStage = (Stage) node.getScene().getWindow();
               dialogStage.close();

       		primaryStage.getIcons().add(new Image("/images/icon.png"));
               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Adminmenu.fxml")));
		primaryStage.setScene(scene);

               dialogStage.setScene(scene);
               dialogStage.show();
                
                
            }else{
                infoBox("Enter correct email and password",null,"Failed" );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
            alertLabel.setText("Enter correct email and password");
        } catch (IOException ex) {
            Logger.getLogger(AdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
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

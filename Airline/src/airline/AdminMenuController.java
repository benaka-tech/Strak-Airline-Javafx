package airline;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;


	public class AdminMenuController implements Initializable {
		 public AdminMenuModel admodel =new AdminMenuModel();
		@FXML
		private PasswordField oldpasstxt;
		@FXML
		private PasswordField newpasstxt;
		
		
		@FXML
		private WebView webView;
		@FXML
		private WebEngine engine;
		@FXML
		private JFXButton button1;
		
		
		
		@FXML
		private TableView<AdminMenuTable> tableAdd;
		@FXML
		private TableColumn<AdminMenuTable,Integer> flight_no;
		@FXML
		private TableColumn<AdminMenuTable,String> flight_model;
		@FXML
		private TableColumn<AdminMenuTable,String> source;
		@FXML
		private TableColumn<AdminMenuTable,String> destination;
		@FXML
		private TableColumn<AdminMenuTable,String>departure_time;
		@FXML
		private TableColumn<AdminMenuTable,String> arrival_time;
		@FXML
		private TableColumn<AdminMenuTable,String> capacity;
		
		@FXML
		private TableColumn<AdminMenuTable,String> flight_date;
		
		@FXML
		private JFXTextField deleltebyno;
		private Label totalAdultAmount;
	    @FXML
	    private Label totalChildAmount;
	    @FXML
	    private Label Total;
	    @FXML
	    private TableView<CartTable> tablecart;

		@FXML
		private TableColumn<CartTable,Integer> pno;
		@FXML
		private TableColumn<CartTable,String> fname;
		@FXML
		private TableColumn<CartTable,String> lname;
		@FXML
		private TableColumn<CartTable,Integer> cflight_no;
		@FXML
		private TableColumn<CartTable,String>csource;
		@FXML
		private TableColumn<CartTable,String> cdestination;
		@FXML
		private TableColumn<CartTable,String> cphone;
		
		@FXML
		private TableColumn<CartTable,String> fc;
		@FXML
		private TableColumn<CartTable,String> ec;
		
		@FXML
		private TableColumn<CartTable,String> bc;
		@FXML
		private TableColumn<CartTable,String> date;
		@FXML
		private TableColumn<CartTable,String> cartcategory;
		@FXML
		private TableColumn<CartTable,String> cartclassid;
	   
		
	    @FXML
	    private TableView<PriceTable> tableprice;
		
		@FXML
		private TableColumn<PriceTable,Integer> classid;
		@FXML
		private TableColumn<PriceTable,String> classes;
		@FXML
		private TableColumn<PriceTable,Integer> aprice;
		@FXML
		private TableColumn<PriceTable,Integer> cprice;
		
		
		
		@FXML
		
		private TableView<AdminTable> tableadmin;
		
		
		
		@FXML
		
		private TableColumn<AdminTable,Integer> adminid;
		
		@FXML
		
		private TableColumn<AdminTable,String> adminfname;
		
		@FXML
		
		private TableColumn<AdminTable,String> adminlname;
		
		@FXML
		
		private TableColumn<AdminTable,String> emailadmin;
		
		@FXML
		
		private TableColumn<AdminTable,String> phoneadmin;
		
		
		
		 boolean type;
		ObservableList<AdminMenuTable> List= FXCollections.observableArrayList();
		ObservableList<CartTable> obList1= FXCollections.observableArrayList();
	    ObservableList<PriceTable> obList2= FXCollections.observableArrayList();
	    ObservableList<AdminTable> List3= FXCollections.observableArrayList();
	    
		Connection con;
		 public static int i;
		 public static int k;
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
		
		public void AddFlights(ActionEvent event) throws Exception  {
			Stage primaryStage =new Stage();
	                primaryStage.initStyle(StageStyle.UNDECORATED);
	                primaryStage.getIcons().add(new Image("/images/icon.png"));
	                Parent root =FXMLLoader.load(getClass().getResource("AddFlights.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
	                
	          
	            ((Node)(event.getSource())).getScene().getWindow().hide();
		}
		
		 @FXML
		    public void price(ActionEvent event) throws Exception  {
				Stage primaryStage =new Stage();
		                primaryStage.initStyle(StageStyle.UNDECORATED);
		                primaryStage.getIcons().add(new Image("/images/icon.png"));
		                Parent root =FXMLLoader.load(getClass().getResource("Price.fxml"));
				
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
		                
		           
		            ((Node)(event.getSource())).getScene().getWindow().hide();
			}
		 
	    public void UpdatePassword(ActionEvent event){
	        
	        try {
	            String oldpass=oldpasstxt.getText();
	            String newpass=newpasstxt.getText();
	            if(!(oldpass.isEmpty() || newpass.isEmpty())){
	                 if(admodel.check_if_pass_equal_to_old(oldpasstxt.getText())){
	                type=infoBox("Do you really want to change the password",null,"Alter!");
	                if(type){
	                	admodel.update_password(newpasstxt.getText());
	                    infoBox1("Password changed sucessfully", null,"Success");
	                    oldpasstxt.clear();
	                    newpasstxt.clear();
	                }
	            }else{
	                infoBox1("Please enter your old password correctly!!",null,"failed to change password");
	            }
	            }else{
	                infoBox1("please enter the password field", null,"Alert!");
	            }
	                
	                } catch (SQLException ex) {
	            Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         
	     }
		 
		 public static boolean infoBox(String infoMessage, String headerText, String title){
		        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		        alert.setContentText(infoMessage);
		        alert.setTitle(title);
		        alert.setHeaderText(headerText);
		        alert.getButtonTypes();
		        
		        Optional<ButtonType> result = alert.showAndWait();
		        if (result.get() == ButtonType.OK){
		           
		         return true;
		        } else {
		        
		        return false;
		        }
		        
		    }
		     
		
		 public AdminMenuController(){
		        con=SqlConnection.Connector();
		    }
		
		 
		 
		 
		 
		 public void tableConnection1() {
				
			 tablecart.getItems().clear();
			  
		        try {
		        	
		             
		            String query=" SELECT * FROM booking";
		            		
		            		
		            		
		            ResultSet rs =con.createStatement().executeQuery(query);
		            while(rs.next()){
		                obList1.add(new CartTable(rs.getInt("passport_no"), rs.getString("fname"),rs.getString("lname"),rs.getInt("flight_no"),rs.getString("source"),rs.getString("destination"),rs.getString("phone"),rs.getString("date"),rs.getString("category"),rs.getInt("classid")));
		                
		               }
		        	 
		        }
		         catch (SQLException ex) {
		            Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
		        }
	 	
	  }
		 
		 
		 
		 
		 
		 
		 public void tableConnection5() {
				
			 tableadmin.getItems().clear();
			  
		        try {
		        	
		             
		            String query="SELECT admin.admin_id,admin.first_name,admin.last_name,admin.email_id,admin.phone_no FROM admin ";
		            		
		            		
		            		
		            ResultSet rs =con.createStatement().executeQuery(query);
		            while(rs.next()){
		                List3.add(new AdminTable(rs.getInt("admin_id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email_id"),rs.getString("phone_no")));
		                
		               }
		        	 
		        }
		         catch (SQLException ex) {
		            Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
		        }
		
	 }
		 
		 
		 
		 
		 
		 
		 
		public void tableConnection2() {
			
			 tableprice.getItems().clear();
			  
		        try {
		        	
		             
		            String query=" SELECT * FROM price";
		            		
		            		
		            		
		            ResultSet rs =con.createStatement().executeQuery(query);
		            while(rs.next()){
		                obList2.add(new PriceTable(rs.getInt("classid"),rs.getString("class"),rs.getInt("adultprice"),rs.getInt("childprice")));
		                
		               }
		        	 
		        }
		         catch (SQLException ex) {
		            Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
		        }
		
	 }
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	        engine=webView.getEngine();
	    	  flight_no.setCellValueFactory(new PropertyValueFactory<>("flight_no"));
	          flight_model.setCellValueFactory(new PropertyValueFactory<>("flight_model"));
	          source.setCellValueFactory(new PropertyValueFactory<>("source"));
	          destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
	          departure_time.setCellValueFactory(new PropertyValueFactory<>("departure_time"));
	          arrival_time.setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
	             
	          capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
	          flight_date.setCellValueFactory(new PropertyValueFactory<>("flight_date"));
	          
	          tableConnection();
	          tableAdd.setItems(List);
	          tableAdd.refresh();
	          k= AdminLoginController.ad_id;
	          i= LoginController.cust_id;
	          pno.setCellValueFactory(new PropertyValueFactory<>("passport_no"));
	          fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
	          lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
	          cflight_no.setCellValueFactory(new PropertyValueFactory<>("flight_no"));
	          csource.setCellValueFactory(new PropertyValueFactory<>("source"));
	          cdestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
	          cphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
	        
	          date.setCellValueFactory(new PropertyValueFactory<>("date"));
	          cartcategory.setCellValueFactory(new PropertyValueFactory<>("category"));
	          cartclassid.setCellValueFactory(new PropertyValueFactory<>("classid"));
	          
	          tableConnection1();
	          tablecart.setItems(obList1);
	          tablecart.refresh();
	        
	          
	          
	          classid.setCellValueFactory(new PropertyValueFactory<>("classid"));
	          classes.setCellValueFactory(new PropertyValueFactory<>("classes"));
	          aprice.setCellValueFactory(new PropertyValueFactory<>("aprice"));
	          cprice.setCellValueFactory(new PropertyValueFactory<>("cprice"));
	          tableConnection2();
	          tableprice.setItems(obList2);
	          tableprice.refresh();
	          tableprice.getSelectionModel().clearSelection();
	          
	          
	          adminid.setCellValueFactory(new PropertyValueFactory<>("admin_id"));
	          adminfname.setCellValueFactory(new PropertyValueFactory<>("first_name"));
	          adminlname.setCellValueFactory(new PropertyValueFactory<>("last_name"));
	          emailadmin.setCellValueFactory(new PropertyValueFactory<>("email_id"));
	          phoneadmin.setCellValueFactory(new PropertyValueFactory<>("phone_no"));
	          tableConnection5();
	          tableadmin.setItems(List3);
	          tableadmin.refresh();
	          tableadmin.getSelectionModel().clearSelection();
	          
	          
	          
	          
	          
	          
	          
	    }
	    public void btn(ActionEvent event) {
	    	engine.load("https://www.radarbox24.com");
	    }

		private void tableConnection() {
			 tableAdd.getItems().clear();
		        try {
		             
		            String query="SELECT add_flights.flight_no,add_flights.flight_model ,add_flights.source,add_flights.destination,add_flights.departure_time,add_flights.arrival_time,add_flights.flight_date,add_flights.capacity FROM add_flights";
		            ResultSet rs =con.createStatement().executeQuery(query);
		            while(rs.next()){
		                List.add(new AdminMenuTable(rs.getInt("flight_no"), rs.getString("flight_model"),rs.getString("source"), rs.getString("destination"),rs.getString("departure_time"),rs.getString("arrival_time"),rs.getString("flight_date"),rs.getString("capacity")));
		                
		            }
		        } catch (SQLException ex) {
		            Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    }
			
@FXML

public void deleteItem(ActionEvent event){
	AdminMenuTable tableIndex = (AdminMenuTable)tableAdd.getSelectionModel().getSelectedItem();
   int tempMenuid = -1;
   try{
   tempMenuid = tableIndex.getFlight_no();
   }catch(Exception e){
       infoBox1("no item selected!", null, "Error");
       
   }

if(tempMenuid >= 0){
    String query = "DELETE FROM add_flights WHERE  ( flight_no = ? ) ";  
    PreparedStatement pst;
       try {              
           pst = con.prepareStatement(query);
           pst.setInt(1, tempMenuid);
          // pst.setInt(2, i);
           pst.execute();
           tableAdd.getItems().remove(tableIndex);
           tableAdd.refresh();
           tableAdd.getSelectionModel().clearSelection();
          
          
       } catch (SQLException ex) {
           Logger.getLogger(AdminMenuController.class.getName()).log(Level.SEVERE, null, ex);
       }
       catch(Exception e){
           infoBox1("no item selected!", null, "Error");
       }
           
   
} else {
    System.out.println("no selction made");
}
}

public static void infoBox1(String infoMessage, String headerText, String title){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(headerText);
    alert.setContentText(infoMessage);
    alert.showAndWait();
}
public  void Logout(ActionEvent event){
    System.exit(0);
}


	}
	

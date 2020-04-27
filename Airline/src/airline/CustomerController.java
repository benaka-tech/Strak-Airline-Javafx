
package airline;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerController implements Initializable {
    public CustomerModel custModel =new CustomerModel();
    @FXML
	private PasswordField oldpasstxt;
	@FXML
	private PasswordField newpasstxt;
	 @FXML
	    private TextField statetxt;

	    @FXML
	    private TextField citytxt;

	    @FXML
	    private TextField pincodetxt;
	    @FXML
	    private Label Total;
    @FXML
    private Label custLabel;
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
	private TableColumn<AdminMenuTable,String> childprice;
	@FXML
	private TableColumn<AdminMenuTable,String> adultprice;
	@FXML
	private JFXButton book;
	@FXML
	private TableColumn<AdminMenuTable,String> flight_date;
    
  
    @FXML
    private JFXTextField departure;

    @FXML
    private JFXTextField arrival;

    @FXML
    private JFXDatePicker searchdeparton;

    @FXML
    private TextArea landtxt;
    @FXML
	private JFXButton Search;
    @FXML
	private JFXButton Book;
   
    @FXML
    private Label totalAdultAmount;
    @FXML
    private Label totalChildAmount;
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
    private TableView<CancelTable> tablecancel;
	
	@FXML
	private TableColumn<CancelTable,Integer> passport_nobook;
	@FXML
	private TableColumn<CancelTable,String> fnamebook;
	@FXML
	private TableColumn<CancelTable,String> lnamebook;
	@FXML
	private TableColumn<CancelTable,Integer> flight_nobook;
	
	@FXML
	private TableColumn<CancelTable,String> srcbook;
	@FXML
	private TableColumn<CancelTable,String> destbook;
	@FXML
	private TableColumn<CancelTable,String> phonebook;
	@FXML
	private TableColumn<CancelTable,String> datebook;
	
	@FXML
	private TableColumn<CancelTable,Integer> custidbook;
	@FXML
	private TableColumn<CancelTable,String> categorybook;
	@FXML
	private TableColumn<CancelTable,Integer> classidbook;
	
	
	
    @FXML
    private JFXTextField passportdeletesearch;
    @FXML
   	private JFXButton Search1;
    Connection con;  
    
    public static int i;
    
    boolean type;
    
 
    ObservableList<AdminMenuTable> List1= FXCollections.observableArrayList();
    ObservableList<CartTable> obList1= FXCollections.observableArrayList();
    ObservableList<PriceTable> obList2= FXCollections.observableArrayList();
    
    ObservableList<CancelTable> obList3= FXCollections.observableArrayList();
    
    
    public CustomerController(){
        con=SqlConnection.Connector();
    }
    
   
    
    
   
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
	public void tableConnection(ActionEvent event) {
		
		 tableAdd.getItems().clear();
		  
	        try {
	        	
	             
	            String query=" SELECT add_flights.flight_no,add_flights.flight_model ,add_flights.source,add_flights.destination,add_flights.departure_time,add_flights.arrival_time,add_flights.flight_date,add_flights.capacity FROM add_flights WHERE add_flights.source='"+departure.getText()+"' AND add_flights.destination='"+arrival.getText()+"' AND add_flights.flight_date='"+searchdeparton.getValue()+"'";
	            ResultSet rs =con.createStatement().executeQuery(query);
	            while(rs.next()){
	                List1.add(new AdminMenuTable(rs.getInt("flight_no"), rs.getString("flight_model"),rs.getString("source"), rs.getString("destination"),rs.getString("departure_time"),rs.getString("arrival_time"),rs.getString("flight_date"),rs.getString("capacity")));
	                
	               }
	        	 
	        }
	         catch (SQLException ex) {
	            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
	        }
  	
   }
    
	   
	
	
	public void tableConnection3(ActionEvent event) {
		
		tablecancel.getItems().clear();
		  
	        try {
	        	
	             
	            String query=" SELECT booking.passport_no,booking.fname ,booking.lname,booking.flight_no,booking.source,booking.destination,booking.phone,booking.date,booking.customer_id,booking.category,booking.classid FROM booking WHERE booking.passport_no='"+passportdeletesearch.getText()+"'";
	            ResultSet rs =con.createStatement().executeQuery(query);
	            while(rs.next()){
	            	obList3.add(new CancelTable(rs.getInt("passport_no"), rs.getString("fname"),rs.getString("lname"), rs.getInt("flight_no"),rs.getString("source"),rs.getString("destination"),rs.getString("phone"),rs.getString("date"),rs.getInt("customer_id"),rs.getString("category"),rs.getInt("classid")));
	                
	               }
	        	 
	        }
	         catch (SQLException ex) {
	            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
	        }
 	
  }
	
	
	
	
	
	public void tableConnection1() {
		
		 tablecart.getItems().clear();
		  
	        try {
	        	
	             
	            String query=" SELECT * FROM booking where customer_id="+i+"";
	            		
	            		
	            		
	            ResultSet rs =con.createStatement().executeQuery(query);
	            while(rs.next()){
	                obList1.add(new CartTable(rs.getInt("passport_no"), rs.getString("fname"),rs.getString("lname"),rs.getInt("flight_no"),rs.getString("source"),rs.getString("destination"),rs.getString("phone"),rs.getString("date"),rs.getString("category"),rs.getInt("classid")));
	                
	               }
	        	 
	        }
	         catch (SQLException ex) {
	            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
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
	            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
	        }
	
 }
   
	
        
      
	public void book(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
                primaryStage.initStyle(StageStyle.UNDECORATED);
        		primaryStage.getIcons().add(new Image("/images/icon.png"));
		Parent root =FXMLLoader.load(getClass().getResource("Booking.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		((Node)(event.getSource())).getScene().getWindow().hide();
                
           
	}
   
    public void initialize(URL url, ResourceBundle rb) {
    	 i= LoginController.cust_id;
    	flight_no.setCellValueFactory(new PropertyValueFactory<>("flight_no"));
        flight_model.setCellValueFactory(new PropertyValueFactory<>("flight_model"));
        source.setCellValueFactory(new PropertyValueFactory<>("source"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        departure_time.setCellValueFactory(new PropertyValueFactory<>("departure_time"));
        arrival_time.setCellValueFactory(new PropertyValueFactory<>("arrival_time"));
        capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        
       
        flight_date.setCellValueFactory(new PropertyValueFactory<>("flight_date"));
       
        
        tableConnection(null);
        tableAdd.setItems(List1);
        tableAdd.refresh();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
  
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
        tablecart.getSelectionModel().clearSelection();
        calculateadult();
        calculatechild();
        calculate();
        
        classid.setCellValueFactory(new PropertyValueFactory<>("classid"));
        classes.setCellValueFactory(new PropertyValueFactory<>("classes"));
        aprice.setCellValueFactory(new PropertyValueFactory<>("aprice"));
        cprice.setCellValueFactory(new PropertyValueFactory<>("cprice"));
        tableConnection2();
        tableprice.setItems(obList2);
        tableprice.refresh();
        tableprice.getSelectionModel().clearSelection();
        
        
        
        
        
        
        
        
        
        
        passport_nobook.setCellValueFactory(new PropertyValueFactory<>("passport_no"));
        fnamebook.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lnamebook.setCellValueFactory(new PropertyValueFactory<>("lname"));
        flight_nobook.setCellValueFactory(new PropertyValueFactory<>("flight_no"));
        srcbook.setCellValueFactory(new PropertyValueFactory<>("source"));
        destbook.setCellValueFactory(new PropertyValueFactory<>("destination"));
        phonebook.setCellValueFactory(new PropertyValueFactory<>("phone"));
        
       
        datebook.setCellValueFactory(new PropertyValueFactory<>("date"));
        custidbook.setCellValueFactory(new PropertyValueFactory<>("customer_id"));
        categorybook.setCellValueFactory(new PropertyValueFactory<>("category"));
        classidbook.setCellValueFactory(new PropertyValueFactory<>("classid"));
        
        
        tableConnection(null);
        tablecancel.setItems(obList3);
        tablecancel.refresh();
        
        
        
        
        
        
        
        
        
        }

    public void calculateadult(){
        try {
            
            String query="SELECT sum(p.adultprice) AS adult_amount FROM booking b ,price p WHERE b.classid=p.classid and b.category='Adult' AND b.customer_id='"+i+"';";
            ResultSet rs =con.createStatement().executeQuery(query);
            while(rs.next()){
             
                int totalamount=rs.getInt("adult_amount");
                
                totalAdultAmount.setText(Integer.toString(totalamount));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calculatechild(){
        try {
            
            String query="SELECT sum(p.childprice) AS child_amount FROM booking b ,price p WHERE b.classid=p.classid and b.category='Child' AND b.customer_id='"+i+"'";
            		  
            ResultSet rs =con.createStatement().executeQuery(query);
            while(rs.next()){
             
                int totalamount=rs.getInt("child_amount");
                
                totalChildAmount.setText(Integer.toString(totalamount));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
  //cart
    
    
    @FXML
    public void PaymentScreen(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
               primaryStage.initStyle(StageStyle.UNDECORATED);
       		primaryStage.getIcons().add(new Image("/images/icon.png"));
		Parent root =FXMLLoader.load(getClass().getResource("Payment.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
               
          
           ((Node)(event.getSource())).getScene().getWindow().hide();
	}
        
         

    
    
    
    
    
    
    
    
    
    @FXML

    public void deleteItem(ActionEvent event){
    	CancelTable tableIndex = (CancelTable)tablecancel.getSelectionModel().getSelectedItem();
       int tempMenuid = -1;
       try{
       tempMenuid = tableIndex. getPassport_no();
       }catch(Exception e){
           infoBox1("no item selected!", null, "Error");
           
       }

    if(tempMenuid >= 0){
        String query = "DELETE FROM booking WHERE  ( passport_no = ? ) ";  
        PreparedStatement pst;
           try {              
               pst = con.prepareStatement(query);
               pst.setInt(1, tempMenuid);
             
               pst.execute();
               tablecancel.getItems().remove(tableIndex);
               tablecancel.refresh();
               tablecancel.getSelectionModel().clearSelection();
              
              
           } catch (SQLException ex) {
               Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
           }
           catch(Exception e){
               infoBox1("no item selected!", null, "Error");
           }
               
       
    } else {
        System.out.println("no selction made");
    }
    }

    public void putAddress(ActionEvent event){
        if(!(statetxt.getText().isEmpty()||citytxt.getText().isEmpty()||landtxt.getText().isEmpty()||pincodetxt.getText().isEmpty())){
            type=infoBox("do you really want to update the Address",null,"Alert!");
            if(type){
                    
        String query="Update customer SET state=? ,city=? ,landmark=? ,pincode=? where customer_id="+i;
        PreparedStatement pst;
        try {
            pst =con.prepareStatement(query);
            pst.setString(1,statetxt.getText());
            pst.setString(2,citytxt.getText());
            pst.setString(3,landtxt.getText());
            pst.setInt(4,Integer.parseInt(pincodetxt.getText()));
            pst.execute();
            statetxt.clear();
            citytxt.clear();
            landtxt.clear();
            pincodetxt.clear();
            getAddress();
            infoBox1("Address Sucessfully updated",null,"success");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
            }else{
                infoBox1("update cancelled",null,"cancelled");
                statetxt.clear();
                citytxt.clear();
                landtxt.clear();
                pincodetxt.clear();
                getAddress();
            }
    }else{
            infoBox1("please fill the address fields", null,"Update failed");
        }
    }
   
    public void getAddress(){
        String query="SELECT state, city, landmark, pincode FROM  customer where customer_id="+i;
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst =con.prepareStatement(query);
            rs=pst.executeQuery();
            if(rs.next()){
                statetxt.setText(rs.getString("state"));
                citytxt.setText(rs.getString("city"));
                landtxt.setText(rs.getString("landmark"));
                int pincode=rs.getInt("pincode");
                pincodetxt.setText(Integer.toString(pincode));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    public void UpdatePassword(ActionEvent event){
        
        try {
            String oldpass=oldpasstxt.getText();
            String newpass=newpasstxt.getText();
            if(!(oldpass.isEmpty() || newpass.isEmpty())){
                 if(custModel.check_if_pass_equal_to_old(oldpasstxt.getText())){
                type=infoBox("Do you really want to change the password",null,"Alter!");
                if(type){
                	custModel.update_password(newpasstxt.getText());
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
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
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

package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMenuModel {
	 Connection connection;
	    public AdminMenuModel(){
	        connection =SqlConnection.Connector();
	        if(connection==null){
	            System.exit(0);
	            System.out.println("notconnected");
}

	    }
 public boolean isDbConnected(){
     try {
         return !connection.isClosed();
     } catch (SQLException ex) {
         System.out.println("error");
         Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
         System.out.println("error");
         return false;
         
     }
     
 }
 
	
	 public boolean check_if_pass_equal_to_old(String oldpass) throws SQLException{
	        PreparedStatement preparedStatement = null ;
	        ResultSet resultSet =null;
	       String query="select * from admin where admin_id=? and password=?";
	          try {
	           preparedStatement =connection.prepareStatement(query);
	           preparedStatement.setInt(1, AdminMenuController.k);
	           preparedStatement.setString(2, oldpass);
	           resultSet=preparedStatement.executeQuery();
	           if(resultSet.next()){
	            return true;  
	            }else{
	                 return false;
	               }
	               
	           
	       } catch (SQLException ex) {
	           
	           System.out.println(""+ex);
	           return false;
	       }finally{
	           preparedStatement.close();
	           resultSet.close();
	       }
	       
	   }
	   public void update_password(String newpass){
	        PreparedStatement preparedStatement ;
	        String query="update admin SET password =? where admin_id=?";
	        
	       try {
	           preparedStatement =connection.prepareStatement(query);
	           preparedStatement.setString(1, newpass);
	           preparedStatement.setInt(2, AdminMenuController.k);
	           preparedStatement.execute();
	       } catch (SQLException ex) {
	           Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
	       }
	          
	   }
}

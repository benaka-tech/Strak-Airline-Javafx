package airline;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerModel {
	 Connection connection;
	    public CustomerModel(){
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
       String query="select * from customer where customer_id=? and password=?";
          try {
           preparedStatement =connection.prepareStatement(query);
           preparedStatement.setInt(1, CustomerController.i);
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
        String query="update customer SET password =? where customer_id=?";
        
       try {
           preparedStatement =connection.prepareStatement(query);
           preparedStatement.setString(1, newpass);
           preparedStatement.setInt(2, CustomerController.i);
           preparedStatement.execute();
       } catch (SQLException ex) {
           Logger.getLogger(CustomerModel.class.getName()).log(Level.SEVERE, null, ex);
       }
          
   }
    
    
}
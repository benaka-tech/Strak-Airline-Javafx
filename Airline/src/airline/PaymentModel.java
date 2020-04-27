package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentModel {
  Connection connection;
    public PaymentModel(){
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
            Logger.getLogger(SignupModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            return false;
            
        }
        
    } 
    public void paying(String cardnumber,String cardholdername,String cvv,String month,String year) throws SQLException{
        PreparedStatement preparedStatement =null;
        
        String query="INSERT INTO payment_details(customer_id,card_number,card_holder_name,cvv,exp_month,exp_year) VALUES(?,?,?,?,?,?)";
        try {
        	preparedStatement =connection.prepareStatement(query);
            preparedStatement.setInt(1, CustomerController.i);
            preparedStatement.setString(2,cardnumber);
            preparedStatement.setString(3, cardholdername);
            preparedStatement.setString(4, cvv);
            preparedStatement.setString(5,month);
            preparedStatement.setString(6,year);
            preparedStatement.execute();
      } catch (SQLException ex) {
          Logger.getLogger(SignupModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          connection.close();
      }
        

        
   
    }
}

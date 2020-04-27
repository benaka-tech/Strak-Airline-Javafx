package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXRadioButton;

public class PriceModel {
  Connection connection;
    public  PriceModel(){
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
            Logger.getLogger(AdminAddFlights.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            return false;
            
        }
        
    } 
    public void saving(String radioButtonLabel,String adp,String cdp) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="update price SET adultprice =? , childprice = ? where class='"+radioButtonLabel+"'";
      try {
          preparedStatement=connection.prepareStatement(query);
        
       
          
          preparedStatement.setString(1,adp);
          preparedStatement.setString(2,cdp);
          preparedStatement.executeUpdate();
          
          
       
          
          
      } catch (SQLException ex) {
          Logger.getLogger(PriceModel.class.getName()).log(Level.SEVERE, null, ex);
      }
        

        
    }
    
  
}

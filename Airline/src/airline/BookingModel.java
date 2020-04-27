package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXRadioButton;


public class BookingModel {
  Connection connection;
    public  BookingModel(){
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
    public void book(String pno,String fn,String ln,String fno,String src,String dest,String phon,String date,String category, String classid) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="insert into booking (passport_no,fname,lname,flight_no,source,destination,phone,date,customer_id, category,classid)"+"value(?,?,?,?,?,?,?,?,?,?,?)";
      try {
          preparedStatement=connection.prepareStatement(query);
          preparedStatement.setString(1,pno);
          preparedStatement.setString(2,fn);
          preparedStatement.setString(3,ln);
          preparedStatement.setString(4,fno);
          preparedStatement.setString(5,src);
          preparedStatement.setString(6, dest);
          preparedStatement.setString(7, phon);
          preparedStatement.setString(8, date);
          preparedStatement.setInt(9, CustomerController.i);
         preparedStatement.setString(10, category);
         preparedStatement.setString(11, classid);
          
          
          preparedStatement.executeUpdate();
      } catch (SQLException ex) {
          Logger.getLogger(AdminAddFlights.class.getName()).log(Level.SEVERE, null, ex);
      }

        
    }
    
    
    
}

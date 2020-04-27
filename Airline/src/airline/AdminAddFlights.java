package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXRadioButton;


public class  AdminAddFlights {
  Connection connection;
    public  AdminAddFlights(){
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
    public void AddFlights(String fno,String model,String src,String dest,String dtime,String atime,String date,String radioButtonLabel1,String radioButtonLabel2,String radioButtonLabel3,String cap) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="insert into add_flights(flight_no,flight_model,source,destination,departure_time,arrival_time,flight_date,mcheck,ercheck,wcheck,capacity)"+"value(?,?,?,?,?,?,?,?,?,?,?)";
      try {
          preparedStatement=connection.prepareStatement(query);
          preparedStatement.setString(1,fno);
          preparedStatement.setString(2,model);
          preparedStatement.setString(3,src);
          preparedStatement.setString(4,dest);
          preparedStatement.setString(5,dtime);
          preparedStatement.setString(6, atime); 
          preparedStatement.setString(7, date);
          preparedStatement.setString(8, radioButtonLabel1);
          preparedStatement.setString(9, radioButtonLabel2);
          preparedStatement.setString(10,radioButtonLabel3 );
         
          preparedStatement.setString(11, cap);
          preparedStatement.executeUpdate();
      } catch (SQLException ex) {
          Logger.getLogger(AdminAddFlights.class.getName()).log(Level.SEVERE, null, ex);
      }
        

        
    }
    
    
  
}

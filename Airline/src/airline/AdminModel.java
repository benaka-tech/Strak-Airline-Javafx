package airline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AdminModel {
    static int admin_id;
    static String first_name;
    Connection connection;
    public AdminModel(){
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
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            return false;
            
        }
        
    } 
    public boolean AdminLogin(String email ,String pass) throws SQLException{
        //int customer_id;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet =null;
        String query="select admin_id,first_name from admin where email_id=? and password=?";
        try{
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                admin_id =resultSet.getInt("admin_id");
                System.out.println(""+admin_id);
                AdminLoginController.AdminId(admin_id);
                
                first_name =resultSet.getString("first_name");
                System.out.println(""+first_name);
               AdminLoginController.Name(first_name);
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(" no!"+e);
            return false;
        }finally{
            preparedStatement.close();
            resultSet.close();
        }
        
        
        
    }
    
   
    
    
}

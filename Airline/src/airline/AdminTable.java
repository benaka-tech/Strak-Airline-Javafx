
package airline;

import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class AdminTable {
private final SimpleIntegerProperty admin_id;
private final SimpleStringProperty first_name; 
private final  SimpleStringProperty last_name;
private final SimpleStringProperty email_id;
private final SimpleStringProperty phone_no;



public AdminTable(Integer adminid, String first_name, String last_name, String emailadmin,String adminphone) {
	super();
	this.admin_id = new SimpleIntegerProperty(adminid);
	this.first_name = new SimpleStringProperty(first_name);
	this.last_name = new SimpleStringProperty(last_name);
	this.email_id = new SimpleStringProperty(emailadmin);
	this.phone_no = new SimpleStringProperty(adminphone);

}


public Integer getAdmin_id() {
	return admin_id.get();
}


public String getFirst_name() {
	return first_name.get();
}


public String getLast_name() {
	return last_name.get();
}


public String getEmail_id() {
	return email_id.get();
}


public String getPhone_no() {
	return phone_no.get();
}




}

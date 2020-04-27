package airline;

import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class CartTable {
private final SimpleIntegerProperty passport_no;
private final SimpleStringProperty fname; 
private final SimpleStringProperty lname;
private final SimpleIntegerProperty flight_no;
private final SimpleStringProperty source;
private final SimpleStringProperty destination;
private final SimpleStringProperty phone;
private final SimpleStringProperty date;
private final SimpleStringProperty category;
private final SimpleIntegerProperty classid;



public CartTable(Integer pno, String fname, String lname, Integer flight_no, String source,
		String destination,String phone,String date,String category,Integer classid) {
	super();
	this.passport_no = new SimpleIntegerProperty(pno);
	this.fname = new SimpleStringProperty(fname);
	this.lname = new SimpleStringProperty(lname);
	this.flight_no = new SimpleIntegerProperty(flight_no);
	this.source = new SimpleStringProperty(source);
	this.destination =new SimpleStringProperty( destination);
	this.phone = new SimpleStringProperty( phone);
	this.date = new SimpleStringProperty(date);
	this.category = new SimpleStringProperty(category);
	this.classid = new SimpleIntegerProperty(classid);
	

}

public Integer getPassport_no() {
	return passport_no.get();
}

public String getFname() {
	return fname.get();
}

public String getLname() {
	return lname.get();
}

public Integer getFlight_no() {
	return flight_no.get();
}

public String getSource() {
	return source.get();
}

public String getDestination() {
	return destination.get();
}

public String getPhone() {
	return phone.get();
}

public String getDate() {
	return date.get();
}



public String getCategory() {
	return category.get();
}

public Integer getClassid() {
	return classid.get();
}

}

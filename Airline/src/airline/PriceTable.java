
package airline;

import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class PriceTable {
private final SimpleIntegerProperty classid;
private final SimpleStringProperty classes; 
private final  SimpleIntegerProperty aprice;
private final SimpleIntegerProperty cprice;



public PriceTable(Integer classid, String classes, Integer adultprice, Integer childprice) {
	super();
	this.classid = new SimpleIntegerProperty(classid);
	this.classes = new SimpleStringProperty(classes);
	this.aprice = new SimpleIntegerProperty(adultprice);
	this.cprice = new SimpleIntegerProperty(childprice);
	

}



public String getClasses() {
	return classes.get();
}



public Integer getAprice() {
	return aprice.get();
}



public Integer getCprice() {
	return cprice.get();
}



public Integer getClassid() {
	return classid.get();
}







}

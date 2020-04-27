package airline;

import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class AdminMenuTable {
private final SimpleIntegerProperty flight_no;
private final SimpleStringProperty flight_model; 
private final SimpleStringProperty source;
private final SimpleStringProperty destination;
private final SimpleStringProperty departure_time;
private final SimpleStringProperty arrival_time;
private final SimpleStringProperty capacity;

private final SimpleStringProperty flight_date;


public AdminMenuTable(Integer flight_no, String flight_model, String source, String destination, String departure_time,
		String arrival_time,String flight_date, String capacity) {
	super();
	this.flight_no = new SimpleIntegerProperty(flight_no);
	this.flight_model = new SimpleStringProperty(flight_model);
	this.source = new SimpleStringProperty(source);
	this.destination = new SimpleStringProperty(destination);
	this.departure_time = new SimpleStringProperty(departure_time);
	this.arrival_time =new SimpleStringProperty( arrival_time);
	this.flight_date = new SimpleStringProperty( flight_date);
	
	this.capacity = new SimpleStringProperty(capacity);
}   
public Integer getFlight_no() {
	return flight_no.get();
}
public String getFlight_model() {
	return flight_model.get();
}
public String getSource() {
	return source.get();
}
public String getDestination() {
	return destination.get();
}
public String getDeparture_time() {
	return departure_time.get();
}
public String getArrival_time() {
	return arrival_time.get();
	
}
public String getCapacity() {
	return capacity.get();
}
public String getFlight_date() {
	return flight_date.get();
}




}

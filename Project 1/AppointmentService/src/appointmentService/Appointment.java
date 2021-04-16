package appointmentService;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Appointment {
	private
	String id;
	String description;
	Date appointmentDate;
	
	// maximum String lengths
	static final int MAX_ID_LENGTH = 10;
	static final int MAX_DESCRIPTION_LENGTH = 50;
	
	// appointment constructor, requires appointment's id, description, and date 
	// before creating the appointment.
	public Appointment(String id, String description, String appointmentDate) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date tempDate = dateFormat.parse(appointmentDate);
		
		if(id == null || id.length() > MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
			throw new IllegalArgumentException("Invalid Description");
		}
		if(appointmentDate == null) {
			throw new NullPointerException("Invalid Appointment Date");
		}
		if(tempDate.before(new Date()) == true) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		// if all checks are passed, appointment objects can be initialized 
		this.id = id;
		this.description = description;
		this.appointmentDate = tempDate;
	}
	
	// get methods 
	public String getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getDate() {
		return appointmentDate;
	}

}

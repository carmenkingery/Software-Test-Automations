package appointmentService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class AppointmentService {
	// list of appointments
		public List<Appointment> appointments;
		
		// maximum length of ID String
		static final int MAX_ID_LENGTH = 10;
		
		public AppointmentService() {
			appointments = new ArrayList<Appointment>();
		}

		// add new appointment, checking for a valid and unique ID prior to adding to the list
		public void addAppointment(String id, String description, String appointmentDate) throws ParseException {
			Appointment appointment = null;
			if(id == null || id.length() > MAX_ID_LENGTH) {
				throw new IllegalArgumentException("Invalid ID");
			}
			
			// checking for existing appointment with same ID
			for(int i=0; i<appointments.size(); i++) {
				if(appointments.get(i).getId() == id) {
					appointment = appointments.get(i);
				}
			}
			
			// else add new appointment to list
			if(appointment == null) {
				appointment = new Appointment(id, description, appointmentDate);
				appointments.add(appointment);
			}
		}
		
		// delete appointment per ID, checking for valid ID first
		public void deleteAppointment(String id) {
			if(id == null || id.length() > MAX_ID_LENGTH) {
				throw new IllegalArgumentException("Invalid ID");
			}
			
			for(int i=0; i<appointments.size(); i++) {
				if(appointments.get(i).getId() == id) {
					appointments.remove(i);
				}
			}
		}
}

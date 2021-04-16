package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import appointmentService.Appointment;

class AppointmentTest {
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	@Test
	void testAppointment() throws ParseException {
		Appointment appointment = new Appointment("2021", "scheduling appointment", "11/03/2021");
		Date testDate = dateFormat.parse("11/03/2021");
	// test get ID
		assertTrue(appointment.getId().equals("2021"));
	// test get Description
		assertTrue(appointment.getDescription().equals("scheduling appointment"));
	// test get appointment Date
		assertTrue(appointment.getDate().compareTo(testDate) == 0);
	}
	
	@Test
	void testInvalidStrings() throws ParseException {
		Exception exception;
	// ID too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("12345678912", "scheduling appointment", "11/03/2021");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, "scheduling appointment", "11/03/2021");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// Description too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("2021", "scheduling appointment scheduling appointment sched", "11/03/2021");
		});
		assertTrue(exception.getMessage().contains("Invalid Description"));
	//  Description is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("2021", null, "11/03/2021");
		});
		assertTrue(exception.getMessage().contains("Invalid Description"));
	// Appointment Date is in the past
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("2021", "scheduling appointment", "11/03/1980");
		});
		assertTrue(exception.getMessage().contains("Invalid Appointment Date"));
	// Appointment Date is null
		exception = assertThrows(NullPointerException.class, () ->{
			new Appointment("2021", "scheduling appointment", null);
		});
		assertTrue(exception instanceof NullPointerException);
	}
}

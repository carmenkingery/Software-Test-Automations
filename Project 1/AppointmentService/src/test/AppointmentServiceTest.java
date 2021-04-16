package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

import appointmentService.AppointmentService;

class AppointmentServiceTest {

	@Test
	void testAddAppointment() throws ParseException {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment("2021", "planning appointment", "11/03/2021");
		assertEquals(appointmentService.appointments.get(0).getId(), "2021");
	}
	
	@Test
	void testDeleteAppointment() throws ParseException {
		AppointmentService appointmentService = new AppointmentService();
		appointmentService.addAppointment("2021", "planning appointment", "11/03/2021");
		appointmentService.deleteAppointment("2021");
		assertTrue(appointmentService.appointments.isEmpty());
	}
	
	@Test
	void testInvalidID() {
		AppointmentService appointmentService = new AppointmentService();
		Exception exception;
	// ID too long for addAppointment
		exception = assertThrows(IllegalArgumentException.class, () ->{
			appointmentService.addAppointment("12345678912", "scheduling appointment", "11/03/2021");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for addAppointment
		exception = assertThrows(IllegalArgumentException.class, () ->{
			appointmentService.addAppointment(null, "scheduling appointment", "11/03/2021");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for deleteAppointment
		exception = assertThrows(IllegalArgumentException.class, () ->{
			appointmentService.addAppointment("2021", "planning appointment", "11/03/2021");
			appointmentService.deleteAppointment("12345678912");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for deleteAppointment
		exception = assertThrows(IllegalArgumentException.class, () ->{
			appointmentService.addAppointment("2021", "planning appointment", "11/03/2021");
			appointmentService.deleteAppointment(null);
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	}

}

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contactService.ContactService;

class ContactServiceTest {

	Exception exception;
	
	@Test
	void testAddContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		assertEquals(contactService.contacts.get(0).getId(), "2015");
	}

	@Test
	void testDeleteContact() {
		ContactService contactService = new ContactService();
		contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		contactService.deleteContact("2015");
		assertTrue(contactService.contacts.isEmpty());
	}

	@Test
	void testUpdateFirstName() {
		ContactService contactService = new ContactService();
		contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		contactService.updateFirstName("2015", "Nathan");
		assertEquals(contactService.contacts.get(0).getFirstName(), "Nathan");
	}

	@Test
	void testUpdateLastName() {
		ContactService contactService = new ContactService();
		contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		contactService.updateLastName("2015", "Swanson");
		assertEquals(contactService.contacts.get(0).getLastName(), "Swanson");
	}

	@Test
	void testUpdatePhoneNum() {
		ContactService contactService = new ContactService();
		contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		contactService.updatePhoneNum("2015", "9876543219");
		assertEquals(contactService.contacts.get(0).getPhoneNum(), "9876543219");
	}

	@Test
	void testUpdateAddress() {
		ContactService contactService = new ContactService();
		contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		contactService.updateAddress("2015", "4321 Grand Ave");
		assertEquals(contactService.contacts.get(0).getAddress(), "4321 Grand Ave");
	}
	
	@Test
	void testInvalidID() {
		ContactService contactService = new ContactService();
		Exception exception;
	// ID too long for addContact
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("20152020199","Carmen", "Kingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for addContact
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact(null,"Carmen", "Kingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for deleteContact
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.deleteContact("20152020199");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for deleteContact
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.deleteContact(null);
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for updateFirstName
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updateFirstName("20152020199", "Nathan");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for updateFirstName
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updateFirstName(null, "Nathan");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for updateLastName
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updateLastName("20152020199", "Swanson");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for updateLastName
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updateLastName(null, "Swanson");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for updatePhoneNum
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updatePhoneNum("20152020199", "9876543219");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null updatePhoneNum
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updatePhoneNum("20152020199", "9876543219");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for updateAddress
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updateAddress("20152020199", "4321 Grand Ave");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for updateAddress
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contactService.addContact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
			contactService.updateAddress(null, "4321 Grand Ave");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
		
	}

}

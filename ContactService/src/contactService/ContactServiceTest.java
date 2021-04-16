package contactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
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

}

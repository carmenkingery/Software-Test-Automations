package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
	// test get ID
		assertTrue(contact.getId().equals("2015"));
	// test get First Name
		assertTrue(contact.getFirstName().equals("Carmen"));
	// test get Last Name
		assertTrue(contact.getLastName().equals("Kingery"));
	// test get Phone number
		assertTrue(contact.getPhoneNum().equals("1234567891"));
	// test get Address
		assertTrue(contact.getAddress().equals("1234 Main St"));
	}
	
	@Test
	void testSetContact() {
		Contact contact = new Contact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
	// test set First Name
		contact.setFirstName("Nathan");
		assertTrue(contact.getFirstName().equals("Nathan"));
	// test set Last Name
		contact.setLastName("Swanson");
		assertTrue(contact.getLastName().equals("Swanson"));
	// test set Phone number
		contact.setPhoneNum("9876543219");
		assertTrue(contact.getPhoneNum().equals("9876543219"));
	// test set Address
		contact.setAddress("4321 Grand Ave");
		assertTrue(contact.getAddress().equals("4321 Grand Ave"));
	}
	
	@Test
	void testInvalidSetContact() {
		Contact contact = new Contact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St");
		Exception exception;
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName("Carmenkingery");
		});
		assertTrue(exception.getMessage().contains("Invalid First Name"));
	// Last Name too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName("carmenKingery");
		});
		assertTrue(exception.getMessage().contains("Invalid Last Name"));
	// Phone Number too long
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setPhoneNum("12345678912");
		});
		assertTrue(exception.getMessage().contains("Invalid Phone Number"));
	// Phone Number too short
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setPhoneNum("123456789");
		});	
		assertTrue(exception.getMessage().contains("Invalid Phone Number"));
	// Address too long
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setAddress("1234 Main St, 1234 Main st, 123");
		});
		assertTrue(exception.getMessage().contains("Invalid Address"));
	// First Name is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setFirstName(null);
		});
		assertTrue(exception.getMessage().contains("Invalid First Name"));
	// Last Name is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setLastName(null);
		});
		assertTrue(exception.getMessage().contains("Invalid Last Name"));
	// Phone Number is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setPhoneNum(null);
		});
		assertTrue(exception.getMessage().contains("Invalid Phone Number"));
	// Address is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			contact.setAddress(null);
		});
		assertTrue(exception.getMessage().contains("Invalid Address"));
	}
	
	@Test
	void testInvalidConstructorCombinations() {
		Exception exception;
	// ID too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Contact("20152020199","Carmen", "Kingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// First Name too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Contact("2015", "Carmenkingery", "Kingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid First Name"));
	// Last Name too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Contact("2015", "Carmen", "carmenKingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid Last Name"));
	// Phone Number too long
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", "Carmen", "Kingery", "123456789112", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid Phone Number"));
	// Phone Number too short
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", "Carmen", "Kingery", "12345678", "1234 Main St");
		});	
		assertTrue(exception.getMessage().contains("Invalid Phone Number"));
	// Address too long
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", "Carmen", "Kingery", "1234567891", "1234 Main St, 1234 Main st, 1234");
		});
		assertTrue(exception.getMessage().contains("Invalid Address"));
	// ID is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact(null, "Carmen", "Kingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// First Name is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", null, "Kingery", "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid First Name"));
	// Last Name is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", "Carmen", null, "1234567891", "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid Last Name"));
	// Phone Number is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", "Carmen", "Kingery", null, "1234 Main St");
		});
		assertTrue(exception.getMessage().contains("Invalid Phone Number"));
	// Address is null
		exception = assertThrows(IllegalArgumentException.class, () ->{	
			new Contact("2015", "Carmen", "Kingery", "1234567891", null);
		});
		assertTrue(exception.getMessage().contains("Invalid Address"));
	}
}

package contactService;
import java.util.ArrayList;
import java.util.List;


public class ContactService {
	
	// list of active contacts
	public List<Contact> contacts;
	
	// Maximum length of ID string
	static final int MAX_LENGTH = 10;
	
	public ContactService() {
		contacts = new ArrayList<Contact>();
	}
	
	// add a new contact
	public Contact addContact(String id, String firstName, String lastName, String phoneNum, String address) {
		Contact contact = null;
		if(id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		// check if a contact already exists with that ID
		// if existing contact found, return contact
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contact = contacts.get(i);
			}
		}
		
		// else add new contact to list and return new contact
		if(contact == null) {
			contact = new Contact(id, firstName, lastName, phoneNum, address);
			contacts.add(contact);
		}
		
		return contact;
	}
	
	// delete an existing contact
	public void deleteContact(String id) {
		if(id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.remove(i);
			}
		}
		return;
	}
	
	// update contact's first name
	public void updateFirstName(String id, String firstName) {
		if(id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setFirstName(firstName);
			}
		}
		return;
	}
	
	// update contact's last name
	public void updateLastName(String id, String lastName) {
		if(id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setLastName(lastName);
			}
		}
		return;
	}
	
	// update contact's phone number
	public void updatePhoneNum(String id, String phoneNum) {
		if(id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setPhoneNum(phoneNum);
			}
		}
		return;	
	}
	
	// update contact's address
	public void updateAddress(String id, String address) {
		if(id == null || id.length() > MAX_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<contacts.size(); i++) {
			if(contacts.get(i).getId() == id) {
				contacts.get(i).setAddress(address);
			}
		}
		return;	
	}
}

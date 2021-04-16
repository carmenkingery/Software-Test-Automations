package contactService;

public class Contact {
	
		private
			String id;
			String firstName;
			String lastName;
			String phoneNum;
			String address;
		
		// maximum length of strings
		static final int MAX_LENGTH = 10;
		static final int MAX_ADDRESS_LENGTH = 30;
		
		// Contact constructor so that empty contacts cannot be created
		public Contact(String id, String firstName, String lastName, String phoneNum, String address) {
			if(id == null || id.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid ID");
			}
			if(firstName == null || firstName.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid First Name");
			}
			if(lastName == null || lastName.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			if(phoneNum == null || phoneNum.length() > MAX_LENGTH || phoneNum.length() < MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid Phone Number");
			}
			if(address == null || address.length() > MAX_ADDRESS_LENGTH) {
				throw new IllegalArgumentException("Invalid Address");
			}
			
			this.id = id;
			this.firstName = firstName; 
			this.lastName = lastName;
			this.phoneNum = phoneNum;
			this.address = address;
		}
		
		// getter methods 
		public String getId() {
			return id;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getPhoneNum() {
			return phoneNum;
		}
		
		public String getAddress() {
			return address;
		}
		
		// setter methods
		public void setFirstName(String firstName) {
			if(firstName == null || firstName.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid First Name");
			}
			this.firstName = firstName;
		}
		
		public void setLastName(String lastName) {
			if(lastName == null || lastName.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			this.lastName = lastName;
		}
		
		public void setPhoneNum(String phoneNum) {
			if(phoneNum == null || phoneNum.length() > MAX_LENGTH) {
				throw new IllegalArgumentException("Invalid Phone Number");
			}
			this.phoneNum = phoneNum;
		}
		
		public void setAddress(String address) {
			if(address == null || address.length() > MAX_ADDRESS_LENGTH) {
				throw new IllegalArgumentException("Invalid Address");
			}
			this.address = address;
		}
		
	
}

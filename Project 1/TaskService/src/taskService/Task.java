package taskService;

public class Task {
	
	private
		String id;
		String name;
		String descrip;
		
		// maximum String lengths
		static final int MAX_ID_LENGTH = 10;
		static final int MAX_NAME_LENGTH = 20;
		static final int MAX_DESCRIP_LENGTH = 50;
		
		// constructor requiring all fields to be filled prior to task creation
		public Task(String id, String name, String descrip) {
			if(id == null || id.length() > MAX_ID_LENGTH) {
				throw new IllegalArgumentException("Invalid ID");
			}
			if(name == null || name.length() > MAX_NAME_LENGTH) {
				throw new IllegalArgumentException("Invalid Name");
			}
			if(descrip == null || descrip.length() > MAX_DESCRIP_LENGTH) {
				throw new IllegalArgumentException("Invalid Description");
			}
			
			this.id = id;
			this.name = name;
			this.descrip = descrip;
		}
		
		// get methods
		public String getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public String getDescrip() {
			return descrip;
		}
		
		// set methods
		public void setName(String name) {
			if(name == null || name.length() > MAX_NAME_LENGTH) {
				throw new IllegalArgumentException("Invalid Name");
			}
			this.name = name;
		}
		
		public void setDescrip(String descrip) {
			if(descrip == null || descrip.length() > MAX_DESCRIP_LENGTH) {
				throw new IllegalArgumentException("Invalid Description");
			}
			this.descrip = descrip;
		}

}

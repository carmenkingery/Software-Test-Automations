package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import taskService.Task;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("2021", "Install", "Installs new game");
	// test get ID
		assertTrue(task.getId().equals("2021"));
	// test get Name
		assertTrue(task.getName().equals("Install"));
	// test get Description
		assertTrue(task.getDescrip().equals("Installs new game"));
	}
	
	@Test
	void testSetTask() {
		Task task = new Task("2021", "Install", "Installs new game");
	// test set Name
		task.setName("Download");
		assertTrue(task.getName().equals("Download"));
	// test set Description
		task.setDescrip("Downloads new game");
		assertTrue(task.getDescrip().equals("Downloads new game"));
	}
	
	@Test
	void testInvalidSetTask() {
		Task task = new Task("2021", "Install", "Installs new game");
		Exception exception;
	// Name too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			task.setName("Install89012345678901");
		});
		assertTrue(exception.getMessage().contains("Invalid Name"));
	// Name is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			task.setName(null);
		});
		assertTrue(exception.getMessage().contains("Invalid Name"));
	// Description too long 
		exception = assertThrows(IllegalArgumentException.class, () ->{
			task.setDescrip("Installs new game8901234567890123456789012345678901");
		});
		assertTrue(exception.getMessage().contains("Invalid Description"));
	// Description is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			task.setDescrip(null);
		});
		assertTrue(exception.getMessage().contains("Invalid Description"));
	}
	
	@Test
	void testInvalidStrings() {
		Exception exception;
	// ID too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Task("12345678912", "Install", "Installs new game");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Task(null, "Install", "Installs new game");			
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// Name too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Task("1234567891","Install89012345678901", "Installs new game");
		});
		assertTrue(exception.getMessage().contains("Invalid Name"));
	// Name is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Task("1234567891", null, "Installs new game");
		});
		assertTrue(exception.getMessage().contains("Invalid Name"));
	// Description too long
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Task("1234567891","Install", "Installs new game8901234567890123456789012345678901");
		});
		assertTrue(exception.getMessage().contains("Invalid Description"));
	// Description is null
		exception = assertThrows(IllegalArgumentException.class, () ->{
			new Task("1234567891","Install", null);
		});
		assertTrue(exception.getMessage().contains("Invalid Description"));
	}
}

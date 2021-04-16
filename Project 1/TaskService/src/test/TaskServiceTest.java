package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import taskService.TaskService;

class TaskServiceTest {

	@Test
	void testAddTask() {
		TaskService taskService = new TaskService();
		taskService.addTask("2021", "Install", "Installs new game");
		assertEquals(taskService.tasks.get(0).getId(), "2021");
	}
	
	@Test
	void testDeleteTask() {
		TaskService taskService = new TaskService();
		taskService.addTask("2021", "Install", "Installs new game");
		taskService.deleteTask("2021");
		assertTrue(taskService.tasks.isEmpty());
	}

	@Test
	void testUpdateTaskName() {
		TaskService taskService = new TaskService();
		taskService.addTask("2021", "Install", "Installs new game");
		taskService.updateTaskName("2021", "Download");
		assertEquals(taskService.tasks.get(0).getName(), "Download");
	}
	
	@Test
	void testUpdateTaskDescrip() {
		TaskService taskService = new TaskService();
		taskService.addTask("2021", "Install", "Installs new game");
		taskService.updateTaskDescrip("2021", "Downloads new game");
		assertEquals(taskService.tasks.get(0).getDescrip(), "Downloads new game");
	}

	@Test
	void testInvalidID() {
		TaskService taskService = new TaskService();
		Exception exception;
	// ID too long for addTask
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("12345678912", "Install", "Installs new game");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for addTask
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask(null, "Install", "Installs new game");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for deleteTask
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("2021", "Install", "Installs new game");
			taskService.deleteTask("12345678912");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for deleteTask
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("2021", "Install", "Installs new game");
			taskService.deleteTask(null);
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for updateTaskName
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("2021", "Install", "Installs new game");
			taskService.updateTaskName("12345678912", "Download");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for updateTaskName
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("2021", "Install", "Installs new game");
			taskService.updateTaskName(null, "Download");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID too long for updateTaskDescrip
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("2021", "Install", "Installs new game");
			taskService.updateTaskDescrip("12345678912", "Downloads new game");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	// ID null for updateTaskDescrip
		exception = assertThrows(IllegalArgumentException.class, () ->{
			taskService.addTask("2021", "Install", "Installs new game");
			taskService.updateTaskDescrip(null, "Downloads new game");
		});
		assertTrue(exception.getMessage().contains("Invalid ID"));
	}
	
}

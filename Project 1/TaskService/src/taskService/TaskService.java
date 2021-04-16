package taskService;

import java.util.ArrayList;
import java.util.List;


public class TaskService {
	
	// list of available tasks
	public List<Task> tasks;
	
	// maximum length of ID String
	static final int MAX_ID_LENGTH = 10;
	
	public TaskService() {
		tasks = new ArrayList<Task>();
	}
	
	// add new task, checking for a valid and unique ID prior to adding task
	public void addTask(String id, String name, String descrip) {
		Task task = null;
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		// checking for existing task with same ID
		for(int i=0; i<tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				task = tasks.get(i);
			}
		}
		
		// else add new task to list
		if(task == null) {
			task = new Task(id, name, descrip);
			tasks.add(task);
		}
	}
	
	// delete task per ID, checking for valid ID first
	public void deleteTask(String id) {
		if(id == null || id.length() > MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				tasks.remove(i);
			}
		}
	}
	
	// update task Name per ID, checking for valid ID first
	public void updateTaskName(String id, String name) {
		if(id == null || id.length() > MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				tasks.get(i).setName(name);
			}
		}
	}
	
	// update task Description per ID, checking for valid ID first
	public void updateTaskDescrip(String id, String descrip) {
		if(id == null || id.length() > MAX_ID_LENGTH) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		for(int i=0; i<tasks.size(); i++) {
			if(tasks.get(i).getId() == id) {
				tasks.get(i).setDescrip(descrip);
			}
		}
	}
	

}

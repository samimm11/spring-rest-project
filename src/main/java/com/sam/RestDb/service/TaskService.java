package com.sam.RestDb.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.RestDb.bean.Task;
import com.sam.RestDb.dao.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task getTaskById(int id) {
		return taskRepository.findById(id).get();
	}

	public Task updateTask(int id, Task taskDetails) {
		Optional<Task> optionalTask = taskRepository.findById(id);
		if (optionalTask.isPresent()) {
			Task task = optionalTask.get();
			task.setName(taskDetails.getName());
			task.setCompleted(taskDetails.isCompleted());
			return taskRepository.save(task);

		} else {
			throw new NoSuchElementException("id " + id + " not found");
		}

	}

	public String deleteTask(int id) {
		taskRepository.deleteById(id);
		return "Task deleted successfully";
	}

}

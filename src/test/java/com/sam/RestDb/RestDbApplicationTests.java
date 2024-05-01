package com.sam.RestDb;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sam.RestDb.bean.Task;
import com.sam.RestDb.dao.TaskRepository;
import com.sam.RestDb.service.TaskService;



@SpringBootTest
class RestDbApplicationTests {

	@Mock
	private TaskRepository taskRepository;

	@Mock
	private TaskService taskService;

	@Test
	void contextLoads() {

		Task task1 = new Task(1, "Task 1", false);
		Task task2 = new Task(2, "Task 2", true);
		List<Task> tasks = new ArrayList<>();
		tasks.add(task1);
		tasks.add(task2);

		when(taskRepository.findAll()).thenReturn(tasks);

		List<Task> result = taskService.getAllTasks();

//		assertEquals(2, tasks.size());
//		assertEquals("Task1", result.get(0).getName());
	}

}

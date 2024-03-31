package com.sam.RestDb.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sam.RestDb.bean.Task;
import com.sam.RestDb.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;

	@GetMapping("/getTasks")
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

//	@PostMapping("/createTask")
//	public Task createTask(@RequestBody Task task) {
//		return taskService.createTask(task);
//	}

	@PostMapping("/createTask")
	public ResponseEntity<Object> createTask(@RequestBody Task task) {
		Task taskObj = taskService.createTask(task);
		URI place = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/tasks/{id}")
				.buildAndExpand(taskObj.getId()).toUri();
		return ResponseEntity.created(place).build();
	}

//	@GetMapping("/{id}")
//	public Task getTaskById(@PathVariable int id) {
//		return taskService.getTaskById(id);
//	}
//	
	@GetMapping("/{id}")
	public EntityModel<Task> getTaskById(@PathVariable int id) {
		Task task = taskService.getTaskById(id);
		EntityModel<Task> resource = EntityModel.of(task);
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllTasks());
		resource.add(linkTo.withRel("All tasks"));
		return resource;
	}

	@PutMapping("/{id}")
	public Task updateTask(@PathVariable int id, @RequestBody Task taskDetails) {
		return taskService.updateTask(id, taskDetails);
	}

	@DeleteMapping("/{id}")
	public String deleteTask(@PathVariable int id) {
		return taskService.deleteTask(id);
	}

}

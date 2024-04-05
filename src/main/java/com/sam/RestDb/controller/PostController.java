package com.sam.RestDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.RestDb.bean.Post;
import com.sam.RestDb.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/getPosts")
	public List<Post> getPosts() {
		return postService.getPosts();
	}

	@GetMapping("/{id}")
	public List<Post> getPostsByUserId(@PathVariable Long id) {
		return postService.getPostsByUserId(id);
	}
}

package com.sam.RestDb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sam.RestDb.bean.Post;
import com.sam.RestDb.bean.UserPost;
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

	@GetMapping("/getExternalPosts")
	public ResponseEntity<Map<String, Object>> getPostsFromExternal() {
		List<UserPost> userPosts = postService.callExternalService();
		Map<String, Object> responseMap = new HashMap<>();

		if (userPosts.isEmpty()) {
			responseMap.put("message", "Failed to fetch posts or no posts found");
			responseMap.put("count", 0);
			responseMap.put("status", HttpStatus.NOT_FOUND.value());			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
		} else {
			responseMap.put("message", "Fetched posts successfully");
			responseMap.put("count", userPosts.size());
			responseMap.put("status", HttpStatus.OK.value());
			responseMap.put("posts", userPosts);			
			return ResponseEntity.ok(responseMap);
		}
	}

}

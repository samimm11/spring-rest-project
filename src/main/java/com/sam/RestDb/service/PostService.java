package com.sam.RestDb.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.sam.RestDb.bean.Post;
import com.sam.RestDb.bean.User;
import com.sam.RestDb.bean.UserPost;
import com.sam.RestDb.dao.PostRepository;
import com.sam.RestDb.dao.UserRepository;

@Service
public class PostService {

	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	public List<Post> getPosts() {
		logger.debug("Getting all Posts");
		return postRepository.findAll();
	}

	public List<Post> getPostsByUserId(Long id) {
		User user = userRepository.findById(id).get();
		if (user == null) {
			return Collections.emptyList();
		} else {
			return user.getPosts();
		}
	}

	  public List<UserPost> callExternalService() {
	        String apiUrl = "https://jsonplaceholder.typicode.com/posts";
	        try {
	            ResponseEntity<UserPost[]> response = restTemplate.getForEntity(apiUrl, UserPost[].class);
	            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
	                logger.info("Successfully fetched posts from external API.");
	                return Arrays.asList(response.getBody());
	            } else {
	                logger.warn("Received non-success status from external API: " + response.getStatusCode());
	                return Collections.emptyList();
	            }
	        } catch (RestClientException e) {
	            logger.error("Error occurred while calling external API: " + e.getMessage(), e);
	            return Collections.emptyList();
	        }
	    }
}

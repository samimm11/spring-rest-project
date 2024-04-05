package com.sam.RestDb.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.RestDb.bean.Post;
import com.sam.RestDb.bean.User;
import com.sam.RestDb.dao.PostRepository;
import com.sam.RestDb.dao.UserRepository;

@Service
public class PostService {

	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	@Autowired
	private PostRepository postRepository;

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
}

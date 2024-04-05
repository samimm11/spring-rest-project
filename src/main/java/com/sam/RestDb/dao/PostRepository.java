package com.sam.RestDb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.RestDb.bean.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(int userId);
}

package com.sam.RestDb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sam.RestDb.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);
	
	 @Query(value = "SELECT * FROM USER_ENTITY u WHERE u.name LIKE %:name%", nativeQuery = true)
	    List<User> findByNameContainingNativeQuery(String name);
	
	
}

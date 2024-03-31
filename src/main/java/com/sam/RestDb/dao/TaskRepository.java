package com.sam.RestDb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.RestDb.bean.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}

package com.sam.RestDb.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.RestDb.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData, Long> {
	Optional<ImageData> findByName(String fileName);
}

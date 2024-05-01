package com.sam.RestDb.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sam.RestDb.dao.StorageRepository;
import com.sam.RestDb.entity.ImageData;
import com.sam.RestDb.util.ImageUtils;

@Service
public class StorageService {

	@Autowired
	private StorageRepository storageRepository;

	public String uploadImage(MultipartFile file) {
		try {
			ImageData imageData = new ImageData.Builder().name(file.getOriginalFilename()).type(file.getContentType())
					.imageData(ImageUtils.compressImage(file.getBytes())).build();
			imageData = storageRepository.save(imageData);

			if (imageData != null) {
				return "Image uploaded successfully : " + file.getOriginalFilename();
			}
			return null;

		} catch (IOException e) {
			return "Failed to upload image: " + e.getMessage();
		}
	}

	public byte[] downloadImage(String fileName) {
		Optional<ImageData> dbImageData = storageRepository.findByName(fileName);
		byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
		return images;
	}
}

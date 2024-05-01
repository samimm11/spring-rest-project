package com.sam.RestDb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.util.Arrays;

@Entity
@Table(name = "ImageData")
public class ImageData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String type;

	@Lob
	private byte[] imageData;

	protected ImageData() {
	}

	private ImageData(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.imageData = builder.imageData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "ImageData [id=" + id + ", name=" + name + ", type=" + type + ", imageData=" + Arrays.toString(imageData)
				+ "]";
	}

	public static class Builder {
		private Long id;
		private String name;
		private String type;
		private byte[] imageData;

		public Builder() {
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder imageData(byte[] imageData) {
			this.imageData = imageData;
			return this;
		}

		public ImageData build() {
			return new ImageData(this);
		}
	}
}

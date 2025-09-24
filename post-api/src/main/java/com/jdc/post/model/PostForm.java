package com.jdc.post.model;

import java.time.LocalDateTime;

import com.jdc.post.model.entity.Post;

import jakarta.validation.constraints.NotBlank;

public record PostForm(
		@NotBlank(message = "Please enter title")
		String title,
		@NotBlank(message = "Please enter your name")
		String memberName,
		@NotBlank(message = "Please enter post details")
		String details) {

	public Post entity() {
		
		var entity = new Post();
		entity.setTitle(title);
		entity.setUserName(memberName);
		entity.setDetails(details);
		entity.setPostAt(LocalDateTime.now());
		
		return entity;
	}

}

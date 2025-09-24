package com.jdc.post.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.jdc.post.model.entity.Post;

public record PostVo(
		UUID id,
		String title,
		String memberName,
		String details,
		LocalDateTime postAt) {

	public PostVo(Post entity) {
		this(entity.getId(), 
				entity.getTitle(), 
				entity.getUserName(), 
				entity.getDetails(), 
				entity.getPostAt());
	}
}

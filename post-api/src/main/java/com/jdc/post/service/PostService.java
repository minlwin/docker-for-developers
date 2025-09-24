package com.jdc.post.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.post.model.PostForm;
import com.jdc.post.model.PostVo;
import com.jdc.post.model.repo.PostRepo;


@Service
@Transactional(readOnly = true)
public class PostService {

	@Autowired
	private PostRepo postRepo;

	public List<PostVo> getAll() {
		return postRepo.findAll().stream()
				.map(PostVo::new).toList();
	}

	public PostVo findById(String id) {
		return postRepo.findById(UUID.fromString(id)).map(PostVo::new)
				.orElseThrow();
	}

	@Transactional
	public String create(PostForm form) {
		var entity = postRepo.save(form.entity());
		return entity.getId().toString();
	}

	@Transactional
	public String update(String id, PostForm form) {
		
		postRepo.findById(UUID.fromString(id)).ifPresent(entity -> {
			entity.setTitle(form.title());
			entity.setUserName(form.memberName());
			entity.setDetails(form.details());
		});
		
		return id;
	}

}

package com.jdc.post.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.post.model.ModificationResult;
import com.jdc.post.model.PostForm;
import com.jdc.post.model.PostVo;
import com.jdc.post.service.PostService;

@RestController
@RequestMapping("posts")
public class PostsApi {
	
	@Autowired
	private PostService service;

	@GetMapping
	List<PostVo> getAll() {
		return service.getAll();
	}
	
	@PostMapping
	ModificationResult<String> create(@Validated @RequestBody PostForm form) {
		var id = service.create(form);
		return new ModificationResult<>(id);
	}

	@PutMapping("{id}")
	ModificationResult<String> update(@PathVariable String id, @Validated @RequestBody PostForm form) {
		var outputId = service.update(id, form);
		return new ModificationResult<>(outputId);
	}
	
	@GetMapping("{id}")
	PostVo findById(@PathVariable String id) {
		return service.findById(id);
	}
}

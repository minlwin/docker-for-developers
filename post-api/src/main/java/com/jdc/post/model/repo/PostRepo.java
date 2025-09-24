package com.jdc.post.model.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.post.model.entity.Post;

public interface PostRepo extends JpaRepository<Post, UUID>{

}

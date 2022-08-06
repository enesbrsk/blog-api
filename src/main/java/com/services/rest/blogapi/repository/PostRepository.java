package com.services.rest.blogapi.repository;

import com.services.rest.blogapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}

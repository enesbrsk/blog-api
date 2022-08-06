package com.services.rest.blogapi.controller;

import com.services.rest.blogapi.dto.PostRequest;
import com.services.rest.blogapi.dto.PostResponse;
import com.services.rest.blogapi.entity.Post;
import com.services.rest.blogapi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Boolean> createPost(@RequestParam("image") MultipartFile multipartFile,
                                              @RequestParam Long id) throws IOException {

        postService.createPost(new PostRequest(),multipartFile);
        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPost(){
        return ResponseEntity.ok(postService.getAllPost());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable("id") Long id,
                                                   @RequestBody PostRequest postRequest){
        return ResponseEntity.ok(postService.updatePostById(id,postRequest));
    }
}

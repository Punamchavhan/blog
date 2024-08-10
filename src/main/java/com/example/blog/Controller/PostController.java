package com.example.blog.controller;

import com.example.blog.model.Post;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {

    private final PostService postService;
    
    @Autowired
    public PostController(PostService postService){
        this.postService= postService;

    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post createdPost= postService.savePost(post);
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postService.getPostById(id);
        if (post!= null){
            return ResponseEntity.ok(post);
        }else{
            return ResponseEntity.notFound().build();
        }
    } 
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts= postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
        Post updatedPost = postService.updatePost(id, post);
        if (updatedPost!= null){
            return ResponseEntity.ok(updatedPost);
        }else{
            return ResponseEntity.notFound().build();
        }

    
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletPost (@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}
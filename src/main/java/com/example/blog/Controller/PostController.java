package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {

    private final PostService postService;
    
    @Autowired
    public PostController(PostService PostService){
        this.PostService= PostService;

    }
    @PostMapping
    public ResponseEntity<Post> CreatePost(@RequestBody Post post){
        Post CreatePost= postService.savePost(post);
        return ResponseEntity.ok(createdPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postService.gertPostById(id);
        if (post!= null){
            return ResponseEntity.ok(post);
        }else{
            return ResponseEntity.notFound().build();
        }
    } 
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts= postService.getAllPost();
        return ResponseEntity.ok(posts);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
        Post updatePost = postService.updatePost(id, user);
        if (updatedPost!= null){
            return RequestEntity.ok(updatedPost);
        }else{
            return RequestEntity.notFound().build();
        }

    
    }
    @DeleteMapping("/{id}")
    public RequestEntity<void> deletPost (@PathVariable Long id){
        postService.deletePost(id);
        return RequestEntity.noContent().build();
    }


}
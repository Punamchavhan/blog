
package com.example.demo.service;

import co.example.demo.model.Post;
import java.util.List;


public interface PostService {
    Post savePost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPost();
    Post updatePost(Long id, Post post);
    void deletePost(Long id, Post post);
}

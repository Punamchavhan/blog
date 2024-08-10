
package com.example.blog.service;
import com.example.blog.model.Post;

import java.util.List;


public interface PostService {
    Post savePost(Post post);
    Post getPostById(Long id);
    List<Post> getAllPosts();
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
}

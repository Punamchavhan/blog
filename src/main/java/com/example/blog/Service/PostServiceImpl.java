
package com.example.blog.service;

import com.example.blog.model.Post;
import com.example.blog.repository.PostRepository;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository){
        this.postRepository= postRepository;

    }

    @Override
    public Post savePost(Post post){
        return postRepository.save(post);
    
    }
    @Override
    public Post getPostById(Long id){

        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    @Override
    public Post updatePost(Long id, Post post){
        if (postRepository.existsById(id)){
            post.setId(id);
            return postRepository.save(post);
        }
        return null;
    
    }

    @Override
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}

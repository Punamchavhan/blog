
package com.example.demo.service.impl;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.streotype.servicez;


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
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }
    @Override
    public Post updatePost(Long id, Post post){
        if (postRepository.exsistsById(id)){
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

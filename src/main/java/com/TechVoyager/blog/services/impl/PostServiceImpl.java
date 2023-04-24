package com.TechVoyager.blog.services.impl;

import com.TechVoyager.blog.entities.Category;
import com.TechVoyager.blog.entities.Post;
import com.TechVoyager.blog.entities.User;
import com.TechVoyager.blog.exceptions.ResourceNotFoundException;
import com.TechVoyager.blog.payloads.PostDto;
import com.TechVoyager.blog.repositories.CategoryRepo;
import com.TechVoyager.blog.repositories.PostRepo;
import com.TechVoyager.blog.repositories.UserRepo;
import com.TechVoyager.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User ", "User id", userId));

        Category category= this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category ", "Category id", categoryId));



        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);


        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}

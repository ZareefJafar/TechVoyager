package com.TechVoyager.blog.services;

import com.TechVoyager.blog.entities.Post;
import com.TechVoyager.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto, Integer postId);

    //delete

    void deletePost(Integer postId);

    //get all posts

    List<PostDto> getAllPost();

    //get single post

    PostDto getPostById(Integer postId);

    //get all posts by category

    List<PostDto> getPostByCategory(Integer categoryId);


    //get all posts by user
    List<PostDto> getPostByUser(Integer userId);

    //search posts
    List<Post> searchPosts(String keyword);

}

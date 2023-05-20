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
import java.util.stream.Collectors;


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
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ","post id", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ","post id", postId));
        this.postRepo.delete(post);

    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> allPosts=this.postRepo.findAll();

        List<PostDto> postDtos = allPosts.stream().
                map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post ", "post id", postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {

        Category cat=this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category ", "category id", categoryId ));

        List<Post> posts=this.postRepo.findByCategory(cat);

        List<PostDto> postDtos = posts.stream().map
                ((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user=this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User ", "user id", userId ));

        List<Post> posts=this.postRepo.findByUser(user);

        List<PostDto> postDtos = posts.stream().map
                        ((post) -> this.modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}

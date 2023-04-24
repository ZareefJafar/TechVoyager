package com.TechVoyager.blog.repositories;

import com.TechVoyager.blog.entities.Category;
import com.TechVoyager.blog.entities.Post;
import com.TechVoyager.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);


}

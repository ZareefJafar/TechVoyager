package com.TechVoyager.blog.repositories;

import com.TechVoyager.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {


}

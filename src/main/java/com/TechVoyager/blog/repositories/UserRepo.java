package com.TechVoyager.blog.repositories;

import com.TechVoyager.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}

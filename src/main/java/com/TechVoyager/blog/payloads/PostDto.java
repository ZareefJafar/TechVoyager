package com.TechVoyager.blog.payloads;

import com.TechVoyager.blog.entities.Category;
import com.TechVoyager.blog.entities.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;


    private CategoryDto category;


    private UserDto user;



}

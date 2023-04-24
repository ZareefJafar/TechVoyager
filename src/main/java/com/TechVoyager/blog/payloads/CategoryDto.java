package com.TechVoyager.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;


    @Size(min = 1, max = 5, message = "Category title must be minimum 2 and maximum 5 characters long")
    private String categoryTitle;


    @Size(min = 10, max = 100, message = "Category description must be minimum 10 and maximum 40 characters long")
    private String categoryDescription;
}

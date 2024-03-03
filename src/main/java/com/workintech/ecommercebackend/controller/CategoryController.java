package com.workintech.ecommercebackend.controller;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.entity.Category;
import com.workintech.ecommercebackend.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public CategoryResponseDto save(@Valid @RequestBody Category category){
        return  categoryService.save(category);
    }

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        List<CategoryResponseDto> categories = categoryService.findAll();
        return categories;
    }
    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable long id) {
       return categoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public CategoryResponseDto deleteCategory(@PathVariable long id) {
       return categoryService.remove(id);
    }
}

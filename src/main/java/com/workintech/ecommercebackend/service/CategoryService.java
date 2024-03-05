package com.workintech.ecommercebackend.service;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    Category findByIdOriginal(Long id);

    CategoryResponseDto findById(long id);

    CategoryResponseDto save(Category category);

    CategoryResponseDto remove(long id);
}

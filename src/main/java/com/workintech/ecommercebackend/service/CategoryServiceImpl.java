package com.workintech.ecommercebackend.service;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.entity.Category;
import com.workintech.ecommercebackend.exception.CategoryException;
import com.workintech.ecommercebackend.repository.CategoryRepository;
import com.workintech.ecommercebackend.util.DtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return DtoConvertion.convertCategories(categories);
    }

    @Override
    public CategoryResponseDto findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            return DtoConvertion.convertCategory(category);
        }
        throw new CategoryException("Category is not found with given id: " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public CategoryResponseDto save(Category category) {
         Category savedCategory = categoryRepository.save(category);
         return DtoConvertion.convertCategory(category);
    }

    @Override
    public CategoryResponseDto remove(long id) {
        CategoryResponseDto categoryResponseDto = findById(id);
        categoryRepository.deleteById(id);
        return categoryResponseDto;
    }
}

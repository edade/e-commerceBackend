package com.workintech.ecommercebackend.util;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class DtoConvertion {

    public static List<CategoryResponseDto> convertCategories(List<Category> categories){
        List<CategoryResponseDto> categoryResponses = new ArrayList<>();

        for(Category category: categories){
            categoryResponses.add(new CategoryResponseDto(category.getTitle()
                    ,category.getGender()));
        }
        return categoryResponses;
    }
    public static CategoryResponseDto convertCategory(Category category){
        return new CategoryResponseDto(category.getTitle(),category.getGender());
    }

}

package com.workintech.ecommercebackend.util;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.dto.ProductResponseDto;
import com.workintech.ecommercebackend.entity.Category;
import com.workintech.ecommercebackend.entity.Product;

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

    public static List<ProductResponseDto> convertProducts(List<Product> products){
        List<ProductResponseDto> productResponses = new ArrayList<>();

        for (Product product : products) {
            Category category = product.getCategory();
            CategoryResponseDto categoryResponseDto = null;
            if (category != null) {
                categoryResponseDto = new CategoryResponseDto(category.getTitle(), category.getGender());
            }

            ProductResponseDto productResponseDto = new ProductResponseDto(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice(),
                    categoryResponseDto
            );
            productResponses.add(productResponseDto);
        }
        return productResponses;
    }
    public static CategoryResponseDto convertCategory(Category category){
        return new CategoryResponseDto(category.getTitle(),category.getGender());
    }
    public static ProductResponseDto convertProduct(Product product){
        Category category = product.getCategory();
        CategoryResponseDto categoryResponseDto = null;
        if (category != null) {
            categoryResponseDto = new CategoryResponseDto(category.getTitle(), category.getGender());
        }

        return new ProductResponseDto(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                categoryResponseDto
        );
    }

}

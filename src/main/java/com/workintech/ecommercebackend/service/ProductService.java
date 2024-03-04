package com.workintech.ecommercebackend.service;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.dto.ProductResponseDto;
import com.workintech.ecommercebackend.entity.Category;
import com.workintech.ecommercebackend.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> findAll();

    ProductResponseDto findById(long id);

    List<ProductResponseDto> findProductsByCategoryId(Long categoryId, Product product);

    ProductResponseDto save(Long categoryId,Product product);

    ProductResponseDto remove(long id);
}

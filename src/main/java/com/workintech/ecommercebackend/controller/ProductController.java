package com.workintech.ecommercebackend.controller;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.dto.ProductResponseDto;
import com.workintech.ecommercebackend.entity.Category;
import com.workintech.ecommercebackend.entity.Product;
import com.workintech.ecommercebackend.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/{categoryId}")
    public ProductResponseDto save(@PathVariable Long categoryId,
                                   @RequestBody Product product){
        return productService.save(categoryId, product);
    }

    @DeleteMapping("/{id}")
    public ProductResponseDto deleteCategory(@PathVariable long id) {
        return productService.remove(id);
    }

}

package com.workintech.ecommercebackend.service;

import com.workintech.ecommercebackend.dto.CategoryResponseDto;
import com.workintech.ecommercebackend.dto.ProductResponseDto;
import com.workintech.ecommercebackend.entity.Category;
import com.workintech.ecommercebackend.entity.Product;
import com.workintech.ecommercebackend.exception.CategoryException;
import com.workintech.ecommercebackend.exception.ProductException;
import com.workintech.ecommercebackend.repository.ProductRepository;
import com.workintech.ecommercebackend.util.DtoConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    private CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        List<Product> products = productRepository.findAll();
        return DtoConvertion.convertProducts(products);
    }

    @Override
    public ProductResponseDto findById(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return DtoConvertion.convertProduct(product);
        }
        throw new ProductException("Product is not found with given id: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<ProductResponseDto> findProductsByCategoryId(Long categoryId, Product product) {
        // Kategori var mı kontrol et
        Category category = categoryService.findByIdOriginal(categoryId);
        if (category == null) {
            throw new CategoryException("Category is not found with given id: " + categoryId, HttpStatus.NOT_FOUND);
        }
        List<Product> products = category.getProductList();
        return DtoConvertion.convertProducts(products);
    }

    @Override
    public ProductResponseDto save(Long categoryId, Product product) {
        Category category = categoryService.findByIdOriginal(categoryId);
        //2. categorynin product listesini yeni product ı ekle.
        category.addProduct(product);
        //3. Product'a categoryi ekle.
        product.setCategory(category);
        //4. Productı save et.
        Product savedProduct = productRepository.save(product);

        return new ProductResponseDto(product.getName(), product.getDescription(), product.getPrice(),
                new CategoryResponseDto(category.getTitle(), category.getGender()));
    }

    @Override
    public ProductResponseDto remove(long id) {
        ProductResponseDto productResponseDto = findById(id);
        productRepository.deleteById(id);
        return productResponseDto;
    }
}

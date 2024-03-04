package com.workintech.ecommercebackend.repository;

import com.workintech.ecommercebackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

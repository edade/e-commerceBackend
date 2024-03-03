package com.workintech.ecommercebackend.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "category", schema = "ecommerce")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 45, message = "Category title can not be less than 2 or greater than 45 characters")
    @Column(name = "title")
    private String title;


    @Column(name = "image")
    private String image;
    @NotBlank(message = "Gender section must not be blank")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Gender must not contain digits")
    @Column(name = "gender")
    private String gender;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private List<Product> productList;
//
//    public void addProduct(Product product) {
//        if (productList == null) {
//            productList = new ArrayList<>();
//        }
//        productList.add(product);
//    }
//





}

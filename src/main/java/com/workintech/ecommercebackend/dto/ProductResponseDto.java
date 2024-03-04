package com.workintech.ecommercebackend.dto;

public record ProductResponseDto(String name,String description, Double price,CategoryResponseDto category ) {
}

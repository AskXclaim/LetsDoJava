package com.springbootstore.apifundamental.mapper;

import com.springbootstore.apifundamental.dtos.products.ProductDto;
import com.springbootstore.apifundamental.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto productToProductDto(Product product);
}

package com.springbootstore.apifundamental.controllers;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.dtos.products.ProductDto;
import com.springbootstore.apifundamental.dtos.products.ProductRequest;
import com.springbootstore.apifundamental.dtos.responses.Response;
import com.springbootstore.apifundamental.entities.Product;
import com.springbootstore.apifundamental.mapper.ProductMapper;
import com.springbootstore.apifundamental.services.interfaces.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.springbootstore.apifundamental.utilities.ResponseUtility.getResponse;
import static com.springbootstore.apifundamental.utilities.ResponseUtility.getExceptionCaseResponseEntity;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    @GetMapping("/products")
    public Response getAllProducts(ProductRequest request) {

        try {
            var result = getProducts(request);
            var products = getProductDtos(result);

            return getResponse(new ResponseEntity<>(products, HttpStatus.OK));
        } catch (Exception exception) {
            return getResponse(getExceptionCaseResponseEntity(exception));
        }
    }

    @GetMapping("/products/{categoryId}")
    public Response getProducts(@PathVariable Byte categoryId) {
        try {
            var result = productService.getProductByCategoryId(categoryId).orElse(null);
            var product = getProductDtos(result);

            return getResponse(new ResponseEntity<>(product, HttpStatus.OK));
        } catch (Exception exception) {
            return getResponse(getExceptionCaseResponseEntity(exception));
        }
    }

    @GetMapping("product")
    public Response getProductById(@RequestParam Long id) {
        try {
            var result = productService.getProductById(id).orElse(null);
            var productDto = productMapper.productToProductDto(result);

            return getResponse(new ResponseEntity<>(productDto, HttpStatus.OK));
        } catch (Exception exception) {
            return getResponse(getExceptionCaseResponseEntity(exception));
        }
    }

    private Iterable<Product> getProducts(ProductRequest request) {
        Iterable<Product> result;
        if (request == null) {
            result = productService.getAllProducts("name", new PageRequest(0, 10)).orElse(null);
        } else if (request.getSortBy().isBlank()) {
            result = productService.getAllProducts("name", request.getPageRequest()).orElse(null);
        } else {
            result = productService.getProductByCategoryId(Byte.valueOf(request.getSortBy())).orElse(null);
        }
        return result;
    }

    private ArrayList<ProductDto> getProductDtos(Iterable<Product> result) {
        var products = new ArrayList<ProductDto>();
        if (result != null) {
            for (Product product : result) {
                products.add(productMapper.productToProductDto(product));
            }
        }
        return products;
    }

}

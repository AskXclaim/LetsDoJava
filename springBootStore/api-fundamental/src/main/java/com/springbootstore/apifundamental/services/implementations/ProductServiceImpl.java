package com.springbootstore.apifundamental.services.implementations;

import com.springbootstore.apifundamental.dtos.PageRequest;
import com.springbootstore.apifundamental.entities.Product;
import com.springbootstore.apifundamental.repositories.ProductRepository;
import com.springbootstore.apifundamental.services.interfaces.ProductService;
import com.springbootstore.apifundamental.utilities.RequestParams;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;

import static com.springbootstore.apifundamental.utilities.RepositoryUtility.getEntities;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Optional<Iterable<Product>> getAllProducts(String sortBy, PageRequest pageRequest) {
        var sortByValues = new LinkedHashSet<String>();
        sortByValues.add("name");
        var repoPageRequest = RequestParams.getReposPageRequest(sortBy, sortByValues, pageRequest);
        var products = productRepository.findAll(repoPageRequest);

        return Optional.ofNullable(getEntities(products));
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Iterable<Product>> getProductByCategoryId(Byte id) {
        return productRepository.findByCategoryId(id);
    }
}

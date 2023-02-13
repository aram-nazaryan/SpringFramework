package com.sourcemind.management.service;

import com.sourcemind.management.domain.Product;
import com.sourcemind.management.facade.ProductParams;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderService {
    void save(ProductParams params);

    Boolean findProductByImageBlobId(String uuid);

    Optional<Product> findProductByUuid(String uuid);

    void deleteProduct(Product product);

    List<Product> getAll(String username);
}

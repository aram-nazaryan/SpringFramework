package com.sourcemind.management.repository;

import com.sourcemind.management.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByImageBlobId(String uuid);

    void deleteProductByImageBlobId(String uuid);

    List<Product> findAllByUsername(String username);
}

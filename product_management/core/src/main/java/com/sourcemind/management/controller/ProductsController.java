package com.sourcemind.management.controller;

import com.sourcemind.management.dto.AllProductsResponseDto;
import com.sourcemind.management.dto.ProductRequestDto;
import com.sourcemind.management.dto.ProductResponseDto;
import com.sourcemind.management.facade.OrderServiceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {

    private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
    private final OrderServiceFacade orderServiceFacade;

    public ProductsController(OrderServiceFacade orderServiceFacade) {
        this.orderServiceFacade = orderServiceFacade;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> doPost(@RequestBody ProductRequestDto requestDto) {
        log.info("ProductsController((POST)/products), body params - {}", requestDto);
        ProductResponseDto response = orderServiceFacade.save(requestDto);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping("/products/{uuid}/image")
    public ResponseEntity<ProductResponseDto> doPostImage(@PathVariable String uuid) {
        log.info("ProductsController /products/{uuid}/image with param -{}", uuid);
        ProductResponseDto productResponseDto = orderServiceFacade.imageId(uuid);
        return ResponseEntity.status(productResponseDto.getHttpStatus()).body(productResponseDto);
    }

    @GetMapping("/products/{uuid}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable String uuid) {
        log.info("ProductsController(GET) param {}", uuid);
        ProductResponseDto productByUuid = orderServiceFacade.getProductByUuid(uuid);
        return ResponseEntity.status(productByUuid.getHttpStatus()).body(productByUuid);
    }

    @DeleteMapping("/products/{uuid}")
    public ResponseEntity<ProductResponseDto> deleteProduct(@PathVariable String uuid) {
        log.info("ProductsController(DELETE) param {}", uuid);
        ProductResponseDto productByUuid = orderServiceFacade.deleteProductByUuid(uuid);
        return ResponseEntity.status(productByUuid.getHttpStatus()).body(productByUuid);
    }

    @GetMapping("/products")
    public ResponseEntity<AllProductsResponseDto> getAll(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        AllProductsResponseDto all = orderServiceFacade.getAll(principal.getUsername());
        return ResponseEntity.status(all.getHttpStatus()).body(all);
    }
}

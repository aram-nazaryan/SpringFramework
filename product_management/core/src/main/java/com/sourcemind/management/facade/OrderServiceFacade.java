package com.sourcemind.management.facade;

import com.sourcemind.management.dto.AllProductsResponseDto;
import com.sourcemind.management.dto.ProductRequestDto;
import com.sourcemind.management.dto.ProductResponseDto;

public interface OrderServiceFacade {
    ProductResponseDto save(ProductRequestDto requestDto);

    ProductResponseDto imageId(String uuid);

    ProductResponseDto getProductByUuid(String uuid);

    ProductResponseDto deleteProductByUuid(String uuid);

    AllProductsResponseDto getAll(String username);
}

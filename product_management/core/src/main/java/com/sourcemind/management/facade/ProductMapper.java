package com.sourcemind.management.facade;

import com.sourcemind.management.domain.Product;
import com.sourcemind.management.dto.ProductResponseDto;

public interface ProductMapper {

    ProductResponseDto mapToResponse(Product product);
}

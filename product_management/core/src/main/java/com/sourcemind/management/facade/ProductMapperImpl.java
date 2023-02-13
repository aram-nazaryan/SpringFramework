package com.sourcemind.management.facade;

import com.sourcemind.management.domain.Product;
import com.sourcemind.management.domain.Tag;
import com.sourcemind.management.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponseDto mapToResponse(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setName(product.getName());
        responseDto.setDescription(product.getDescription());
        responseDto.setImageId(product.getImageBlobId());
        responseDto.setTags(product.getTagList().stream().map(Tag::getType).toList());
        responseDto.setOwnerName(product.getUsername());
        responseDto.setHttpStatus(200);
        return responseDto;
    }
}

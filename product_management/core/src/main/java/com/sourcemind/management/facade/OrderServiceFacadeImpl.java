package com.sourcemind.management.facade;

import com.sourcemind.management.domain.Product;
import com.sourcemind.management.dto.AllProductsResponseDto;
import com.sourcemind.management.dto.ErrorType;
import com.sourcemind.management.dto.ProductRequestDto;
import com.sourcemind.management.dto.ProductResponseDto;
import com.sourcemind.management.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderServiceFacadeImpl implements OrderServiceFacade {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceFacadeImpl.class);

    private final OrderService orderService;

    private final ProductMapper productMapper;

    public OrderServiceFacadeImpl(OrderService orderService, ProductMapper productMapper) {
        this.orderService = orderService;
        this.productMapper = productMapper;
    }

    @Override
    public ProductResponseDto save(ProductRequestDto requestDto) {
        log.info("OrderServiceFacadeImpl save - {}", requestDto);
        orderService.save(new ProductParams(requestDto.getName(), requestDto.getDescription(), requestDto.getTagList(), requestDto.getOwnerName()));
        return new ProductResponseDto();
    }

    @Override
    public ProductResponseDto imageId(String uuid) {
        log.info("OrderServiceFacadeImpl imageId - {}", uuid);
        if (orderService.findProductByImageBlobId(uuid)) {
            return new ProductResponseDto();
        }
        ErrorType errorType = ErrorType.IMAGE_NOT_FOUND;
        return new ProductResponseDto(errorType.errorDto());
    }

    @Override
    public ProductResponseDto getProductByUuid(String uuid) {
        log.info("OrderServiceFacadeImpl getProductByUuid - {}", uuid);
        Optional<Product> productByUuid = orderService.findProductByUuid(uuid);
        if (productByUuid.isPresent()) {
            log.info("Product found");
            return productMapper.mapToResponse(productByUuid.get());
        }
        log.info("Not found");
        ErrorType errorType = ErrorType.PRODUCT_NOT_FOUND;
        return new ProductResponseDto(errorType.errorDto());
    }

    @Override
    public ProductResponseDto deleteProductByUuid(String uuid) {
        log.info("OrderServiceFacadeImpl deleteProductByUuid - {}", uuid);
        Optional<Product> productByUuid = orderService.findProductByUuid(uuid);
        if (productByUuid.isPresent()) {
            log.info("Product found");
            orderService.deleteProduct(productByUuid.get());
            return new ProductResponseDto();
        }
        log.info("Not found");
        ErrorType errorType = ErrorType.PRODUCT_NOT_FOUND;
        return new ProductResponseDto(errorType.errorDto());
    }

    @Override
    public AllProductsResponseDto getAll(String username) {
        List<Product> all = orderService.getAll(username);
        List<ProductResponseDto> productResponseDtos = all.stream().map(productMapper::mapToResponse).toList();
        AllProductsResponseDto allProductsResponseDto = new AllProductsResponseDto();
        allProductsResponseDto.setProductResponseDtoList(productResponseDtos);
        return allProductsResponseDto;
    }
}

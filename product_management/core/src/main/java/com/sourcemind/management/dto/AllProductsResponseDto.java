package com.sourcemind.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllProductsResponseDto extends AwareResponseModel {
    private List<ProductResponseDto> productResponseDtoList;

    public List<ProductResponseDto> getProductResponseDtoList() {
        return productResponseDtoList;
    }

    public void setProductResponseDtoList(List<ProductResponseDto> productResponseDtoList) {
        this.productResponseDtoList = productResponseDtoList;
    }

    public AllProductsResponseDto() {
    }

    public AllProductsResponseDto(final ErrorModel errorModel) {
        super(errorModel);
    }
}

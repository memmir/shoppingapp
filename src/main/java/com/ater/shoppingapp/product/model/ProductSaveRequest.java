package com.ater.shoppingapp.product.model;

import com.ater.shoppingapp.product.domain.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductSaveRequest {

    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private BigDecimal price;
    private Currency currency;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}

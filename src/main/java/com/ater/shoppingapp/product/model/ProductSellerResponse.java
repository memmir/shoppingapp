package com.ater.shoppingapp.product.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductSellerResponse {

    private String id;
    private String name;
}

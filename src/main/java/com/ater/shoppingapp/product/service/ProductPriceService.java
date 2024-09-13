package com.ater.shoppingapp.product.service;

import com.ater.shoppingapp.product.domain.Currency;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductPriceService {

    public BigDecimal getByCurrency(String id, Currency currency) {
        return BigDecimal.TEN;
    }
}

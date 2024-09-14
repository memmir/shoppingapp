package com.ater.shoppingapp.product.service;

import com.ater.shoppingapp.product.domain.Currency;
import com.ater.shoppingapp.product.repository.ProductPriceRepository;
import com.ater.shoppingapp.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public BigDecimal getByCurrency(String id, Currency currency) {
        return BigDecimal.TEN;
    }
}

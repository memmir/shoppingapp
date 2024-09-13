package com.ater.shoppingapp.product.service;

import com.ater.shoppingapp.product.model.ProductResponse;
import com.ater.shoppingapp.product.model.ProductSaveRequest;
import com.ater.shoppingapp.product.repository.ProductRepository;
import com.ater.shoppingapp.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;

    List<ProductResponse> getByPaging(Pageable pageable){
        // 1 - ES den sorgula
        // 2 - Calc fieldlari isle
        // 3 - redisten ihtiyaç alanlarini getir
        // 4 - response nesnesine donustur.

        return null;
    }

    ProductResponse save(ProductSaveRequest productSaveRequest){
        // 1 - ES den sorgula
        // 2 - Calc fieldlari isle
        // 3 - redisten ihtiyaç alanlarini getir
        // 4 - response nesnesine donustur.

        return null;
    }
}

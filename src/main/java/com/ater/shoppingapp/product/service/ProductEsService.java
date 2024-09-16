package com.ater.shoppingapp.product.service;


import com.ater.shoppingapp.product.domain.Product;
import com.ater.shoppingapp.product.domain.es.CategoryEs;
import com.ater.shoppingapp.product.domain.es.CompanyEs;
import com.ater.shoppingapp.product.domain.es.ProductEs;
import com.ater.shoppingapp.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }


    public Mono<ProductEs> saveNewProduct(Product product) {

        ProductEs productEs = ProductEs.builder()
                .active(product.getActive())
                .name(product.getName())
                .code(product.getCode())
                .description(product.getDescription())
                .features(product.getFeatures())
                .id(product.getId())
                .name(product.getName())
                .companyId(CompanyEs.builder().id(product.getCompanyId()).name("test").build())
                .categoryId(CategoryEs.builder().id(product.getCategoryId()).name("test").build())
                .build();
         return productEsRepository.save(productEs);

    }

}

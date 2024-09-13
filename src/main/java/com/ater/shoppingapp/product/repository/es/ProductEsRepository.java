package com.ater.shoppingapp.product.repository.es;


import com.ater.shoppingapp.product.domain.es.ProductEs;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ProductEsRepository  extends ReactiveElasticsearchRepository<ProductEs, String> {
}

package com.ater.shoppingapp.product.service;

import com.ater.shoppingapp.product.domain.Currency;
import com.ater.shoppingapp.product.domain.Product;
import com.ater.shoppingapp.product.domain.ProductImage;
import com.ater.shoppingapp.product.domain.es.ProductEs;
import com.ater.shoppingapp.product.model.ProductResponse;
import com.ater.shoppingapp.product.model.ProductSaveRequest;
import com.ater.shoppingapp.product.model.ProductSellerResponse;
import com.ater.shoppingapp.product.repository.ProductPriceRepository;
import com.ater.shoppingapp.product.repository.ProductRepository;
import com.ater.shoppingapp.product.repository.es.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;
    private final ProductEsService productEsService;

    public Flux<ProductResponse> getAll(){

        return productEsService.findAll().map(this::mapToDto);


    }


    // 1 - ES den sorgula
    // 2 - Calc fieldlari isle
    // 3 - redisten ihtiyaç alanlarini getir
    // 4 - response nesnesine donustur.
    public ProductResponse save(ProductSaveRequest productSaveRequest){

        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR0001")
                .categoryId(productSaveRequest.getCategoryId())
                .companyId(productSaveRequest.getSellerId())
                .description(productSaveRequest.getDescription())
                .features(productSaveRequest.getFeatures())
                .name(productSaveRequest.getName())
                .productImage(productSaveRequest.getImages().stream().map(it -> new ProductImage(ProductImage.ImageType.FEATURE,it)).collect(Collectors.toList()))
                .build();

        product = productRepository.save(product).block();
        productEsService.saveNewProduct(product);
        return null;
    }


    /*
     // 1 - ES den sorgula
        // 2 - Calc fieldlari isle
        // 3 - redisten ihtiyaç alanlarini getir
        // 4 - response nesnesine donustur.
     */
    private ProductResponse mapToDto(ProductEs productEs) {

        BigDecimal productPrice = productPriceService.getByCurrency(productEs.getId(), Currency.USD );

        return ProductResponse.builder()
                .price(productPrice)
                .name(productEs.getName())
                .features(productEs.getFeatures())
                .id(productEs.getId())
                .description(productEs.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(productEs.getId()))
                .categoryId(productEs.getCategoryId().getId())
                .available(productAmountService.getByProductId(productEs.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(productEs.getId(), productPrice))
                .currency(Currency.USD)
                .image(productImageService.getProductMainImage(productEs.getId()))
                .seller(ProductSellerResponse.builder().id(productEs.getId()).name(productEs.getName()).build())
                .build();

    }
}

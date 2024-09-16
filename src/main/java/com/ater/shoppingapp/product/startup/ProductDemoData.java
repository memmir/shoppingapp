package com.ater.shoppingapp.product.startup;

import com.ater.shoppingapp.product.domain.Currency;
import com.ater.shoppingapp.product.model.ProductSaveRequest;
import com.ater.shoppingapp.product.repository.ProductRepository;
import com.ater.shoppingapp.product.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {

    private final ProductService productService;

    @EventListener(ApplicationReadyEvent.class) // proje tamamen hazır olduktan sonra, tamamen ayağa kalktıktan sonra bu işlem yapılacak
    public void migrate(){
        Long  countOfData = productService.count().block();

        String imgUuid = UUID.randomUUID().toString();

        if(countOfData.equals(0L)){
            IntStream.range(0, 20).forEach(item -> {
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerId(randomUUID().toString())
                                .id(randomUUID().toString())
                                .description("Product Description" + item)
                                .currency(Currency.TL)
                                .categoryId(randomUUID().toString())
                                .name("Product Name" + item)
                                .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                                .price(BigDecimal.TEN)
                                .images(List.of(imgUuid))
                                .build()
                );
            });
        }
    }
}

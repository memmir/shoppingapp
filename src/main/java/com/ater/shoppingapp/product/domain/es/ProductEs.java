package com.ater.shoppingapp.product.domain.es;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

//Bu classın işlevi: Elastic search deki bir product ı represente etmeyi sağlayacak.
@Document(indexName = "product")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class ProductEs {

    private String id;
    private String code;
    private String name;
    private String description;
    private CompanyEs companyId;
    private String features;
    private CategoryEs categoryId;
    private String productCode;
    private Boolean active;
}


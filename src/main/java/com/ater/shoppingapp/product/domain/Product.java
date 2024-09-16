package com.ater.shoppingapp.product.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document(collation = "product")
//Oluşturdğumuz modelin MongoDb de bulunan collection lara karşılık gelmesini sağlayan annotation.
// Spring Data daki gibi entity kullanıyorduk relational databaselerde. Mongodb de document kullanılıyor.
//Mongo relational database olmadığı için collectionlar var
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id") // 2 product price nesnesinin birbirine eşit olup olmadığını anlayacağız değişken id değişkeni olduğunu belirttik.
public class Product {

    private String id;
    private String code;
    private String name;
    private String description;
    private String companyId;
    private String features;
    private String categoryId;
    private String productCode;
    private List<ProductImage> productImage;
    private Boolean active;
}

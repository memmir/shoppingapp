package com.ater.shoppingapp.product.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "product_price")
//Oluşturdğumuz modelin MongoDb de bulunan collection lara karşılık gelmesini sağlayan annotation.
// Spring Data daki gibi entity kullanıyorduk relational databaselerde. Mongodb de document kullanılıyor.
//Mongo relational database olmadığı için collectionlar var
@Getter
@Setter
@EqualsAndHashCode(of = "id") // 2 product price nesnesinin birbirine eşit olup olmadığını anlayacağız değişken id değişkeni olduğunu belirttik.
public class ProductPrice {
    private String id;
    private String productId;
    private Currency currency;
    private String price;
}

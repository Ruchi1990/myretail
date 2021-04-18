package com.casestudy.myretail.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private long productId;
    @Field("name")
    public String name;
    @Field("current_price")
    public CurrentPrice currentPrice;

    public Product() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Product(long productId, String name, CurrentPrice currentPrice) {
        this.productId = productId;
        this.name = name;
        this.currentPrice = currentPrice;
    }





}


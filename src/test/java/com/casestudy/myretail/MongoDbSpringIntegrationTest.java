package com.casestudy.myretail;


import com.casestudy.myretail.model.CurrentPrice;
import com.casestudy.myretail.model.Product;
import com.casestudy.myretail.repository.ProductRepository;
import com.casestudy.myretail.repository.ProductRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@DataMongoTest
@ExtendWith(SpringExtension.class)
public class MongoDbSpringIntegrationTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        this.productRepository = new ProductRepositoryImpl(mongoTemplate);
    }

    @Test
    void shouldReturnProductWithProductId() {
        this.mongoTemplate.save(new Product(1234567L, "duke@spring.io", new CurrentPrice(44.0, "USD")));

        Product product = productRepository.findOne(1234567L);
        assertEquals(product, product);

    }

    @Test
    void shouldUpdateProductWithProductId() {
        Long productId = 1234567L;
        Double price =30.5;
        Query query = new Query().addCriteria(where("productId").is(productId));
        Product product = mongoTemplate.findOne(query, Product.class);
        CurrentPrice currentPrice = new CurrentPrice(price, "USD");
            product.setCurrentPrice(currentPrice);
            mongoTemplate.save(product);
       assertTrue(product!=null);
    }
}

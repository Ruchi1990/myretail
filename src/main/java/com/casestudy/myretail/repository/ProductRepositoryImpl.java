package com.casestudy.myretail.repository;

import com.casestudy.myretail.model.CurrentPrice;
import com.casestudy.myretail.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final MongoTemplate mongoTemplate;

    public ProductRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Product findOne(Long productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("productId").is(productId));
        return mongoTemplate.findOne(query, Product.class);
    }

    @Override
    public String updateProductForProductId(Long productId, Double price) {
        Query query = new Query().addCriteria(where("productId").is(productId));

        Product product = mongoTemplate.findOne(query, Product.class);
        CurrentPrice currentPrice = new CurrentPrice(price, "USD");
        if (product != null) {
            product.setCurrentPrice(currentPrice);
            mongoTemplate.save(product);
            return "Product Updated";
        } else {
            return "Product not found.";
        }
    }

    @Override
    public <S extends Product> S save(S s) {
        return null;
    }

    @Override
    public <S extends Product> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}


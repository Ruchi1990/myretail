package com.casestudy.myretail.controller;

import com.casestudy.myretail.model.Product;
import com.casestudy.myretail.repository.ProductRepository;
import com.casestudy.myretail.repository.ProductRepositoryCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/productDetails/v1")
class RetailController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final ProductRepositoryCustom productRepository;

    public RetailController(ProductRepositoryCustom productRepository) {
        this.productRepository = productRepository;
    }


    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@RequestParam Long productId) {
        LOG.info("Getting product with Product ID: {}.", productId);
        Product product= productRepository.findOne(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
    public ResponseEntity<String> updateProduct(@RequestParam Long productId,@RequestParam Double price) {
        LOG.info("Updating product with Product ID: {}.", productId);
        return ResponseEntity.ok(productRepository.updateProductForProductId(productId,price));
    }
}
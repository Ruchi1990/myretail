package com.casestudy.myretail.repository;

import com.casestudy.myretail.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>, ProductRepositoryCustom {

    // Declare query methods here
}

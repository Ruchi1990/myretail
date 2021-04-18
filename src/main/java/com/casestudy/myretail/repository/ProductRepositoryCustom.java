package com.casestudy.myretail.repository;

import com.casestudy.myretail.model.Product;

public interface ProductRepositoryCustom{

Product findOne(Long productId);

String updateProductForProductId(Long productId,Double price);
}

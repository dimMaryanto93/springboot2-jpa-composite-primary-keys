package com.maryanto.dimas.example.repository;

import com.maryanto.dimas.example.entity.Product;
import com.maryanto.dimas.example.entity.ProductPrimaryKey;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, ProductPrimaryKey> {
}

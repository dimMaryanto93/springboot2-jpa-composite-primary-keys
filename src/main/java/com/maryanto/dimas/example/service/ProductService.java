package com.maryanto.dimas.example.service;

import com.maryanto.dimas.example.entity.Product;
import com.maryanto.dimas.example.entity.ProductPrimaryKey;
import com.maryanto.dimas.example.repository.ProductRepository;
import com.maryanto.dimas.plugins.web.commons.data.dao.DaoCrudPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
public class ProductService implements DaoCrudPattern<Product, ProductPrimaryKey> {

    @Autowired
    private ProductRepository repo;

    @Override
    public Optional<Product> findId(ProductPrimaryKey id) {
        return repo.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(
                        repo.findAll().iterator(), Spliterator.ORDERED),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return repo.save(product);
    }

    @Override
    @Transactional
    public boolean remove(Product product) {
         repo.delete(product);
         return true;
    }

    @Override
    @Transactional
    public boolean removeById(ProductPrimaryKey id) {
        repo.deleteById(id);
        return true;
    }
}

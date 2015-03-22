package org.snmco.stock.productmanager.service;

import org.snmco.stock.productmanager.document.Product;
import org.snmco.stock.productmanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findProducts(int page, int size)
    {
        Pageable pageable = new PageRequest(page, size);
        return productRepository.findAll(pageable);
    }


    public void save(Product product) {
        productRepository.save(product);
    }


    public void delete(String productId) {
        productRepository.delete(productId);
    }
}

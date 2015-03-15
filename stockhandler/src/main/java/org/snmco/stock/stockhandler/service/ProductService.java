package org.snmco.stock.stockhandler.service;

import org.snmco.stock.stockhandler.entity.Product;
import org.snmco.stock.stockhandler.reppository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<Product> listAll(int page, int size){

        Pageable pageable = new PageRequest(page, size);
        return productRepository.findAll(pageable);

    }

    @Transactional
    public void updateStock(String productId, int stockSize)
    {
        Optional<Product> productOptional = Optional.of(productRepository.findOne(productId));
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setStock(stockSize);

            productRepository.save(product);
        }
    }
}

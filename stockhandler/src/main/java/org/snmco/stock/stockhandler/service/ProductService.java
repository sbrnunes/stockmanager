package org.snmco.stock.stockhandler.service;

import org.snmco.stock.stockhandler.entity.Company;
import org.snmco.stock.stockhandler.entity.Product;
import org.snmco.stock.stockhandler.reppository.CompanyRepository;
import org.snmco.stock.stockhandler.reppository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Page<Product> findByCompany(String companyId, int page, int size) {

        Pageable pageable = new PageRequest(page, size);
        Company company = companyRepository.findOne(companyId);
        return productRepository.findByCompany(company, pageable);
    }

    // TODO security : link to company
    @Transactional
    public Product updateStock(String productId, int stockSize) {
        Optional<Product> productOptional = Optional.of(productRepository.findOne(productId));
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setStock(stockSize);
            productRepository.save(product);
            return product;
        }
        //TODO exception
        return null;
    }

    // TODO security : link to company
    @Transactional
    public void batchAddProducts(String companyId, List<Product> products) {
        final Company company = companyRepository.findOne(companyId);
        products.stream().forEach(p -> company.addProduct(p));
        productRepository.save(products);
    }

    // TODO security : link to company
    @Transactional
    public Product load(String productId) {
        return productRepository.findOne(productId);
    }
}

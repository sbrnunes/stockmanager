package org.snmco.stock.productmanager.repository;

import org.snmco.stock.productmanager.document.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    Page<Product> findAll(Pageable pageable);
}

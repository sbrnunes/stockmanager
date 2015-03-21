package org.snmco.stock.stockhandler.reppository;

import org.snmco.stock.stockhandler.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ProductRepository extends PagingAndSortingRepository<Product, String> {

    public Page<Product> findByCompany(String companyId, Pageable pageable);
}

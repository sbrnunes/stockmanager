package org.snmco.stock.productmanager.repository;


import org.snmco.stock.productmanager.document.Sell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SellRepository extends ElasticsearchRepository<Sell, String> {

    // TODO research elasticsearch criteria filter

    Page<Sell> findByCompanyId(String companyId, Pageable pageable);

    Page<Sell> findByCompanyIdAndProductId(String companyId, String productId, Pageable pageable);

    Page<Sell> findByCompanyIdAndCustomerId(String companyId, String customerId, Pageable pageable);

    Page<Sell> findByCompanyIdAndCustomerIdAndProductId(String companyId, String customerId, String productId, Pageable pageable);
}

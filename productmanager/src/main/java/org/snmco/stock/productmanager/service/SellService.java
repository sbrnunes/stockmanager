package org.snmco.stock.productmanager.service;

import org.snmco.stock.productmanager.document.Product;
import org.snmco.stock.productmanager.document.Sell;
import org.snmco.stock.productmanager.repository.SellRepository;
import org.snmco.stock.productmanager.search.SellSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SellService {

    @Autowired
    private SellRepository sellRepository;

    public Sell save(Sell sell) {
        sell.initDate();
        return sellRepository.save(sell);
    }

    public Page<Sell> findSells(String companyId, SellSearch sellSearch, int page, int size) {

        Pageable pageable = new PageRequest(page, size);

        if (sellSearch.isCustomerAndProduct()) {
            return sellRepository.findByCompanyIdAndCustomerIdAndProductId(companyId, sellSearch.getCustomerId(), sellSearch.getProductId(), pageable);
        } else if (sellSearch.isCustomer()) {
            return sellRepository.findByCompanyIdAndCustomerId(companyId, sellSearch.getCustomerId(), pageable);
        } else if (sellSearch.isProduct()) {
            return sellRepository.findByCompanyIdAndProductId(companyId, sellSearch.getProductId(), pageable);
        } else {
            return sellRepository.findByCompanyId(companyId, pageable);
        }
    }
}

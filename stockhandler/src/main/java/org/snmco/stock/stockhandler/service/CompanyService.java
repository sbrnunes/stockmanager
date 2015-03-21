package org.snmco.stock.stockhandler.service;

import org.snmco.stock.stockhandler.entity.Company;
import org.snmco.stock.stockhandler.reppository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Company load(String companyId) {
        return companyRepository.findOne(companyId);
    }

    @Transactional
    public void addCompany(Company company) {
        companyRepository.save(company);
    }
}

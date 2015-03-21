package org.snmco.stock.stockhandler.service;

import org.snmco.stock.stockhandler.entity.Company;
import org.snmco.stock.stockhandler.entity.Customer;
import org.snmco.stock.stockhandler.reppository.CompanyRepository;
import org.snmco.stock.stockhandler.reppository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional(readOnly = true)
    public Page<Customer> findByCompany(String companyId, int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return customerRepository.findByCompany(companyId, pageable);
    }

    // TODO security : link to company
    @Transactional(readOnly = true)
    public Customer load(String customerId) {
        return customerRepository.findOne(customerId);
    }

    // TODO security : link to company
    @Transactional
    public void addCustomer(String companyId, Customer customer) {
        Company company = companyRepository.findOne(companyId);
        company.addCustomer(customer);
    }
}

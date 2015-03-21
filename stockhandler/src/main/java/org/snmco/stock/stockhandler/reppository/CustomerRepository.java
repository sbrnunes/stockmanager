package org.snmco.stock.stockhandler.reppository;

import org.snmco.stock.stockhandler.entity.Company;
import org.snmco.stock.stockhandler.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

    Page<Customer> findByCompany(Company companyId, Pageable pageable);
}

package org.snmco.stock.stockhandler.reppository;

import org.snmco.stock.stockhandler.entity.Customer;
import org.snmco.stock.stockhandler.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {

}

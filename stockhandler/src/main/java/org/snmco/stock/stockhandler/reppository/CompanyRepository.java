package org.snmco.stock.stockhandler.reppository;

import org.snmco.stock.stockhandler.entity.Company;
import org.snmco.stock.stockhandler.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends PagingAndSortingRepository<Company, String> {

}

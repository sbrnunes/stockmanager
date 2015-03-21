package org.snmco.stock.stockhandler.controller;

import org.snmco.stock.stockhandler.entity.Customer;
import org.snmco.stock.stockhandler.entity.Product;
import org.snmco.stock.stockhandler.service.CustomerService;
import org.snmco.stock.stockhandler.service.ProductService;
import org.snmco.stock.stockhandler.util.CustomMessageCodeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @InitBinder(value = "customer")
    protected void initBinder(WebDataBinder binder) {
        binder.setMessageCodesResolver(new CustomMessageCodeResolver());
    }


    @RequestMapping(value="/{companyId}", method = RequestMethod.GET)
    public Page<Customer> list(@PathVariable String companyId,
                    @RequestParam(value = "page", defaultValue = "0") int page,
                    @RequestParam(value = "size", defaultValue = "10") int size) {
            return customerService.findByCompany(companyId, page, size);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public Customer load(@PathVariable String customerId) {
        // TODO security : load company from customer and verify has access to product
        return customerService.load(customerId);
    }

    @RequestMapping(value="/{companyId}",method = RequestMethod.POST)
    public void createCustomer(
            @PathVariable String companyId,
            @RequestBody() Customer customer) {
        customerService.addCustomer(companyId, customer);
    }


}

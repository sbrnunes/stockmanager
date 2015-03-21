package org.snmco.stock.stockhandler.controller;

import org.snmco.stock.stockhandler.entity.Company;
import org.snmco.stock.stockhandler.entity.Customer;
import org.snmco.stock.stockhandler.service.CompanyService;
import org.snmco.stock.stockhandler.util.CustomMessageCodeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @InitBinder(value = "company")
    protected void initBinder(WebDataBinder binder) {
        binder.setMessageCodesResolver(new CustomMessageCodeResolver());
    }


    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    public Customer load(@PathVariable String companyId) {
        return companyService.load(companyId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCompany(
            @RequestBody() Company company) {
        companyService.addCompany(company);
    }


}

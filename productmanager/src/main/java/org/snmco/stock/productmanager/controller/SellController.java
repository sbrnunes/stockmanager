package org.snmco.stock.productmanager.controller;

import org.snmco.stock.productmanager.document.Product;
import org.snmco.stock.productmanager.document.Sell;
import org.snmco.stock.productmanager.search.SellSearch;
import org.snmco.stock.productmanager.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @RequestMapping(value = "/companyId", method = RequestMethod.POST)
    public Page<Sell> listForProduct(@PathVariable String companyId,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size,
                              @RequestBody(required = true) SellSearch sellSearch) {
        return sellService.findSells(companyId, sellSearch, page, size);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Sell save(@RequestBody(required = true) @Valid Sell sell) {
        return sellService.save(sell);
    }
}

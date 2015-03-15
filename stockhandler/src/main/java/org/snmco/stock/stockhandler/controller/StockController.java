package org.snmco.stock.stockhandler.controller;

import org.snmco.stock.stockhandler.entity.Product;
import org.snmco.stock.stockhandler.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> list(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {
            return productService.listAll(page, size);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateStock(@RequestBody() Product product) {

         productService.updateStock(product.getId(), product.getStock());
    }


}

package org.snmco.stock.stockhandler.controller;

import org.snmco.stock.stockhandler.entity.Product;
import org.snmco.stock.stockhandler.service.ProductService;
import org.snmco.stock.stockhandler.util.CustomMessageCodeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private ProductService productService;

    @InitBinder(value = "product")
    protected void initBinder(WebDataBinder binder) {
        binder.setMessageCodesResolver(new CustomMessageCodeResolver());
    }


    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> list(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {
            return productService.listAll(page, size);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product load(@PathVariable String productId) {
        return productService.load(productId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateStock(@RequestBody() @Valid Product product) {
         productService.updateStock(product.getId(), product.getStock());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createStocks(@RequestBody() List<Product> products) {
        productService.batchAddProducts(products);
    }


}

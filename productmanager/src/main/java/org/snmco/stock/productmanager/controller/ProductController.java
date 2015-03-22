package org.snmco.stock.productmanager.controller;

import org.snmco.stock.productmanager.document.Product;
import org.snmco.stock.productmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> list(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size) {
        return productService.findProducts(page, size);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody(required = true) Product product) {
        productService.save(product);
    }

    @RequestMapping(value="/{productId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String productId)
    {
        productService.delete(productId);
    }
}

package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.ProductDetails;
import com.ylizma.stockmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public List<ProductDetails> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{code}")
    public ProductDetails findProductByCode(@PathVariable String code) {
        return productService.findByCode(code);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDetails product) {
        return productService.save(product);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDetails product, @PathVariable String code) {
        return productService.update(product, code);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String code) {
        return productService.delete(code);
    }
}

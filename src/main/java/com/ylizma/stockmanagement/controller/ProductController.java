package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.ProductDetails;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8081")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public Page<Product> getAllProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size) {
        return productService.findAll(page,size);
    }

    @GetMapping("/{code}")
    public ProductDetails findProductByCode(@PathVariable String code) {
        return productService.findByCode(code);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDetails product) throws ParseException {
        return productService.save(product);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDetails product, @PathVariable String code) throws ParseException {
        return productService.update(product, code);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String code) {
        return productService.delete(code);
    }

    @GetMapping("/warehouse/{id}")
    public List<ProductDetails> findByWareHouse(@PathVariable Long id) {
        return productService.findAllByWareHouseId(id);
    }
}

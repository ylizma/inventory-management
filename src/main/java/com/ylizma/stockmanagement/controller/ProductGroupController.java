package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import com.ylizma.stockmanagement.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productgroup")
public class ProductGroupController {

    @Autowired
    ProductGroupService productGroupService;

    @GetMapping("/all")
    java.util.List<ProductGroupDetails> getAllProductGroups() {
        return productGroupService.findAll();
    }

    @PostMapping("/add")
    ResponseEntity<Object> saveProductGroup(@RequestBody ProductGroupDetails productGroup) {
        return productGroupService.save(productGroup);
    }

    @GetMapping("/{code}")
    ProductGroupDetails getProductGroupByCode(@PathVariable String code) {
        return productGroupService.findByCode(code);
    }

    @PutMapping("/{code}")
    ResponseEntity<Object> updateProductGroup(@RequestBody ProductGroupDetails product, @PathVariable String code) {
        return productGroupService.update(product, code);
    }

    @DeleteMapping("/{code}")
    ResponseEntity<Object> deleteProductGroup(@PathVariable String code) {
        return productGroupService.delete(code);
    }
}

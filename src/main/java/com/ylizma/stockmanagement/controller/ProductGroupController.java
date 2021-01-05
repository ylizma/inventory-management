package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import com.ylizma.stockmanagement.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/productgroups")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductGroupController {

    @Autowired
    ProductGroupService productGroupService;

    @GetMapping("/all")
    public java.util.List<ProductGroupDetails> getAllProductGroups() {
        return productGroupService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveProductGroup(@RequestBody ProductGroupDetails productGroup) throws ParseException {
        return productGroupService.save(productGroup);
    }

    @GetMapping("/{code}")
    public ProductGroupDetails getProductGroupByCode(@PathVariable String code) {
        return productGroupService.findByCode(code);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Object> updateProductGroup(@RequestBody ProductGroupDetails product, @PathVariable String code) throws ParseException {
        return productGroupService.update(product, code);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Object> deleteProductGroup(@PathVariable String code) {
        System.out.println(code);
        return productGroupService.delete(code);
    }
}

package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.SupplierDetails;
import com.ylizma.stockmanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin(origins = "http://localhost:8081")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/{id}")
    public SupplierDetails findSupplierById(@PathVariable Long id){
        return supplierService.findById(id);
    }

    @GetMapping("/all")
    public java.util.List<SupplierDetails> getAllSuppliers(){
        return supplierService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveSupplier(@RequestBody SupplierDetails supplier) throws ParseException {
        return supplierService.save(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSupplier(@RequestBody SupplierDetails supplier,@PathVariable Long id) throws ParseException {
        return supplierService.update(supplier,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSupplier(@PathVariable Long id){
        return supplierService.delete(id);
    }

}

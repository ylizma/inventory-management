package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductDetails;
import com.ylizma.stockmanagement.model.Product;
import com.ylizma.stockmanagement.model.ProductGroup;
import com.ylizma.stockmanagement.model.Supplier;
import com.ylizma.stockmanagement.model.WareHouse;
import com.ylizma.stockmanagement.respository.ProductGroupRepository;
import com.ylizma.stockmanagement.respository.ProductRepository;
import com.ylizma.stockmanagement.respository.SupplierRepository;
import com.ylizma.stockmanagement.respository.WareHouseRepository;
import com.ylizma.stockmanagement.service.helper.DomainConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceI {

//    @Autowired
//    ProductRepository productRepository;
//    @Autowired
//    SupplierRepository supplierRepository;
//    @Autowired
//    WareHouseRepository wareHouseRepository;
//    @Autowired
//    ProductGroupRepository productGroupRepository;
//
//    @Autowired
//    DomainConversion domainConversion;
//
//
//
//
//    public ProductDetails findByCode(String code) {
//        return null;
//    }
//
//    public List<ProductDetails> findAll() {
//        List<ProductDetails> productList = new ArrayList<>();
//        productRepository.findAll().forEach(product -> {
//            ProductDetails p = new ProductDetails(product.getId(),product.getName(),product.getDescription(),product.getCode(),product.getMinStock(),product.getWareHouse().getId(),product.getProductGroup().getId(),product.getSupplier().getId());
//            productList.add(p);
//        });
//        return productList;
//    }
//
//    public ResponseEntity<Object> save(ProductDetails p) {
//        Product product = new Product();
//        Supplier supplier = supplierRepository.findById(p.getSupplier()).get();
//        WareHouse wareHouse = wareHouseRepository.findById(p.getWareHouse()).get();
//        ProductGroup productGroup = productGroupRepository.findById(p.getProductGroup()).get();
//        product.setMinStock(p.getMinStock());
//        product.setDescription(p.getDescription());
//        product.setCode(p.getCode());
//        product.setName(p.getName());
//        product.setProductGroup(productGroup);
//        product.setWareHouse(wareHouse);
//        product.setSupplier(supplier);
//        productRepository.save(product);
//        return ResponseEntity.ok(product);
//    }
//
//
//    public ResponseEntity<Object> update(ProductDetails p, String code) {
//        return null;
//    }
//
//    public ResponseEntity<Object> delete(String code) {
//        return null;
//    }
}

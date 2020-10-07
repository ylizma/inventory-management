package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.ProductGroupDetails;
import com.ylizma.stockmanagement.model.ProductGroup;
import com.ylizma.stockmanagement.respository.ProductGroupRepository;
import com.ylizma.stockmanagement.service.helper.DomainConversion;
import com.ylizma.stockmanagement.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductGroupServiceImpl implements ProductGroupService {

    @Autowired
    ProductGroupRepository productGroupRepository;

    @Autowired
    DomainConversion domainConversion;

    @Override
    public ProductGroupDetails findByCode(String code) {
        Optional<ProductGroup> productG = productGroupRepository.findProductGroupByCode(code);
        return productG.map(productGroup -> domainConversion.convertProductGroupToProductGroupDetails(productGroup)).orElse(null);
    }

    @Override
    public List<ProductGroupDetails> findAll() {
        List<ProductGroupDetails> groupDetailsList = new ArrayList<>();
        productGroupRepository.findAllByOrderByCreatedAtDesc().forEach(productGroup ->
                groupDetailsList.add(domainConversion.convertProductGroupToProductGroupDetails(productGroup)));
        return groupDetailsList;
    }

    @Override
    public ResponseEntity<Object> save(ProductGroupDetails p) throws ParseException {
        if (!productGroupRepository.findProductGroupByCode(p.getCode()).isPresent()) {
            ProductGroup productGroup = domainConversion.convertProductGroupDetailsToProduct(p);
            productGroup.setCreatedAt(DateFormatter.getCurrentDate());
            productGroup.setLastModified(DateFormatter.getCurrentDate());
            productGroupRepository.save(productGroup);
            return ResponseEntity.status(HttpStatus.CREATED).body(productGroup);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Product Group already exists !!");
        }
    }

    @Override
    public ResponseEntity<Object> update(ProductGroupDetails p, String code) throws ParseException {
        Optional<ProductGroup> productGroup = productGroupRepository.findProductGroupByCode(code);
        ProductGroup managedProduct = domainConversion.convertProductGroupDetailsToProduct(p);
        if (productGroup.isPresent()) {
            productGroup.get().setName(managedProduct.getName());
            productGroup.get().setActive(managedProduct.isActive());
            productGroup.get().setLastModified(DateFormatter.getCurrentDate());
            productGroupRepository.save(productGroup.get());
            return ResponseEntity.status(HttpStatus.OK).body(productGroup.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product group not found");
    }

    @Override
    public ResponseEntity<Object> delete(String code) {
        Optional<ProductGroup> managedProductGroup = productGroupRepository.findProductGroupByCode(code);
        if (managedProductGroup.isPresent()) {
            productGroupRepository.delete(managedProductGroup.get());
            return ResponseEntity.status(HttpStatus.OK).body("Product Group deleted !!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product group not found");
    }
}

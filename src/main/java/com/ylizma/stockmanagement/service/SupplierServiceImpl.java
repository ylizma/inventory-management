package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.SupplierDetails;
import com.ylizma.stockmanagement.model.Supplier;
import com.ylizma.stockmanagement.respository.SupplierRepository;
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
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    DomainConversion domainConversion;

    @Override
    public SupplierDetails findById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.map(value -> domainConversion.convertSupplierToSupplierDetails(value)).orElse(null);
    }

    @Override
    public List<SupplierDetails> findAll() {
        List<SupplierDetails> supplierList = new ArrayList<>();
        supplierRepository.findAll().forEach(supplier ->
                supplierList.add(domainConversion.convertSupplierToSupplierDetails(supplier)));
        return supplierList;
    }

    @Override
    public ResponseEntity<Object> save(SupplierDetails p) throws ParseException {
        Supplier supplier = domainConversion.convertSupplierDetailsToSupplier(p);
        supplier.setCreatedAt(DateFormatter.getCurrentDate());
        supplier.setLastModified(DateFormatter.getCurrentDate());
        supplierRepository.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplier);
    }

    @Override
    public ResponseEntity<Object> update(SupplierDetails p, Long id) throws ParseException {
        Optional<Supplier> managedSupplier = supplierRepository.findById(id);
        Supplier unmanagedSupplier = domainConversion.convertSupplierDetailsToSupplier(p);
        if (managedSupplier.isPresent()) {
            managedSupplier.get().setPhone(unmanagedSupplier.getPhone());
            managedSupplier.get().setFax(unmanagedSupplier.getFax());
            managedSupplier.get().setCompanyID(unmanagedSupplier.getCompanyID());
            managedSupplier.get().setCity(unmanagedSupplier.getCity());
            managedSupplier.get().setAddress(unmanagedSupplier.getAddress());
            managedSupplier.get().setName(unmanagedSupplier.getName());
            managedSupplier.get().setActive(unmanagedSupplier.isActive());
            managedSupplier.get().setLastModified(DateFormatter.getCurrentDate());
            supplierRepository.save(managedSupplier.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(managedSupplier);
        } else return ResponseEntity.status(500).body("Error");
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (supplier.isPresent()) {
            supplierRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Supplier Deleted !");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Suplier doesnt exist");
    }
}

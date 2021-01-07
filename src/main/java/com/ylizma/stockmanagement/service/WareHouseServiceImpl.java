package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.domain.WareHouseDetails;
import com.ylizma.stockmanagement.model.WareHouse;
import com.ylizma.stockmanagement.respository.WareHouseRepository;
import com.ylizma.stockmanagement.service.helper.DomainConversion;
import com.ylizma.stockmanagement.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Autowired
    DomainConversion domainConversion;

    @Override
    public List<WareHouseDetails> findAll() {
        List<WareHouseDetails> wareHouseDetailsList = new ArrayList<>();
        wareHouseRepository.findAll(Sort.by("createdAt").descending())
                .forEach(wareHouse -> wareHouseDetailsList.add(domainConversion.convertWareHouseToWarehousedeatils(wareHouse)));
        return wareHouseDetailsList;
    }

    @Override
    public List<WareHouseDetails> findByName(String name) {
        List<WareHouseDetails> wareHouseDetailsList = new ArrayList<>();
        wareHouseRepository.findWareHouseByNameContains(name)
                .forEach(wareHouse -> wareHouseDetailsList.add(domainConversion.convertWareHouseToWarehousedeatils(wareHouse)));
        return wareHouseDetailsList;
    }

    @Override
    public ResponseEntity<Object> save(WareHouseDetails p) throws ParseException {
        WareHouse wareHouse = domainConversion.convertWareHouseDetailsToWarehouse(p);
        wareHouse.setCreatedAt(DateFormatter.getCurrentDate());
        wareHouse.setLastModified(DateFormatter.getCurrentDate());
        wareHouseRepository.save(wareHouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(wareHouse);
    }

    @Override
    public ResponseEntity<Object> update(WareHouseDetails p, Long id) throws ParseException {
        Optional<WareHouse> wareHouse = wareHouseRepository.findById(id);
        if (wareHouse.isPresent()) {
            wareHouse.get().setName(p.getName());
            wareHouse.get().setDescription(p.getDescription());
            wareHouse.get().setActive(p.getActive());
            wareHouse.get().setCity(p.getCity());
            wareHouse.get().setLastModified(DateFormatter.getCurrentDate());
            wareHouseRepository.save(wareHouse.get());
            return ResponseEntity.status(HttpStatus.OK).body(wareHouse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("WareHouse not found !");
    }

    @Override
    public ResponseEntity<Object> delete(Long id) {
        Optional<WareHouse> wareHouse = wareHouseRepository.findById(id);
        if (wareHouse.isPresent()) {
            wareHouseRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Warehouse deleted !");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Warehouse not found !");
        }
    }

    @Override
    public List<?> numberOfProductsByWareHouse() {
        return wareHouseRepository.numberOfProductsByWareHouse();
    }
}

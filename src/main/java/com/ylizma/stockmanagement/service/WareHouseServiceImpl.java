package com.ylizma.stockmanagement.service;

import com.ylizma.stockmanagement.model.WareHouse;
import com.ylizma.stockmanagement.respository.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Override
    public List<WareHouse> findAll() {
        return wareHouseRepository.findAll();
    }

    @Override
    public List<WareHouse> findByName(String name) {
        return wareHouseRepository.findWareHouseByName(name);
    }

    @Override
    public ResponseEntity<Object> save(WareHouse p) {
        wareHouseRepository.save(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @Override
    public ResponseEntity<Object> update(WareHouse p, Long id) {
        Optional<WareHouse> wareHouse = wareHouseRepository.findById(id);
        if (wareHouse.isPresent()) {
            wareHouse.get().setName(p.getName());
            wareHouse.get().setDescription(p.getDescription());
            wareHouse.get().setActive(p.getActive());
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
}

package com.ylizma.stockmanagement.controller;

import com.ylizma.stockmanagement.domain.WareHouseDetails;
import com.ylizma.stockmanagement.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/warehouses")
@CrossOrigin(origins = "http://localhost:8081")
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @GetMapping("/all")
    public List<WareHouseDetails> getAllWareHouses() {
        return wareHouseService.findAll();
    }

    @GetMapping("/{name}")
    public List<WareHouseDetails> findWareHouseByName(@PathVariable String name) {
        return wareHouseService.findByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveWareHouse(@RequestBody WareHouseDetails wareHouse) throws ParseException {
        return wareHouseService.save(wareHouse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWareHouse(@RequestBody WareHouseDetails wareHouse, @PathVariable Long id) throws ParseException {
        return wareHouseService.update(wareHouse, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWareHouse(@PathVariable Long id) {
        return wareHouseService.delete(id);
    }

    @GetMapping("/chart")
    public List<?> numberOfProductsByWareHouse(){
        return wareHouseService.numberOfProductsByWareHouse();
    }
}

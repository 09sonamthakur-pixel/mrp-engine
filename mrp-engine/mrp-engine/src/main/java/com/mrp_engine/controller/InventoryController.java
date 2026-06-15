package com.mrp_engine.controller;

import com.mrp_engine.entity.InventoryStatus;
import com.mrp_engine.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;
    @PostMapping
    public InventoryStatus createInventory(@RequestBody InventoryStatus inventory){
        return inventoryRepository.save(inventory);
    }
    @GetMapping
    public List<InventoryStatus> getAllInventory(){
        return inventoryRepository.findAll();
    }
    @GetMapping("/{id}")
    public InventoryStatus getById(@PathVariable Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryRepository.deleteById(id);
        return "Inventory Deleted Successfully";
    }
}

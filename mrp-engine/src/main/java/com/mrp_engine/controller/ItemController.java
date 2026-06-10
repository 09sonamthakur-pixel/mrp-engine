package com.mrp_engine.controller;

import com.mrp_engine.entity.Item;
import com.mrp_engine.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;
    @PostMapping
    public Item createItem(@RequestBody Item item){
        return itemRepository.save(item);
    }
    @GetMapping
    public List<Item> getALLItems(){
        return itemRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id){
       return itemRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "Item Deleted Successfully";
    }
}



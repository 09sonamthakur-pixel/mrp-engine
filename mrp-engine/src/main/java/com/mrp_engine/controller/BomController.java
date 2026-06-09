package com.mrp_engine.controller;

import com.mrp_engine.entity.BomLink;
import com.mrp_engine.repository.BomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bom")
public class BomController {
    @Autowired
    private BomRepository bomRepository;
     @PostMapping
    public BomLink createbom(@RequestBody BomLink bom){
         return bomRepository.save(bom);

}
    @GetMapping
    public List<BomLink> getAllBom() {
        return bomRepository.findAll();
    }
    @GetMapping("/{id}")
    public BomLink getBomById(@PathVariable Long id) {
        return bomRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteBom(@PathVariable Long id) {
        bomRepository.deleteById(id);
        return "BOM Deleted Successfully";
    }
}

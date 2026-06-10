package com.mrp_engine.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mrp")
public class MrpController {
    @GetMapping("/run")
    public String runMrp(){
        int demand=100;
        int avaliableStock=30;
        int requiredMaterial=demand-avaliableStock;
        return "Required material="+requiredMaterial;

    }
}

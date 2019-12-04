package com.blazejknie.myprojects.computer_shop.controller;

import com.blazejknie.myprojects.computer_shop.model.RamMemory;
import com.blazejknie.myprojects.computer_shop.repository.RamMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/ram-memories")
public class RamMemoryController {

    private RamMemoryRepository ramMemoryRepository;

    public RamMemoryController(@Autowired RamMemoryRepository ramMemoryRepository) {
        this.ramMemoryRepository = ramMemoryRepository;
    }

    @GetMapping
    public List<RamMemory> getAllRamMemoryies() {
        return ramMemoryRepository.findAll();
    }

    @PostMapping
    public RamMemory addRamMemory(@RequestBody RamMemory ramMemory) {
        return ramMemoryRepository.save(ramMemory);
    }

}

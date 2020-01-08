package com.blazejknie.myprojects.computer_shop.controller;

import com.blazejknie.myprojects.computer_shop.model.RAMemory;
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
    public List<RAMemory> getAllRamMemoryies() {
        return ramMemoryRepository.findAll();
    }

    @PostMapping
    public RAMemory addRamMemory(@RequestBody RAMemory RAMemory) {
        return ramMemoryRepository.save(RAMemory);
    }

}

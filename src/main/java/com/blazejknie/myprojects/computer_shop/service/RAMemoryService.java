package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.RAMemory;
import com.blazejknie.myprojects.computer_shop.repository.RamMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RAMemoryService {
    private RamMemoryRepository ramRepository;

    public RAMemoryService(RamMemoryRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    public List<RAMemory> getAll() {
        return ramRepository.findAll();
    }

    public RAMemory getById(Long id) throws NoSuchElementException {
        return ramRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found RAMemory with id = %d", id)));
    }

    public RAMemory save(RAMemory ram) {
        return ramRepository.save(ram);
    }

    public RAMemory update(Long id, RAMemory ram) {
        RAMemory raMemory = ramRepository.findById(id)
                .map(memory -> {
                    memory.setCapacityInGB(ram.getCapacityInGB());
                    memory.setFrequencyInGhz(ram.getFrequencyInGhz());
                    return memory;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("not found RAMemory with id = %d", id)));
        return raMemory;
    }
}

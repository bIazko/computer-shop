package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.MotherBoard;
import com.blazejknie.myprojects.computer_shop.repository.MotherboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MotherboardService {
    private MotherboardRepository motherboardRepository;

    public MotherboardService(MotherboardRepository motherboardRepository) {
        this.motherboardRepository = motherboardRepository;
    }

    public List<MotherBoard> getAll() {
        return motherboardRepository.findAll();
    }

    public MotherBoard getById(Long id) {
        return motherboardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found motherboard with id = %d", id)));
    }

    public MotherBoard save(MotherBoard motherBoard) {
        return motherboardRepository.save(motherBoard);
    }

    public MotherBoard update(Long id, MotherBoard motherBoard) {
        return motherboardRepository.findById(id)
                .map(mb -> {
                    mb.setMotherboardChipset(motherBoard.getMotherboardChipset());
                    mb.setNumberOfMemorySocket(motherBoard.getNumberOfMemorySocket());
                    mb.setProcessorSocket(motherBoard.getProcessorSocket());
                    mb.setSupportedMemory(motherBoard.getSupportedMemory());
                    mb.setBrand(motherBoard.getBrand());
                    mb.setModel(motherBoard.getModel());
                    mb.setName(motherBoard.getName());
                    return mb;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("not found motherboard with id = %d", id)));
    }

    public void delete(Long id) {
        MotherBoard motherBoard = motherboardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found motherboard with id = %d", id)));
        motherboardRepository.delete(motherBoard);
    }
}

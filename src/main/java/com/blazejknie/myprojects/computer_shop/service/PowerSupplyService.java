package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.PowerSupply;
import com.blazejknie.myprojects.computer_shop.repository.PowerSupplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PowerSupplyService {
    private PowerSupplyRepository repository;

    public PowerSupplyService(PowerSupplyRepository repository) {
        this.repository = repository;
    }

    public List<PowerSupply> getAll() {
        return repository.findAll();
    }

    public PowerSupply getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found power supply with id = %d", id)));
    }

    public PowerSupply save(PowerSupply powerSupply) {
        return repository.save(powerSupply);
    }

    public PowerSupply update(Long id, PowerSupply powerSupply) {
        return repository.findById(id)
                .map(ps -> {
                    ps.setBrand(powerSupply.getBrand());
                    ps.setModel(powerSupply.getModel());
                    ps.setName(powerSupply.getName());
                    ps.setRegistrationDate(powerSupply.getRegistrationDate());
                    ps.setPerformanceCertificate(powerSupply.getPerformanceCertificate());
                    ps.setPowerInWatts(powerSupply.getPowerInWatts());
                    return ps;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("not found motherboard with id = %d", id)));
    }

    public void delete(Long id) {
        PowerSupply powerSupplybyId = getById(id);
        repository.delete(powerSupplybyId);
    }
}

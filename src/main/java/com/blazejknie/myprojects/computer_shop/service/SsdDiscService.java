package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.SsdDisc;
import com.blazejknie.myprojects.computer_shop.repository.SsdDiscRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SsdDiscService {
    private SsdDiscRepository repository;

    public SsdDiscService(SsdDiscRepository repository) {
        this.repository = repository;
    }

    public List<SsdDisc> getAll() {
        return repository.findAll();
    }

    public SsdDisc getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found ssd disc with id = %d", id)));
    }

    public SsdDisc save(SsdDisc disc) {
        return repository.save(disc);
    }

    public SsdDisc update(Long id, SsdDisc disc) {
        return repository.findById(id)
                .map(sd -> {
                    sd.setName(disc.getName());
                    sd.setBrand(disc.getBrand());
                    sd.setModel(disc.getModel());
                    sd.setType(disc.getType());
                    sd.setCapacity(disc.getCapacity());
                    sd.setDiscInterface(disc.getDiscInterface());
                    sd.setReadSpeed(disc.getReadSpeed());
                    sd.setRegistrationDate(disc.getRegistrationDate());
                    sd.setWriteSpeed(disc.getWriteSpeed());
                    return sd;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("not found ssd disc with id = %d", id)));
    }

    public void delete(Long id) {
        SsdDisc ssdDiscbyId = getById(id);
        repository.delete(ssdDiscbyId);
    }
}

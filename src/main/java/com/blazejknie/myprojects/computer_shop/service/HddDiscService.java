package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.HddDisc;
import com.blazejknie.myprojects.computer_shop.repository.HddDiscRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HddDiscService {
    private HddDiscRepository hddDiscRepository;

    public HddDiscService(HddDiscRepository hddDiscRepository) {
        this.hddDiscRepository = hddDiscRepository;
    }

    public List<HddDisc> getAll() {
        return hddDiscRepository.findAll();
    }

    public HddDisc getById(Long id) {
        return hddDiscRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found hdd disc with id = %d", id)));
    }

    public HddDisc save(HddDisc hddDisc) {
        return hddDiscRepository.save(hddDisc);
    }

    public HddDisc update(Long id, HddDisc hddDisc) {
        return hddDiscRepository.findById(id)
                .map(hd -> {
                    hd.setCacheMemoryInGB(hddDisc.getCacheMemoryInGB());
                    hd.setRotationSpeedInRpm(hddDisc.getRotationSpeedInRpm());
                    return hd;
                }).orElseThrow(() -> new NoSuchElementException(String.format("not found hard drive with id = %d", id)));
    }

    public void delete(Long id) {
        HddDisc hddDisc = hddDiscRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found hard drive with id = %d", id)));
        hddDiscRepository.delete(hddDisc);
    }
}

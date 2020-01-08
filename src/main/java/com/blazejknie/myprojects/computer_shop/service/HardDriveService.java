package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.HardDrive;
import com.blazejknie.myprojects.computer_shop.repository.HardDriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HardDriveService {
    private HardDriveRepository hardDriveRepository;

    public HardDriveService(HardDriveRepository hardDriveRepository) {
        this.hardDriveRepository = hardDriveRepository;
    }

    public List<HardDrive> getAll() {
        return hardDriveRepository.findAll();
    }

    public HardDrive getById(Long id) {
        return hardDriveRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found hard drive with id = %d", id)));
    }

    public HardDrive save(HardDrive hardDrive) {
        return hardDriveRepository.save(hardDrive);
    }

    public HardDrive update(Long id, HardDrive hardDrive) {
        return hardDriveRepository.findById(id)
                .map(hd -> {
                    hd.setCapacity(hardDrive.getCapacity());
                    hd.setDiscInterface(hardDrive.getDiscInterface());
                    hd.setReadSpeed(hardDrive.getReadSpeed());
                    hd.setType(hardDrive.getType());
                    hd.setWriteSpeed(hardDrive.getWriteSpeed());
                    return hd;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("not found hard drive with id = %d", id)));
    }

    public void delete(Long id) {
        HardDrive hardDrive = hardDriveRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found hard drive with id = %d", id)));
        hardDriveRepository.delete(hardDrive);
    }
}

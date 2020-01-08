package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.Processor;
import com.blazejknie.myprojects.computer_shop.repository.ProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProcessorService {
    private ProcessorRepository processorRepository;
    @Autowired
    public ProcessorService(ProcessorRepository processorRepository) {
        this.processorRepository = processorRepository;
    }


    public List<Processor> getAll() {
        return processorRepository.findAll();
    }

    public Optional<Processor> getById(long id) throws NoSuchElementException {
        return processorRepository.findById(id);
    }

    public Processor save(Processor processor) {
        return processorRepository.save(processor);
    }

    public Processor update(Long id, Processor processor) throws NoSuchElementException {
        return processorRepository.findById(id)
                .map(p ->{
                    p.setCpuFrequencyInGhz(processor.getCpuFrequencyInGhz());
                    p.setBrand(processor.getBrand());
                    p.setModel(processor.getModel());
                    p.setName(processor.getName());
                    p.setRegistrationDate(processor.getRegistrationDate());
                    return p;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("not found processor with id = %d", id)));

    }

    public void deleteProcesor(Long id) throws NoSuchElementException {
        Processor processor = processorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("not found processor with id = %d", id)));
        processorRepository.delete(processor);
    }
}

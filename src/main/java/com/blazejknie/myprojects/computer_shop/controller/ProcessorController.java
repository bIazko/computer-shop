package com.blazejknie.myprojects.computer_shop.controller;

import com.blazejknie.myprojects.computer_shop.model.Processor;
import com.blazejknie.myprojects.computer_shop.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/processors")
public class ProcessorController {

    private ProcessorService processorService;
    @Autowired
    public ProcessorController(ProcessorService processorService) {
        this.processorService = processorService;
    }

    @GetMapping
    public ResponseEntity<List<Processor>> getAllProcessor() {
        return ResponseEntity.ok(processorService.getAll());
    }

    @PostMapping
    public ResponseEntity<Processor> addProcessor(@RequestBody Processor processor) {
        return ResponseEntity.ok(processorService.save(processor));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Processor> updateProcessor(@RequestBody @Valid Processor processor,
                                                     @PathVariable("id") Long id) {
       return ResponseEntity.ok(processorService.update(id,processor));

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProcessor(@PathVariable long id) {
        processorService.deleteProcesor(id);
    }


}

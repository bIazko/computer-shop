package com.blazejknie.myprojects.computer_shop.controller;

import com.blazejknie.myprojects.computer_shop.model.GraphicCard;
import com.blazejknie.myprojects.computer_shop.service.GraphicCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/graphic-cards")
public class GraphicCardController {
    private GraphicCardService service;
    @Autowired
    public GraphicCardController(GraphicCardService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<GraphicCard>> getAllGraphicCards() {
        return ResponseEntity.ok(this.service.getAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<GraphicCard> getGraphicCardById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @PostMapping
    public ResponseEntity<GraphicCard> addGraphicCard(@RequestBody GraphicCard graphicCard){
        return ResponseEntity.ok(service.save(graphicCard));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GraphicCard> updateGraphicCard(@PathVariable Long id,
                                                         @RequestBody GraphicCard graphicCard) {
        return ResponseEntity.ok(service.update(id, graphicCard));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeGraphicCard(@PathVariable Long id) {
        service.deleteGraphicCard(id);
    }

}

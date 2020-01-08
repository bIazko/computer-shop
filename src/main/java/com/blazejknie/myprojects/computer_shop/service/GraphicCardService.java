package com.blazejknie.myprojects.computer_shop.service;

import com.blazejknie.myprojects.computer_shop.model.GraphicCard;
import com.blazejknie.myprojects.computer_shop.repository.GraphicCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class GraphicCardService {
    private GraphicCardRepository graphicCardRepository;

    @Autowired
    public GraphicCardService(GraphicCardRepository graphicCardRepository) {
        this.graphicCardRepository = graphicCardRepository;
    }

    public List<GraphicCard> getAll() {
        return graphicCardRepository.findAll();
    }

    public GraphicCard getById(Long id) throws NoSuchElementException {
        return graphicCardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Not found graphic cord with id = %d", id)));
    }

    public GraphicCard save(GraphicCard graphicCard) {
        return graphicCardRepository.save(graphicCard);
    }

    public GraphicCard update(Long id, GraphicCard graphicCard) throws NoSuchElementException {
        return graphicCardRepository.findById(id)
                .map(optionalCard -> {
                    optionalCard.setChipsetModel(graphicCard.getChipsetModel());
                    optionalCard.setChipsetName(graphicCard.getChipsetName());
                    optionalCard.setConnectorType(graphicCard.getConnectorType());
                    optionalCard.setCoreClockInMhz(graphicCard.getCoreClockInMhz());
                    optionalCard.setMemoryCapacityinMB(graphicCard.getMemoryCapacityinMB());
                    optionalCard.setMemoryClockInMhz(graphicCard.getMemoryClockInMhz());
                    return optionalCard;
                })
                .orElseThrow(() -> new NoSuchElementException(String.format("Not found graphic cord with id = %d", id)));
    }

    public void deleteGraphicCard(Long id)throws NoSuchElementException {
        GraphicCard graphicCard = graphicCardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Not found graphic cord with id = %d", id)));
        graphicCardRepository.delete(graphicCard);
    }
}

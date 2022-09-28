package com.amefastforward.cardapi.controller;

import com.amefastforward.cardapi.controller.request.CreateCardRequest;
import com.amefastforward.cardapi.controller.request.CreateOriginRequest;
import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.model.Origin;
import com.amefastforward.cardapi.service.OriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/origin")
public class OriginController {

    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    private final OriginService originService;

    public OriginController(OriginService originService) {
        this.originService = originService;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/health")
    public String health() {
        LOG.info("avaliando saude da aplicação");
        return "Ok";
    }

    @GetMapping("{id}")
    public Object findById(@PathVariable("id") int id) {
        LOG.info("Iniciando busca de Origin com id [{}]", id);

        var origin = originService.findById(id);
        if (origin.isPresent()) {
            return origin.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Origin não encontrado");
    }

    @GetMapping("/all")
    public List<Origin> findAll(){
        LOG.info("Iniciando a busca de todos os Origins");
        return originService.findAll();
    }

    @PostMapping
    public Origin createOrigin(@RequestBody CreateOriginRequest createOriginRequest) {
        LOG.info("Iniciando criação de Origin com nome [{}]", createOriginRequest.getName());
        return originService.createOrigin(createOriginRequest);
    }

}

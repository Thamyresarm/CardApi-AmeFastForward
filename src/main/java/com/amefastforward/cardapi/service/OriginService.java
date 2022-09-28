package com.amefastforward.cardapi.service;

import com.amefastforward.cardapi.controller.request.CreateOriginRequest;
import com.amefastforward.cardapi.model.Origin;
import com.amefastforward.cardapi.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OriginService {

    private final OriginRepository originRepository;

    @Autowired
    public OriginService(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    public Optional<Origin> findById(int id) {
        return originRepository.findById(id);
    }

    public Origin createOrigin(CreateOriginRequest createOriginRequest){
        var origin = new Origin();

        origin.setName(createOriginRequest.getName());
        origin.setDescription(createOriginRequest.getDescription());
        origin.setCreator(createOriginRequest.getCreator());
        origin.setCreatedAt(LocalDateTime.now());
        origin.setUpdatedAt(LocalDateTime.now());

        return originRepository.save(origin);
    }

    public List<Origin> findAll() {
        return originRepository.findAll();
    }
}

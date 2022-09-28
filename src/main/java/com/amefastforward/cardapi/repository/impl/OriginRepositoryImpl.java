package com.amefastforward.cardapi.repository.impl;

import com.amefastforward.cardapi.exception.InvalidEntityException;
import com.amefastforward.cardapi.model.Origin;
import com.amefastforward.cardapi.repository.OriginRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OriginRepositoryImpl implements OriginRepository {

    private final List<Origin> origins;

    public OriginRepositoryImpl() {
        origins = new ArrayList<>();

        Origin origin = new Origin();
        origin.setId(1);
        origin.setName("Teste");
        origin.setDescription("Primeiro Teste");
        origin.setCreator("Thamyres");
        origin.setCreatedAt(LocalDateTime.now());
        origin.setUpdatedAt(LocalDateTime.now());

        origins.add(origin);
    }

    @Override
    public Optional<Origin> findById(int id) {
        return origins.stream().filter(origin -> origin.getId() == id).findFirst();
    }

    @Override
    public Origin save(Origin origin) {
        var originFound = origins.stream().filter(originInList -> originInList.getName().equalsIgnoreCase(origin.getName())).findFirst();

        if(originFound.isPresent()){
            throw new InvalidEntityException("Nome [ " + origin.getName() +" ] já existente!");
        }
        origin.setId(origins.size() + 1);
        origins.add(origin);
        return origin;
    }

    @Override
    public List<Origin> findAll() {
        return origins.stream().toList();
    }
}

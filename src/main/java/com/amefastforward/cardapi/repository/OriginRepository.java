package com.amefastforward.cardapi.repository;

import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.model.Origin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OriginRepository {

    Optional<Origin> findById(int id);

    Origin save(Origin origin);

    List<Origin> findAll();
}

package com.amefastforward.cardapi.repository;

import com.amefastforward.cardapi.model.Card;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CardRepository {

    Optional<Card> findById(int id);

}

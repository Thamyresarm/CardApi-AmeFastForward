package com.amefastforward.cardapi.repository.impl;

import com.amefastforward.cardapi.exception.InvalidEntityException;
import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.repository.CardRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cards;

    public CardRepositoryImpl() {
        cards = new ArrayList<>();

        var card = new Card();
        card.setId(1);
        card.setName("Iron Man");
        card.setDescription("Tony Stark");
        card.setStrength(5);
        card.setSpeed(7);
        card.setSkill(7);
        card.setIntellect(8);
        card.setImageUrl("url_Iron_Man");
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        cards.add(card);
    }

    @Override
    public Optional<Card> findById(int id) {
        return cards.stream().filter(card -> card.getId() == id).findFirst();
    }

    @Override
    public Card save(Card card) {
        var cardFoud = cards.stream().filter(cardInList -> cardInList.getName().equalsIgnoreCase(card.getName())).findFirst();

        if(cardFoud.isPresent()){
            throw new InvalidEntityException("Nome [ " + card.getName() +" ] já existente!");
        }
        card.setId(cards.size() + 1);
        cards.add(card);
        return card;
    }


}

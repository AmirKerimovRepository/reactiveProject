package com.meaWallet.reactiveProject.service;

import com.meaWallet.reactiveProject.domain.Card;
import com.meaWallet.reactiveProject.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Mono<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public Flux<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Mono<Card> addCard(Card card) {
        return cardRepository.save(card);

    }

    public Mono<Card> updateCard(Card card) {
        return cardRepository.save(card);
    }

    public void deleteByID(Long id) {
        cardRepository.deleteById(id);
    }

}

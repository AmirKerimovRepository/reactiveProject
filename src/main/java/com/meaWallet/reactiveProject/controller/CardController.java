package com.meaWallet.reactiveProject.controller;

import com.meaWallet.reactiveProject.domain.Card;
import com.meaWallet.reactiveProject.domain.CardStatus;
import com.meaWallet.reactiveProject.dto.CardDto;
import com.meaWallet.reactiveProject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/cards")
public class CardController {


    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(value = "/{id}")
    public Mono<Card> getMovieById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @GetMapping
    public Flux<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/card-delete{id}")
    public void deleteCard(@PathVariable("id") Long id) {
        cardService.deleteByID(id);
    }

    @ModelAttribute
    @GetMapping("/card-add")
    public String addCardForm(@RequestBody CardDto cardDto, Model model) {
        model.addAttribute("cardNumber", cardDto.getCardNumber());
        model.addAttribute("ownerName", cardDto.getCardOwnerName());
        model.addAttribute("ownerSurname", cardDto.getCardOwnerSurname());
        return "add-card";
    }

    @PostMapping("/card-add")
    public String addCard(@RequestBody CardDto cardDto) {
        Card card = cardDto.convertToEntity();
        cardService.addCard(card);
        card.setCardStatuses(Collections.singleton(CardStatus.ACTIVE));
        return "redirect:/api/v1/cards/";
    }

    @ModelAttribute
    @GetMapping("/card-update{id}")
    public String updateRequestForm(@PathVariable("id") Long id, Model model, CardDto cardDto) {
        Mono<Card> card = cardService.getCardById(id);
        model.addAttribute("cardNumber", cardDto.getCardNumber());
        model.addAttribute("ownerName", cardDto.getCardOwnerName());
        model.addAttribute("ownerSurname", cardDto.getCardOwnerSurname());
        return "update-card";
    }

    @PostMapping("/update-card")
    public String updateRequest(CardDto cardDto) {
        Card card = cardDto.convertToEntity();
        cardService.updateCard(card);
        card.setCardStatuses(Collections.singleton(CardStatus.UPDATED));
        return "redirect:/api/v1/cards/";
    }


}

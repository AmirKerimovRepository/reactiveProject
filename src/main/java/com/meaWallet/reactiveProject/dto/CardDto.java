package com.meaWallet.reactiveProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meaWallet.reactiveProject.domain.Card;
import com.meaWallet.reactiveProject.domain.CardStatus;
import lombok.Data;

import java.util.Collections;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CardDto {

    private Long id;
    private String cardNumber;
    private String cardOwnerName;
    private String cardOwnerSurname;
    private CardStatus cardStatus;

    public Card convertToEntity() {
        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCardOwnerName(cardOwnerName);
        card.setCardOwnerSurname(cardOwnerSurname);
        card.setCardStatuses(Collections.singleton(cardStatus));
        return card;
    }

    public static CardDto convertToCardDto(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardOwnerName(card.getCardOwnerName());
        cardDto.setCardOwnerSurname(card.getCardOwnerSurname());
        return cardDto;
    }

}

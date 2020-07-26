package com.meaWallet.reactiveProject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @Column(name = "card_id")
    private Long id;

    @Column(name = "cardNumber")
    @NotBlank
    private String cardNumber;

    @Column(name = "ownerName")
    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "\\p{IsLatin}+(?:['\\-]\\p{IsLatin}+)*|\\d+", flags = Pattern.Flag.UNICODE_CASE) // Latin characters only
    private String cardOwnerName;

    @Column(name = "ownerSurname")
    @NotBlank
    @Size(min = 2, max = 30)
    @Pattern(regexp = "\\p{IsLatin}+(?:['\\-]\\p{IsLatin}+)*|\\d+", flags = Pattern.Flag.UNICODE_CASE) // Latin characters only
    private String cardOwnerSurname;

    @NotNull
    @ElementCollection(targetClass = CardStatus.class , fetch = FetchType.EAGER)
    @CollectionTable(name = "card_status", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    private Set<CardStatus> cardStatuses;


}

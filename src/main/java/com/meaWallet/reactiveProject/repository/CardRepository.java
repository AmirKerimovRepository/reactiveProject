package com.meaWallet.reactiveProject.repository;

import com.meaWallet.reactiveProject.domain.Card;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CardRepository extends ReactiveCrudRepository<Card,Long > {
}


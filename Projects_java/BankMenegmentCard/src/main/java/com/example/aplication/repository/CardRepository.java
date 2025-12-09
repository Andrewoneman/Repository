package com.example.aplication.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.aplication.entity.Card;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CardRepository extends R2dbcRepository<Card, Long>{
	
	//find card owner in pagination
	Flux<Card> findByUserId(Long userId, Pageable pageable);
	
	//find card in ID and user (check owner)
	Mono<Card> findByIdAndUserId(Long id, Long userId);
	
	//all cards (for Administrator only)
	Flux<Card> findAllUserCard(Pageable pageable);
	
	//find in status
	Flux<Card> findByStatus(Card.CardStatus status);
}

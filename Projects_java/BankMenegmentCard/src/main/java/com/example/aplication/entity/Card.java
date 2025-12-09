package com.example.aplication.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	@Id
	private Long id;
	private String encriptedCardNumbers; //encrypt pass
	private String ownerName;
	private LocalDate expiryDate;
	private CardStatus status;
	private Double balance = 0.0;
	private Long userId; // owner card
	
	public enum CardStatus {
		ACTIVE, BLOCKED, EXPIRED
	}
	
	// checking card activity
	public boolean isActive() {
		return status == CardStatus.ACTIVE && !isExpired();
	}
	
	// checking expired card
	public boolean isExpired() {
		return expiryDate.isBefore(LocalDate.now());
	}
}

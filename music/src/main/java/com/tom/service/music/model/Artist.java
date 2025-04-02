package com.tom.service.music.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artist")
public class Artist {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false, updatable = true, unique = false)
	private String name;
	
}

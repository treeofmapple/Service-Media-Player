package com.tom.service.music.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Album {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "title", nullable = false, updatable = true, unique = false)
	private String title;
	
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = true, updatable = true, unique = false)
	private Artist artistId;

	@Column(name = "release_date", nullable = true, updatable = true, unique = false)
	private LocalDate releaseDate;
	
}

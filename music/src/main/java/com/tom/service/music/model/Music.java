package com.tom.service.music.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "music")
public class Music {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "title", nullable = false, updatable = true, unique = false)
	private String title;
	
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = true, updatable = true, unique = false)
    private Artist artistId;
	
    @ManyToOne
    @JoinColumn(name = "album_id", nullable = true, updatable = true, unique = false)
	private Album albumId;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = true, updatable = true, unique = false)
	private Genre genreId;
	
	@Column(name = "duration_time", nullable = true, updatable = true, unique = false)
	private Duration durationTime;
	
	@Column(name = "release_date", nullable = true, updatable = true, unique = false)
	private LocalDate releaseDate;

	@Column(name = "upload_date", nullable = false, updatable = false, unique = false)
	private LocalDateTime uploadDate;
	
	@Column(name = "file_url", nullable = false, updatable = true, unique = false)
	private String fileUrl;
	
	@PrePersist
	private void prePeresist() {
		this.uploadDate = LocalDateTime.now();
	}
	
}

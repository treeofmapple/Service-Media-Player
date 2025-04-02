package com.tom.service.music.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlbumResponse(
		
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "long"
                )
		Long id,
		
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do álbum",
                example = "A Night at the Opera")
		String title,
		
		
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do artista",
                example = "Queen")
		String artist,
		
		
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                format = "date",
                description = "Data de lançamento do Album",
                example = "1975-10-31")
		LocalDate releaseDate
		
		) {
	
}

package com.tom.service.music.request;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record MusicResponse(

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Título da música",
                example = "Bohemian Rhapsody")
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
                description = "Nome do álbum",
                example = "A Night at the Opera")
        String album,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Gênero musical",
                example = "Rock")
        String genre,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                format = "duration",
                description = "Duração da música",
                example = "PT5M55S")
        Duration duration,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                format = "date",
                description = "Data de lançamento da música",
                example = "1975-10-31")
        LocalDate releaseDate,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                format = "date-time",
                description = "Data e hora do upload",
                example = "2023-08-15T14:30:00")
        LocalDateTime uploadDate,

        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "URL do arquivo de música",
                example = "https://example.com/music/bohemian.mp3")
        String fileUrl

) { }

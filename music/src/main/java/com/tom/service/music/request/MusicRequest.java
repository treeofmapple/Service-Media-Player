package com.tom.service.music.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MusicRequest(

        @NotNull(message = "O título não pode ser nulo")
        @NotBlank(message = "O título não pode estar em branco")
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
                format = "date",
                description = "Data de lançamento da música",
                example = "1975-10-31")
        LocalDate releaseDate

) { }

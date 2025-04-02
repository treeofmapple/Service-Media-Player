package com.tom.service.music.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ArtistRequest(
		
        @NotNull(message = "O Nome do artista não pode ser nulo")
        @NotBlank(message = "O Nome do artista não pode estar em branco")
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Nome do artista",
                example = "Queen")
		String name
		
		) {

}

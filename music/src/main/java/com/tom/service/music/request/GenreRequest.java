package com.tom.service.music.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GenreRequest(
		
        @NotNull(message = "O Genero musical não pode ser nulo")
        @NotBlank(message = "O Genero musical não pode estar em branco")
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Gênero musical",
                example = "Rock")
		String name
		
		) {

}

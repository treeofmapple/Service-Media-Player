package com.tom.service.music.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record GenreResponse(
		
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "long"
                )
		Long id,
		
        @Schema(
                accessMode = Schema.AccessMode.READ_WRITE,
                type = "string",
                description = "Gênero musical",
                example = "Rock")
		String name
		
		) {

}

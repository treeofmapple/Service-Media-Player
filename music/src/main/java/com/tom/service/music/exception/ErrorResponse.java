package com.tom.service.music.exception;

import java.util.Map;

public record ErrorResponse(Map<String, String> errors) {
}

package com.tom.service.music.exception;

import com.tom.service.music.exception.global.CustomGlobalException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends CustomGlobalException {

	private final String msg;
	
}

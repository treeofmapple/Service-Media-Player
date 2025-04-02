package com.tom.service.music.exception.global;

@SuppressWarnings("serial")
public abstract class CustomGlobalException extends RuntimeException {
	public abstract String getMsg();
}

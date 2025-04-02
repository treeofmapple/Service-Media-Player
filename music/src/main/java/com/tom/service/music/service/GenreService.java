package com.tom.service.music.service;

import org.springframework.stereotype.Service;

import com.tom.service.music.repository.GenreRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class GenreService {

	private final GenreRepository repository;
	
}

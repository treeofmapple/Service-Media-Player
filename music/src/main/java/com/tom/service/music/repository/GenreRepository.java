package com.tom.service.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.service.music.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}

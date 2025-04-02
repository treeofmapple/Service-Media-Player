package com.tom.service.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.service.music.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}

package com.tom.service.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.service.music.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}

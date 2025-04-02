package com.tom.service.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.service.music.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {

}

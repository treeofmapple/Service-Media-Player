package com.tom.service.music.mapper;

import java.time.LocalDate;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.tom.service.music.model.Album;
import com.tom.service.music.model.Artist;
import com.tom.service.music.model.Genre;
import com.tom.service.music.model.Music;
import com.tom.service.music.request.AlbumResponse;
import com.tom.service.music.request.ArtistResponse;
import com.tom.service.music.request.GenreResponse;
import com.tom.service.music.request.MusicResponse;

@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SystemMapper {

	SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);
	
	@Mapping(source = "name", target = "name")
	Artist buildArtist(String name);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	ArtistResponse toResponse(Artist artist);
	
	@Mapping(source = "name", target = "name")
	Genre buildGenre(String name);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	GenreResponse toResponse(Genre artist);
	
	@Mapping(source = "title", target = "title")
	@Mapping(source = "artist", target = "artistId")
	@Mapping(source = "releaseDate", target = "releaseDate")
	Album buildAlbum(String title, Artist artist, LocalDate releaseDate);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "title", target = "title")
	@Mapping(source = "artistId", target = "artist", qualifiedByName = "mapArtistToName")
	@Mapping(source = "releaseDate", target = "releaseDate")
	AlbumResponse toResponse(Album album);
	
	@Mapping(source = "title", target = "title")
	@Mapping(source = "artist", target = "artistId")
	@Mapping(source = "releaseDate", target = "releaseDate")
	Music buildMusic(String title, Artist artist, LocalDate releaseDate);
	
	@Mapping(source = "title", target = "title")
	@Mapping(source = "artistId", target = "artist", qualifiedByName = "mapArtistToName")
	@Mapping(source = "albumId", target = "album", qualifiedByName = "mapAlbumToName")
	@Mapping(source = "genreId", target = "genre", qualifiedByName = "mapGenreToName")
	@Mapping(source = "durationTime", target = "duration")
	@Mapping(source = "releaseDate", target = "releaseDate")
	@Mapping(source = "uploadDate", target = "uploadDate")
	@Mapping(source = "fileUrl", target = "fileUrl")
	MusicResponse toResponse(Music music);
	
	@Named("mapArtistToName")
	default String mapArtistToName(Artist artist) {
		return artist != null ? artist.getName() : null;
	}
	
	@Named("mapAlbumToName")
	default String mapAlbumToName(Album album) {
		return album != null ? album.getTitle() : null;
	}
	
	@Named("mapGenreToName")
	default String mapGenreToName(Genre genre) {
		return genre != null ? genre.getName() : null;
	}
	
}

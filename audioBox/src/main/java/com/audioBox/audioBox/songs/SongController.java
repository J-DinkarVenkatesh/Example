package com.audioBox.audioBox.songs;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/songs")
public class SongController {
	
	@Autowired
	private SongRepository songRepo;
	
	//private List<Song> song = new ArrayList<>();

	@PostMapping
	public Song createSong(@RequestBody Song song) {
		Song songs = new Song();
		songs.setId(song.getId());
		songs.setSongTitle(song.getSongTitle());
		songs.setArtist(song.getArtist());
		songs.setAlbum(song.getAlbum());
		songRepo.save(songs);
		return songs;
	}
	
	@GetMapping
	public List<Song> getSongs(){
		return this.songRepo.findAll();
	}
	
	@GetMapping("{songTitle}/{artist}/{album}")
	public List<Song> searchSong(
	        @RequestParam String songTitle, //requestparam
	        @RequestParam  String artist,
	        @RequestParam String  album) {

	    List<Song> songs = this.songRepo.findAll();

	    if (songTitle == null && artist == null && album == null) {
	        return songs;
	    }

	    List<Song> results = new ArrayList<>();
	    for (Song song : songs) {
	        if (songTitle != null && !song.getSongTitle().toLowerCase().contains(songTitle.toLowerCase())) {
	            continue;
	        }
	        if (artist != null && !song.getArtist().toLowerCase().contains(artist.toLowerCase())) {
	            continue;
	        }
	        if (album != null && !song.getAlbum().toLowerCase().contains(album.toLowerCase())) {
	            continue;
	        }
	        results.add(song);
	    }
	    return results;
	}
	
	
}

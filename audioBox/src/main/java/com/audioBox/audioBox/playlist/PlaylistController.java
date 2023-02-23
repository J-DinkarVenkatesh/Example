package com.audioBox.audioBox.playlist;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audioBox.audioBox.songs.Song;



@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Autowired
	private PlaylistRepository  playlistrepo;
	
	/*@PostMapping 
	public Playlist createPlaylist(@RequestParam long id,
			@RequestParam String name,
			@RequestParam Set<Song> songs ) {
		Playlist playlist = new Playlist();
		playlist.setId(id);
		playlist.setName(name);
		playlist.setSongs(songs);
		playlistrepo.save(playlist);
		return playlist;
	}*/
	
	@PostMapping 
	public Playlist createPlaylist(@RequestBody Playlist playlist) {
		Playlist pl = new Playlist();
		pl.setId(playlist.getId());
		pl.setName(playlist.getName());
		pl.setSongs(playlist.getSongs());
		playlistrepo.save(pl);
		return pl;
	}
	
	@PutMapping ("/{id}")
	public void upadtePlaylist(@PathVariable Long id , @RequestBody Playlist playlist) {
		playlistrepo.save(playlist);
		
	}
	
	//playlist {playlistId}/songs postmapping
	
	@PostMapping("/{playlistId}/songs")
	public Playlist addSongToPlaylist(@PathVariable long playlistId, @RequestBody Song song) {
	    Playlist playlist = playlistrepo.findById(playlistId).orElse(null);
	    if (playlist == null) {
	        return null;
	    }
	    Set<Song> songs = playlist.getSongs();
	    songs.add(song);
	    playlist.setSongs(songs);
	    playlistrepo.save(playlist);
	    return playlist;
	}
	
	@GetMapping
	public List<Playlist> getPlaylist() {
		return this.playlistrepo.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deletePlaylist(@PathVariable long id ) {
		playlistrepo.deleteById(id);
	}
	
	@DeleteMapping ("/{id}/songs/{songTitle}")
	public void removeSongFromPlaylist(@PathVariable long playlistId,@PathVariable String songTitle) {
		Playlist playlist = playlistrepo.findById(playlistId).orElse(null);
		if(playlist == null) {
			return;
		}
		Set <Song> songs = playlist.getSongs();
		songs.removeIf(song -> song.getSongTitle().equals(songTitle));
		playlist.setSongs(songs);
		playlistrepo.save(playlist);
	}

	
	
	
	
	
	
	
	
	
	
	
}

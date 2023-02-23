package com.audioBox.audioBox.playlist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.*;

import com.audioBox.audioBox.songs.Song;

@Entity
public class Playlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	@ManyToMany
	private Set<Song> songs;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Song> getSongs() {
		return songs;
	}
	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	
	
	

}

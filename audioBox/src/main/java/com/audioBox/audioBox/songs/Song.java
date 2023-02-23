package com.audioBox.audioBox.songs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private long id;
	private String songTitle;
	private String artist;
	private String album;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSongTitle() {
		return songTitle;
	}
	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", songTitle=" + songTitle + ", artist=" + artist + ", album=" + album + "]";
	}

}

package com.shingo.songr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//save things in db using @Entity
@Entity
public class Album {

    @Id
//    takes in strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

//    default constructor
    public Album(){}

    private String title;
    private String artist;
    private int songCount;
    private int length;
    private String imageUrl;

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }


    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getId() {
        return id;
    }
}
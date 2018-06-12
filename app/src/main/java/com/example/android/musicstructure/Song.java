package com.example.android.musicstructure;

/**
 * Created by gbolatto on 6/11/2018.
 */
public class Song {
    private String mSongName;
    private String mArtistName;

    public Song(String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }
}

package com.example.android.musicstructure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("Fake Song #1", "Artist #1"));
        songs.add(new Song("Fake Song #2", "Artist #1"));
        songs.add(new Song("Fake Song #3", "Artist #2"));
        songs.add(new Song("Fake Song #4", "Artist #2"));
        songs.add(new Song("Fake Song #5", "Artist #2"));
        songs.add(new Song("Fake Song #6", "Artist #3"));
        songs.add(new Song("Fake Song #7", "Artist #3"));
        songs.add(new Song("Fake Song #8", "Artist #3"));
        songs.add(new Song("Fake Song #9", "Artist #4"));

        SongAdapter adapter = new SongAdapter(getApplicationContext(), songs);

        ListView listView = findViewById(R.id.list_view);

        listView.setAdapter(adapter);
    }
}

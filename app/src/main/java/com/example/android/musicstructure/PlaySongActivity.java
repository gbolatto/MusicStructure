package com.example.android.musicstructure;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class PlaySongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        //setup the action bar
        Toolbar myToolbar = findViewById(R.id.header_toolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.now_playing);


        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String songName = extras.getString("songName");
            String artistName = extras.getString("artistName");

            TextView songNameTextView = findViewById(R.id.play_song_song_name);
            TextView artistNameTextView = findViewById(R.id.play_song_artist_name);

            songNameTextView.setText(songName);
            artistNameTextView.setText(artistName);
        }
    }
}

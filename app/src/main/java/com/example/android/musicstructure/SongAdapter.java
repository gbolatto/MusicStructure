package com.example.android.musicstructure;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gbolatto on 6/11/2018.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Song currentSong = getItem(position);

        TextView songNameTextView = listItemView.findViewById(R.id.song_name);
        TextView artistNameTextView = listItemView.findViewById(R.id.artist_name);

        Button buttonPlay = listItemView.findViewById(R.id.play_button);

        songNameTextView.setText(currentSong.getSongName());
        artistNameTextView.setText(currentSong.getArtistName());

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), PlaySongActivity.class);
                i.putExtra("songName", currentSong.getSongName());
                i.putExtra("artistName", currentSong.getArtistName());
                getContext().startActivity(i);
            }
        });

        return listItemView;
    }
}

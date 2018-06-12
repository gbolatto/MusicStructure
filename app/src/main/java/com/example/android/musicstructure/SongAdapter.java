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


    static private class ViewHolder {
        private TextView songNameTextView;
        private TextView artistNameTextView;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View listItemView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.songNameTextView = listItemView.findViewById(R.id.song_name);
            holder.artistNameTextView = listItemView.findViewById(R.id.artist_name);
            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        final Song currentSong = getItem(position);

        Button buttonPlay = listItemView.findViewById(R.id.play_button);

        holder.songNameTextView.setText(currentSong.getSongName());
        holder.artistNameTextView.setText(currentSong.getArtistName());

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), PlaySongActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("songName", currentSong.getSongName());
                i.putExtra("artistName", currentSong.getArtistName());
                getContext().startActivity(i);
            }
        });

        return listItemView;
    }
}

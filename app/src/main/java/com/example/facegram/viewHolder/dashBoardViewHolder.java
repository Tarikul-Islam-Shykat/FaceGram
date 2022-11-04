package com.example.facegram.viewHolder;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facegram.R;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;

public class dashBoardViewHolder extends RecyclerView.ViewHolder {
    StyledPlayerView simpleExoPlayerView;
    SimpleExoPlayer simpleExoPlayer;
    TextView status;

    public dashBoardViewHolder(@NonNull View itemView) {
        super(itemView);
        status = itemView.findViewById(R.id.sample_row_Status);
        simpleExoPlayerView = itemView.findViewById(R.id.sample_row_exoPlayer_view);
    }

    // preparing the exoPlayer
    public void prepareExoplayer(Application application, String v_url){
        try {
            //status.setText(v_title);
            simpleExoPlayer = new SimpleExoPlayer.Builder(application).build();
            MediaItem mediaItem = MediaItem.fromUri(v_url);
            simpleExoPlayerView.setPlayer(simpleExoPlayer);
            simpleExoPlayer.addMediaItem(mediaItem);
            simpleExoPlayer.prepare();
            simpleExoPlayer.play();
            //simpleExoPlayer.setPlayWhenReady(false);
        }
        catch (Exception e )
        {
            Log.d("Exoplayer Crashed", e.getMessage().toString());
        }
    }

    public  void setText(String s){
        status.setText(s);
    }
}

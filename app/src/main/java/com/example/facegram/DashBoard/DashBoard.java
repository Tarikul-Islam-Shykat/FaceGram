package com.example.facegram.DashBoard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.facegram.Modal.RealTimeDataBase_VideoModal;
import com.example.facegram.Modal.videoFileModel;
import com.example.facegram.R;
import com.example.facegram.addVideo.addVideo;
import com.example.facegram.viewHolder.dashBoardViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashBoard extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        floatingActionButton = findViewById(R.id.dashboard_floating_actionButton);
        recyclerView = findViewById(R.id.dashBoard_recView);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), addVideo.class));
                finish();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        DatabaseReference query = FirebaseDatabase.getInstance().getReference().child("myVideos");
        FirebaseRecyclerOptions<RealTimeDataBase_VideoModal> options =
                new FirebaseRecyclerOptions.Builder<RealTimeDataBase_VideoModal>()
                        .setQuery(query, RealTimeDataBase_VideoModal.class)// query is the path, which indicates from which node you are going to fetch the data.
                        .build();


        FirebaseRecyclerAdapter<RealTimeDataBase_VideoModal, dashBoardViewHolder> firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<RealTimeDataBase_VideoModal, dashBoardViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull dashBoardViewHolder holder, int position, @NonNull RealTimeDataBase_VideoModal model) {
                //Toast.makeText(getApplicationContext(), model.getV_title().toString(), Toast.LENGTH_SHORT).show();
                //holder.prepareExoplayer(getApplication(), model.getV_title(), model.getV_url());
                holder.setText(model.getV_title());
            }

            @NonNull
            @Override
            public dashBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_video_row_dashboard,parent, false);
                return new dashBoardViewHolder(view);
            }
        };

         firebaseRecyclerAdapter.startListening();
         recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

}

/*
* TODO: so the main issue, we are not getting any value form the firebase, not the url or the text, so if we dont
*  get anything we cant show them in the recycler view.
*
*
* */
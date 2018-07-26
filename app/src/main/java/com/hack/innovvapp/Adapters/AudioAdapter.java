package com.hack.innovvapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack.innovvapp.Models.AudioFeedback;
import com.hack.innovvapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.MyViewHolder> {

    private Context mContext;


    private ArrayList<AudioFeedback> audioFeedbackArrayList;


    public AudioAdapter(Context mContext, ArrayList<AudioFeedback> audioFeedbackArrayList) {
        this.mContext = mContext;
        this.audioFeedbackArrayList = audioFeedbackArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_audio,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        AudioFeedback audioFeedback = audioFeedbackArrayList.get(i);

        if (audioFeedback.getType() == 0){

            myViewHolder.audioTypeTextView.setText(R.string.other_title);


        }else if (audioFeedback.getType() == 1){
            myViewHolder.audioNameTextView.setText(R.string.emitra_title);

        }else if (audioFeedback.getType() == 2){
            myViewHolder.audioNameTextView.setText(R.string.bhamashah_title);
        }

    }

    @Override
    public int getItemCount() {
        return audioFeedbackArrayList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.audio_tye_view)
        TextView audioTypeTextView;

        @BindView(R.id.audio_text_view)
        TextView audioNameTextView;

        @BindView(R.id.audio_image_view)
        ImageView audioImageView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            ButterKnife.bind(this,itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}

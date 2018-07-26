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
import com.hack.innovvapp.Models.TextFeedback;
import com.hack.innovvapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextADAPTER extends RecyclerView.Adapter<TextADAPTER.MyViewHolder> {

    private Context mContext;


    private ArrayList<TextFeedback> audioFeedbackArrayList;


    public TextADAPTER(Context mContext, ArrayList<TextFeedback> audioFeedbackArrayList) {
        this.mContext = mContext;
        this.audioFeedbackArrayList = audioFeedbackArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_text_feedback,viewGroup,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        TextFeedback textFeedback = audioFeedbackArrayList.get(i);

        if (textFeedback.getType() == 0){

            myViewHolder.itemTextTypeView.setText(R.string.other_title);


        }else if (textFeedback.getType() == 1){
            myViewHolder.itemTextTypeView.setText(R.string.emitra_title);

        }else if (textFeedback.getType() == 2){
            myViewHolder.itemTextTypeView.setText(R.string.bhamashah_title);
        }

        myViewHolder.itemTextFeedbackTextView.setText(textFeedback.getFeedback());



    }

    @Override
    public int getItemCount() {
        return audioFeedbackArrayList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.item_text_feedback_text_view)
        TextView itemTextFeedbackTextView;


        @BindView(R.id.item_text_text_view)
        TextView itemTextTypeView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            ButterKnife.bind(this,itemView);


        }

        @Override
        public void onClick(View view) {

        }
    }
}

package com.hack.innovvapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hack.innovvapp.Activities.MainActivity;
import com.hack.innovvapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static java.lang.Boolean.FALSE;

public class retrieve_menu_fragment extends Fragment{


    @BindView(R.id.text_feedback_button)
    Button textFeedbackButton;


    @BindView(R.id.voice_feedback_voice_button)
    Button voiceFeedBackButton;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.text_audio_fragment,container,FALSE);

        unbinder = ButterKnife.bind(this,rootView);


        textFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextFragment textFragment = new TextFragment();
                MainActivity.changeMainFragment(getActivity(),textFragment);
            }
        });

        voiceFeedBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AudioFragment audioFragment = new AudioFragment();
                MainActivity.changeMainFragment(getActivity(),audioFragment);
            }
        });




        return rootView;
    }
}

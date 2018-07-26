package com.hack.innovvapp.Fragments;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.hack.innovvapp.Adapters.AudioAdapter;
import com.hack.innovvapp.Models.AudioFeedback;
import com.hack.innovvapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AudioFragment extends Fragment {

    ArrayList<AudioFeedback> audioFeedbackList = new ArrayList<>();

    private DatabaseReference mDatabaseReference;

    private StorageReference mStorageReference;


    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    AudioAdapter audioAdapter;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_audio,container,false);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        unbinder = ButterKnife.bind(this,rootView);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mStorageReference = FirebaseStorage.getInstance().getReference();


     audioAdapter = new AudioAdapter(getContext(),audioFeedbackList);


        recyclerView.setAdapter(audioAdapter);

        recyclerView.setLayoutManager(mLayoutManager);



        addAllAudios();









        return rootView;


    }

    private void addAllAudios(){
        mDatabaseReference.child(FeedbackFrament.PATH_AUDIO).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    if (dataSnapshot1!=null){

                        AudioFeedback audioFeedback = dataSnapshot1.getValue(AudioFeedback.class);
                        /*for (DataSnapshot dataSnapshot2:dataSnapshot1.getChildren()){


                                for (DataSnapshot dataSnapshot3 : dataSnapshot2.getChildren() ){
                                    AudioFeedback audioFeedback = dataSnapshot3.getValue(AudioFeedback.class);
*/
                            if (audioFeedback!=null) {

                                audioFeedbackList.add(audioFeedback);

                                audioAdapter.notifyDataSetChanged();
                                Log.e("SIZE",String.valueOf(audioFeedbackList.size()));




                            /*}
                            }*/
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

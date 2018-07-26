package com.hack.innovvapp.Fragments;

import android.os.Bundle;
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
import com.hack.innovvapp.Adapters.TextADAPTER;
import com.hack.innovvapp.Models.AudioFeedback;
import com.hack.innovvapp.Models.TextFeedback;
import com.hack.innovvapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TextFragment  extends Fragment{

    ArrayList<TextFeedback> audioFeedbackList = new ArrayList<>();

    private DatabaseReference mDatabaseReference;

    private StorageReference mStorageReference;


    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    TextADAPTER audioAdapter;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_audio,container,false);



        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        unbinder = ButterKnife.bind(this,rootView);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mStorageReference = FirebaseStorage.getInstance().getReference();


        audioAdapter = new TextADAPTER(getContext(),audioFeedbackList);


        recyclerView.setAdapter(audioAdapter);

        recyclerView.setLayoutManager(mLayoutManager);



        adAllTexts();









        return rootView;


    }

    private void adAllTexts(){
        mDatabaseReference.child(FeedbackFrament.PATH_TEXT).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    if (dataSnapshot1!=null){

                        TextFeedback textFeedback = dataSnapshot1.getValue(TextFeedback.class);
                        /*for (DataSnapshot dataSnapshot2:dataSnapshot1.getChildren()){


                                for (DataSnapshot dataSnapshot3 : dataSnapshot2.getChildren() ){
                                    AudioFeedback audioFeedback = dataSnapshot3.getValue(AudioFeedback.class);
*/
                        if (textFeedback!=null) {

                            audioFeedbackList.add(textFeedback);

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



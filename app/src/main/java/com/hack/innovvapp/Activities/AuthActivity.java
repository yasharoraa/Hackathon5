package com.hack.innovvapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hack.innovvapp.Fragments.AudioFragment;
import com.hack.innovvapp.Fragments.retrieve_menu_fragment;
import com.hack.innovvapp.R;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        retrieve_menu_fragment retrieve_menu_fragment = new retrieve_menu_fragment();





        MainActivity.changeMainFragment(this,retrieve_menu_fragment
        );
    }
}

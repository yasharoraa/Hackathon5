package com.hack.innovvapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hack.innovvapp.Fragments.InformationFragment;
import com.hack.innovvapp.R;

import org.w3c.dom.Text;

import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SelectingActivity extends AppCompatActivity {


    @BindView(R.id.user_text_view)
    TextView userTextView;

    @BindView(R.id.govt_text_view)
    TextView govtTextView;

    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting);

        unbinder = ButterKnife.bind(this);


        userTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectingActivity.this,MainActivity.class);

                startActivity(intent);
            }
        });

        govtTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectingActivity.this,AuthActivity.class);

                startActivity(intent);
            }
        });

    }


}

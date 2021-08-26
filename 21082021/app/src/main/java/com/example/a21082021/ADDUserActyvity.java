package com.example.a21082021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ADDUserActyvity extends AppCompatActivity {

    TextView nameTextView;
    TextView lastNameTextView;
    TextView fonNumberTextView;
    Button buttonADD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduser_actyvity);
        nameTextView=findViewById(R.id.textName);
        lastNameTextView=findViewById(R.id.textlasName);
        fonNumberTextView=findViewById(R.id.textFonNumber);
        buttonADD=findViewById(R.id.ADDbutton);
        buttonADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user=new User();
                user.setName(nameTextView.getText().toString());
                user.setLastname(lastNameTextView.getText().toString());
                user.setFonNumber(fonNumberTextView.getText().toString());
                //Users control el access a dates
                Users users=new Users(ADDUserActyvity.this);
                users.addUser(user);
                //regret
                onBackPressed();
            }
        });
    }


}
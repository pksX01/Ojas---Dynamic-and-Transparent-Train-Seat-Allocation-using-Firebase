package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void sign_in(View view){
        Intent intent=new Intent(Sign_in.this,CoachSelection.class);
        startActivity(intent);
    }
}

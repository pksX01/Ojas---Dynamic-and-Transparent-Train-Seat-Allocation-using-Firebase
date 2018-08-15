package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Compartment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartment);
    }

    public void cmprt1(View view){
        Intent intent=new Intent(Compartment.this,Compartment1.class);
        startActivity(intent);
    }
}

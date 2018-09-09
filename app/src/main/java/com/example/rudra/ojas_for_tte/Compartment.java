package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Compartment extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private String compartment;
    Button btnx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartment);
        database= FirebaseDatabase.getInstance();
        myRef = database.getReference();
       btnx = (Button) findViewById(R.id.buttonx);
        btnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartment =btnx.getText().toString();
                //DatabaseReference childRef = myRef.child(compartment);
                //childRef.setValue("Yes");
                Intent intent=new Intent(Compartment.this,Compartment1.class);
                startActivity(intent);
            }
        });
    }


}

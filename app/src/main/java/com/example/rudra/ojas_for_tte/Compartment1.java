package com.example.rudra.ojas_for_tte;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Compartment1 extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    private FirebaseDatabase database;
    private DatabaseReference myRef;//,ref1,ref2;
    private String seat;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartment1);
        database= FirebaseDatabase.getInstance();
        myRef = database.getReference().child("Compartment 1");
        //ref1=myRef.child("Train No.- 12245");
        //ref2=ref1.child("S1");//.child("Seats")
        btn1= (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn1.getText().toString();
                DatabaseReference childRef = myRef.child("Seats").child("seat"+seat);
                childRef.setValue("Yes");
                btn1.setBackgroundColor(Color.GREEN);
                //myRef.push().setValue("seat 1");
            }
        });

        btn2= (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn2.getText().toString();
                DatabaseReference childRef = myRef.child("Seats").child("seat"+seat);
                childRef.setValue("Yes");
                btn2.setBackgroundColor(Color.GREEN);

            }
        });

        btn3= (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn3.getText().toString();
                DatabaseReference childRef = myRef.child("seat"+seat);
                childRef.setValue("Yes");
                btn3.setBackgroundColor(Color.GREEN);

            }
        });

        btn4= (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn4.getText().toString();
                DatabaseReference childRef = myRef.child("seat"+seat);
                childRef.setValue("Yes");
                btn4.setBackgroundColor(Color.GREEN);

            }
        });

        btn5= (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn5.getText().toString();
                DatabaseReference childRef = myRef.child("seat"+seat);
                childRef.setValue("Yes");
                btn5.setBackgroundColor(Color.GREEN);
            }
        });

        btn6= (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn6.getText().toString();
                DatabaseReference childRef = myRef.child("seat"+seat);
                childRef.setValue("Yes");
                btn6.setBackgroundColor(Color.GREEN);
            }
        });

        btn7= (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn7.getText().toString();
                DatabaseReference childRef = myRef.child("seat"+seat);
                childRef.setValue("Yes");
                btn7.setBackgroundColor(Color.GREEN);
            }
        });

        btn8= (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn8.getText().toString();
                DatabaseReference childRef = myRef.child("seat"+seat);
                childRef.setValue("Yes");
                btn8.setBackgroundColor(Color.GREEN);
            }
        });
    }
}

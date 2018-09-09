package com.example.rudra.ojas_for_tte;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;


public class Compartment1 extends AppCompatActivity {

   // private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    private FirebaseDatabase database;
    private DatabaseReference myRef;//,ref1,ref2;
    private String seat;

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button10,
            R.id.button11,
            R.id.button12,
            R.id.button13,
            R.id.button14,
            R.id.button15,
            R.id.button16,
            R.id.button17,
            R.id.button18,
            R.id.button19,
            R.id.button20,
            R.id.button21, R.id.button22, R.id.button23, R.id.button24, R.id.button25, R.id.button26,
            R.id.button27, R.id.button28, R.id.button29, R.id.button30, R.id.button31, R.id.button32,
            R.id.button33, R.id.button34, R.id.button35, R.id.button36, R.id.button37, R.id.button38,
            R.id.button39, R.id.button40, R.id.button41, R.id.button42, R.id.button43, R.id.button44,
            R.id.button45, R.id.button46, R.id.button47, R.id.button48, R.id.button49, R.id.button50,
            R.id.button51, R.id.button52, R.id.button53, R.id.button54, R.id.button55, R.id.button56,
            R.id.button57, R.id.button58, R.id.button59, R.id.button60, R.id.button61, R.id.button62,
            R.id.button63, R.id.button64, R.id.button65, R.id.button66, R.id.button67, R.id.button68,
            R.id.button69, R.id.button70, R.id.button71, R.id.button72,
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartment1);
        Bundle bundle1=getIntent().getExtras();
        String data1=bundle1.get("data1").toString();
        Bundle bundle2=getIntent().getExtras();
       final String data2=bundle2.get("data2").toString();
        database= FirebaseDatabase.getInstance();
        myRef = database.getReference().child(data1);

        buttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for(int id : BUTTON_IDS) {
            final Button button = (Button)findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seat =button.getText().toString();
                    DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                    childRef.setValue("Yes");
                    button.setBackgroundColor(Color.GREEN);
                }
            });
            buttons.add(button);
        }

        /*btn1= (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn1.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
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
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn2.setBackgroundColor(Color.GREEN);

            }
        });

        btn3= (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn3.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn3.setBackgroundColor(Color.GREEN);

            }
        });

        btn4= (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn4.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn4.setBackgroundColor(Color.GREEN);

            }
        });

        btn5= (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn5.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn5.setBackgroundColor(Color.GREEN);
            }
        });

        btn6= (Button) findViewById(R.id.button6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn6.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn6.setBackgroundColor(Color.GREEN);
            }
        });

        btn7= (Button) findViewById(R.id.button7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn7.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn7.setBackgroundColor(Color.GREEN);
            }
        });

        btn8= (Button) findViewById(R.id.button8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn8.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn8.setBackgroundColor(Color.GREEN);
            }
        });

        btn9= (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seat =btn9.getText().toString();
                DatabaseReference childRef = myRef.child(data2).child("seat"+seat);
                childRef.setValue("Yes");
                btn9.setBackgroundColor(Color.GREEN);
            }
        });
        */


    }

    public void submit(View view){
        Intent intent= new Intent(Compartment1.this,CoachSelection.class);
        startActivity(intent);
    }
}

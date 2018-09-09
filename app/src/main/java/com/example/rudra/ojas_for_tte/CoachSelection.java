package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class CoachSelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_selection);

        final Spinner spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        List<String> train_no= new ArrayList<String>();
        train_no.add("12561");
        train_no.add("12562");
        train_no.add("14013");
        train_no.add("14014");
        train_no.add("14017");
        train_no.add("14018");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, train_no);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter1);

        final Spinner spinner2=(Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        List<String> Coach =new ArrayList<String>();
        Coach.add("S1");
        Coach.add("S2");
        Coach.add("S3");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Coach);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        next=(Button) findViewById(R.id.nxt_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CoachSelection.this,Compartment1.class);
                intent.putExtra("data1",String.valueOf(spinner1.getSelectedItem()));
                intent.putExtra("data2",String.valueOf(spinner2.getSelectedItem()));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
}


package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Ticket_Booking extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText ed_name, ed_age, ed_sex, ed_mob;
    private String name, age, sex, mob_no;
    private String item, coach_no;
    //private Object obj;
    //private int seat_no = 0;
    //long coach_12561,coach_12562,coach_14013,coach_14014,coach_14017,coach_14018,coach_no=1;
    long seatIn12561_S1, seatIn12562_S1, seatIn14013_S1, seatIn14014_S1, seatIn14017_S1, seatIn14018_S1;
    long seatIn12561_S2, seatIn12562_S2, seatIn14013_S2, seatIn14014_S2, seatIn14017_S2, seatIn14018_S2;
    long seatIn12561_S3, seatIn12562_S3, seatIn14013_S3, seatIn14014_S3, seatIn14017_S3, seatIn14018_S3;
    long seatIn12561_WL, seatIn12562_WL, seatIn14013_WL, seatIn14014_WL, seatIn14017_WL, seatIn14018_WL;
    long seat_no_long;
    private DatabaseReference newReference;
    private DatabaseReference  passengerRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket__booking);

        final Spinner spinner1 = (Spinner) findViewById(R.id.train_spinner);
        spinner1.setOnItemSelectedListener(this);
        List<String> train_no = new ArrayList<String>();
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

        ed_name = (EditText) findViewById(R.id.editText4);
        ed_age = (EditText) findViewById(R.id.editText6);
        ed_sex = (EditText) findViewById(R.id.editText5);
        ed_mob = (EditText) findViewById(R.id.editText8);

        newReference = FirebaseDatabase.getInstance().getReference();
        passengerRef = newReference.child("Seats allocated to Passengers at the time of booking ");


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    /* -------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public void onStart() {
        super.onStart();

        passengerRef.child("12561").child("S1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn12561_S1=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("12562").child("S1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn12562_S1=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14013").child("S1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14013_S1=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14014").child("S1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14014_S1=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14017").child("S1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14017_S1=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14018").child("S1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14018_S1=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



            passengerRef.child("12561").child("S2").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    seatIn12561_S2 = dataSnapshot.getChildrenCount();
                    //Toast.makeText(getApplicationContext(), "seat no in 12561 in S2" + " from database is " + seatIn12561_S2, Toast.LENGTH_LONG).show();

                }


                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



            passengerRef.child("12562").child("S2").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    seatIn12562_S2 = dataSnapshot.getChildrenCount();
                   // Toast.makeText(getApplicationContext(), "seat no in 12562 in S2"+ " from database is " + seatIn12562_S2, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



            passengerRef.child("14013").child("S2").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    seatIn14013_S2 = dataSnapshot.getChildrenCount();
                   // Toast.makeText(getApplicationContext(), "seat no in 14013 in S2" + " from database is " + seatIn14013_S2, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        passengerRef.child("14014").child("S2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14014_S2=dataSnapshot.getChildrenCount();
                //Toast.makeText(getApplicationContext(), "seat no in 14014 in S2"+" from database is " + seatIn14014_S2, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("14017").child("S2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                seatIn14017_S2=dataSnapshot.getChildrenCount();
                //Toast.makeText(getApplicationContext(), "seat no in 14017 in S2"+" from database is " + seatIn14017_S2, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("14018").child("S2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14018_S2=dataSnapshot.getChildrenCount();
                //Toast.makeText(getApplicationContext(), "seat no in 14018 in S2"+" from database is " + seatIn14018_S2, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("12561").child("S3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn12561_S3=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("12562").child("S3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn12562_S3=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14013").child("S3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14013_S3=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14014").child("S3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14014_S3=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14017").child("S3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14017_S3=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14018").child("S3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14018_S3=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        passengerRef.child("12561").child("WL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn12561_WL=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("12562").child("WL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn12562_WL=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14013").child("WL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14013_WL=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14014").child("WL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14014_WL=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14017").child("WL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14017_WL=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        passengerRef.child("14018").child("WL").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                seatIn14018_WL=dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onStop(){
        super.onStop();
    }


    public void book_ticket (View view) {

            name = ed_name.getText().toString();
            age = ed_age.getText().toString();
            sex = ed_sex.getText().toString();
            mob_no = ed_mob.getText().toString();

            /*----------------------------------------------------------------------------------------------------------------------------*/
            if (item.equals("12561")) {
                if (seatIn12561_S1 < 10) {
                    seat_no_long = seatIn12561_S1;
                    coach_no = "S1";
                } else if (seatIn12561_S2 < 10) {
                    seat_no_long = seatIn12561_S2;
                    coach_no = "S2";
                } else if (seatIn12561_S3 < 10) {
                    seat_no_long = seatIn12561_S3;
                    coach_no = "S3";
                } else {
                    seat_no_long = seatIn12561_WL;
                    coach_no = "WL";
                }


            } else if (item.equals("12562")) {
                if (seatIn12562_S1 < 10) {
                    seat_no_long = seatIn12562_S1;
                    coach_no = "S1";
                } else if (seatIn12562_S2 < 10) {
                    seat_no_long = seatIn12562_S2;
                    coach_no = "S2";
                } else if (seatIn12562_S3 < 10) {
                    seat_no_long = seatIn12562_S3;
                    coach_no = "S3";
                } else {
                    seat_no_long = seatIn12562_WL;
                    coach_no = "WL";
                }

            } else if (item.equals("14013")) {
                if (seatIn14013_S1 < 10) {
                    seat_no_long = seatIn14013_S1;
                    coach_no = "S1";
                } else if (seatIn14013_S2 < 10) {
                    seat_no_long = seatIn14013_S2;
                    coach_no = "S2";
                } else if (seatIn14013_S3 < 10) {
                    seat_no_long = seatIn14013_S3;
                    coach_no = "S3";
                } else {
                    seat_no_long = seatIn14013_WL;
                    coach_no = "WL";
                }

            } else if (item.equals("14014")) {
                if (seatIn14014_S1 < 10) {
                    seat_no_long = seatIn14014_S1;
                    coach_no = "S1";
                } else if (seatIn14014_S2 < 10) {
                    seat_no_long = seatIn14014_S2;
                    coach_no = "S2";
                } else if (seatIn14014_S3 < 10) {
                    seat_no_long = seatIn14014_S3;
                    coach_no = "S3";
                } else {
                    seat_no_long = seatIn14014_WL;
                    coach_no = "WL";
                }

            } else if (item.equals("14017")) {
                if (seatIn14017_S1 < 10) {
                    seat_no_long = seatIn14017_S1;
                    coach_no = "S1";
                } else if (seatIn14017_S2 < 10) {
                    seat_no_long = seatIn14017_S2;
                    coach_no = "S2";
                } else if (seatIn14017_S3 < 10) {
                    seat_no_long = seatIn14017_S3;
                    coach_no = "S3";
                } else {
                    seat_no_long = seatIn14017_WL;
                    coach_no = "WL";
                }

            } else if (item.equals("14018")) {
                if (seatIn14018_S1 < 10) {
                    seat_no_long = seatIn14018_S1;
                    coach_no = "S1";
                } else if (seatIn14018_S2 < 10) {
                    seat_no_long = seatIn14018_S2;
                    coach_no = "S2";
                } else if (seatIn14018_S3 < 10) {
                    seat_no_long = seatIn14018_S3;
                    coach_no = "S3";
                } else {
                    seat_no_long = seatIn14018_WL;
                    coach_no = "WL";
                }

            }

            passengerRef.child(item).child(coach_no).child(name).child("Age").setValue(age);
            passengerRef.child(item).child(coach_no).child(name).child("Sex").setValue(sex);
            passengerRef.child(item).child(coach_no).child(name).child("Mobile").setValue(mob_no);
            seat_no_long++;
            passengerRef.child(item).child(coach_no).child(name).child("Seat No").setValue(seat_no_long);

        Intent intent = new Intent(Ticket_Booking.this,Sign_in.class);
        startActivity(intent);

            //Toast.makeText(getApplicationContext(), "old seat" + seat_no_long, Toast.LENGTH_LONG).show();
        }
    }


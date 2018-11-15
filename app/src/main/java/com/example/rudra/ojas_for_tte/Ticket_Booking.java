package com.example.rudra.ojas_for_tte;

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
    EditText ed_name, ed_age, ed_sex,ed_mob;
    private String name, age, sex,mob_no,coach_no;
    private String item,seat_str="";
    private Object obj;
    private int seat_no=0,i=1,seatIn12561,seatIn12562,seatIn14013,seatIn14014,seatIn14017,seatIn14018;
    private DatabaseReference newReference;
    private DatabaseReference childrenRef,passengerRef;
    private DatabaseReference finalRef;
    BookingDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket__booking);

        final Spinner spinner1=(Spinner) findViewById(R.id.train_spinner);
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

        ed_name=(EditText) findViewById(R.id.editText4);
        ed_age=(EditText) findViewById(R.id.editText6);
        ed_sex=(EditText) findViewById(R.id.editText5);
        ed_mob=(EditText) findViewById(R.id.editText8);

        db =new BookingDatabase(this);

       newReference = FirebaseDatabase.getInstance().getReference();
       passengerRef=newReference.child("Seats allocated to Passengers at the time of booking ");


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

// -------------------------------------------------------------------------------------------------------------------------//
    /*@Override
    public void onStart(){
        super.onStart();*/
//-----------------------------------------------------------------------------------------------------------------------//
        /*ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //User user = postSnapshot.getValue(User.class);
                    //seat_no=user.seat_no;
                    seat_no=postSnapshot.child("Seat No").getValue(Integer.class);
                    //seat_str=postSnapshot.child("Seat No").getValue(String.class);
                    Toast.makeText(getApplicationContext(),"seat no from database is "+seat_no,Toast.LENGTH_LONG).show();
                    //seat_no=String.valueOf();
                    //seat_no++;
                    //seat_str=Integer.toString(seat_no);
                    //seat_str.equals(Integer.valueOf(seat_str)+1);
                    //seat_str.equals(Integer.parseInt(seat_str)+1);
                    //int temp = user.getSeat_no();
                    //seat_no = seat_no + temp + 1;
                    //seat_no=dataSnapshot.getValue(Integer.class);
                    seat_no++;
                    final_seat=seat_no;
                    // coach_no=user.coach_no;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                //  Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        finalRef.addValueEventListener(postListener);*/
//----------------------------------------------------------------------------------------------------------------------//
        /*passengerRef.child("12561").child("S"+i).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               // int x=0;
                //Integer[] num = new Integer[10];
                //seat_no=dataSnapshot.child("Seat No").getValue(Integer.class);
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user1 = postSnapshot.getValue(User.class);
                    //seatIn12561= postSnapshot.child("Seat No").getValue(Integer.class);

                    //num[x++]
                    seatIn12561= user1.getSeat_no();
                    Toast.makeText(getApplicationContext(), "seat no in 12561 from database is " + seatIn12561, Toast.LENGTH_LONG).show();
                }
                    //seatIn12561 = Collections.max(Arrays.asList(num));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("12562").child("S"+i).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //int x=0;
                //Integer[] num = new Integer[10];
                //seat_no=dataSnapshot.child("Seat No").getValue(Integer.class);
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user2 = postSnapshot.getValue(User.class);
                   //seatIn12562= postSnapshot.child("Seat No").getValue(Integer.class);

                   // num[x++]
                    seatIn12562= user2.getSeat_no();
                    Toast.makeText(getApplicationContext(), "seat no in 12562 from database is " + seatIn12562, Toast.LENGTH_LONG).show();
                }
                    //seatIn12562 = Collections.max(Arrays.asList(num));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("14013").child("S"+i).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //int x=0;
                //Integer[] num = new Integer[10];
                //seat_no=dataSnapshot.child("Seat No").getValue(Integer.class);
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user3 = postSnapshot.getValue(User.class);
                   // seatIn14013= postSnapshot.child("Seat No").getValue(Integer.class);

                   // num[x++]
                    seatIn14013= user3.getSeat_no();
                    Toast.makeText(getApplicationContext(), "seat no in 14013 from database is " + seatIn14013, Toast.LENGTH_LONG).show();
                }
                    //seatIn14013 =Collections.max(Arrays.asList(num));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("14014").child("S"+i).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //int x=0;
                //Integer[] num = new Integer[10];
                //seat_no=dataSnapshot.child("Seat No").getValue(Integer.class);
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user4 = postSnapshot.getValue(User.class);
                    //seatIn14014= postSnapshot.child("Seat No").getValue(Integer.class);

                    //num[x++] =
                    seatIn14014=user4.getSeat_no();
                    Toast.makeText(getApplicationContext(), "seat no in 14014 from database is " + seatIn14014, Toast.LENGTH_LONG).show();
                }
                    //seatIn14014 = Collections.max(Arrays.asList(num));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("14017").child("S"+i).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //int x=0;
                //Integer[] num = new Integer[10];
                //seat_no=dataSnapshot.child("Seat No").getValue(Integer.class);
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user5 = postSnapshot.getValue(User.class);
                    //seatIn14017= postSnapshot.child("Seat No").getValue(Integer.class);

                    //num[x++]
                    seatIn14017= user5.getSeat_no();
                    Toast.makeText(getApplicationContext(), "seat no in 14017 from database is " + seatIn14017, Toast.LENGTH_LONG).show();
                }
                    //seatIn14017 = Collections.max(Arrays.asList(num));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        passengerRef.child("14018").child("S"+i).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //int x=0;
                //Integer[] num = new Integer[10];
                //seat_no=dataSnapshot.child("Seat No").getValue(Integer.class);
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    User user6 = postSnapshot.getValue(User.class);
                   // num[x++]
                    seatIn14018= user6.getSeat_no();
                    //seatIn14018= postSnapshot.child("Seat No").getValue(Integer.class);
                    Toast.makeText(getApplicationContext(), "seat no in 14018 from database is " + seatIn14018, Toast.LENGTH_LONG).show();
                }
                    //seatIn14018= Collections.max(Arrays.asList(num));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onStop(){
        super.onStop();
    }*/
  //-------------------------------------------------------------------------------------------------------------------------//
    public void book_ticket(View view){
        int maxWaitingSeatAllowed=1;
        name=ed_name.getText().toString();
        finalRef=passengerRef.child(item).child("S"+i);
        childrenRef=finalRef.child(name);
        age=ed_age.getText().toString();
        sex=ed_sex.getText().toString();
        mob_no=ed_mob.getText().toString();
        /*----------------------SQLite code-----------------------------------------------------------------*/
        Cursor res=db.getAllData("Train_"+item);
        try {

            res.moveToLast();
            int seatColumnIndex = res.getColumnIndex(BookingDatabase.COL_6);
            if(i<=3) {
                if (seatColumnIndex==10) {
                    i++;
                }
                db.insertData("Train_" + item, name, age, sex, mob_no, "S" + i);
                Toast.makeText(getApplicationContext(),"seat="+seatColumnIndex+1,Toast.LENGTH_LONG).show();
            }
            else if(i>3){
                if(maxWaitingSeatAllowed<=5)
                    db.insertExtraData("Train_" + item, name, age, sex, mob_no, "Waiting List",maxWaitingSeatAllowed++);
                Toast.makeText(getApplicationContext(),"waiting seat="+maxWaitingSeatAllowed,Toast.LENGTH_LONG).show();
            }
        }
        finally {
            res.close();
        }
        /*---------------------------------------------------------------------------------------------------------------------------*/
        //User user1 = new User(name,age,sex,mob_no,item,"S"+i,seat_no);

/*-----------------------------------Firebase code--------------------------------------------------------------------------------*/
        /*finalRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //GenericTypeIndicator<Map<String, String>> genericTypeIndicator = new GenericTypeIndicator<Map<String, String>>() {};
                //Map<String, String> map = dataSnapshot.getValue(genericTypeIndicator);
               // List<String> list= new ArrayList<String>();
                //list=dataSnapshot.getValue(List.class);
                //seat_str=map.get("Seat No");
               // seat_str=list.get(3);
                Toast.makeText(getApplicationContext(),"seat_str="+seat_str,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
/*----------------------------------------------------------------------------------------------------------------------------*/
        if(seat_no>10) {
            i++;
            //childrenRef.child("Coach").setValue("S" +i);
            seat_no=1;
            //childrenRef.child("Seat No").setValue(++seat_no);
            book_ticket(view);
        }
        else{
            //childrenRef.child("Coach").setValue("S" +i);
            //childrenRef.child("Seat No").setValue(++seat_no);
            childrenRef.child("Age").setValue(age);
            childrenRef.child("Sex").setValue(sex);
            childrenRef.child("Mobile").setValue(mob_no);
           // if(seat_str!=null || seat_str.isEmpty())
             //   seat_str="1";
            //   seat_str="1";
            /*------------------------------------------------------------------*/
            if(item.equals("12561"))
                seat_no=seatIn12561;
            else  if(item.equals("12562"))
                seat_no=seatIn12562;
            else  if(item.equals("14013"))
                seat_no=seatIn14013;
            else  if(item.equals("14014"))
                seat_no=seatIn14014;
            else  if(item.equals("14017"))
                seat_no=seatIn14017;
            else  if(item.equals("14018"))
                seat_no=seatIn14018;
            seat_no++;
            /*----------------------------------------------------------------------------*/
            if(seat_no==0)
                seat_no=1;
            childrenRef.child("Seat No").setValue(seat_no);
            //seat_no=Integer.parseInt(seat_str);
            Toast.makeText(getApplicationContext(),"old seat"+seat_no,Toast.LENGTH_LONG).show();
           // seat_no++;
            //Toast.makeText(getApplicationContext(),"new seat"+seat_no,Toast.LENGTH_LONG).show();

        }
    }
}

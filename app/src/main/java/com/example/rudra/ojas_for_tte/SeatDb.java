package com.example.rudra.ojas_for_tte;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SeatDb {
    private int train_no;
    private String coach;

    public SeatDb(){}

    public SeatDb(int train_no, String coach){
        this.train_no=train_no;
        this.coach=coach;

    }




}

package com.example.rudra.ojas_for_tte;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String name;
    public String age;
    public String sex;
    public String train_no;
    public String mob_no;
    public String coach_no;
    public int seat_no;

    public User(){
        // Default constructor
    }

    public User (String age, String mob_no,int seat_no,String sex){

        this.age=age;
        this.mob_no=mob_no;
        this.seat_no=seat_no;
        this.sex=sex;
    }

    public String getAge() {
        return age;
    }

    public String getMob_no() {
        return mob_no;
    }

    public int getSeat_no() {
        return seat_no;
    }

    public String getSex() {
        return sex;
    }
}

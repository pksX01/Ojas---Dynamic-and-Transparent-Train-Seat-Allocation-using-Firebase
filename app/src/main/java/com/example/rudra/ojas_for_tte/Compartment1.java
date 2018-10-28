package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.math.BigDecimal;

public class Compartment1 extends AppCompatActivity {

   // private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    private FirebaseDatabase database;
    private DatabaseReference myRef;//,ref1,ref2;
    private String seat;
    private String str="";
    private String data1;
    private String data2;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    //public static final String ACCOUNT_SID = "AC6f466aff19dff5ed06db6a348218ee10";
    //public static final String AUTH_TOKEN = "[AuthToken]";
    private String[] phoneNo = new String[] {"7011051829","8368614346","8800219145"};
    private int[] allocated_seats = new int[72];
    private int i,vacant=0;
    private int [] unallocated_seats = new int [72];

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12,
            R.id.button13,R.id.button14,R.id.button15,R.id.button16,R.id.button17,R.id.button18,
            R.id.button19, R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24,
            R.id.button25, R.id.button26, R.id.button27, R.id.button28, R.id.button29, R.id.button30,
            R.id.button31, R.id.button32, R.id.button33, R.id.button34, R.id.button35, R.id.button36,
            R.id.button37, R.id.button38, R.id.button39, R.id.button40, R.id.button41, R.id.button42,
            R.id.button43, R.id.button44, R.id.button45, R.id.button46, R.id.button47, R.id.button48,
            R.id.button49, R.id.button50, R.id.button51, R.id.button52, R.id.button53, R.id.button54,
            R.id.button55, R.id.button56, R.id.button57, R.id.button58, R.id.button59, R.id.button60,
            R.id.button61, R.id.button62, R.id.button63, R.id.button64, R.id.button65, R.id.button66,
            R.id.button67, R.id.button68,R.id.button69, R.id.button70, R.id.button71, R.id.button72,
    };

    Button submit_btn ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartment1);
        Bundle bundle1=getIntent().getExtras();
        data1=bundle1.get("data1").toString();
        Bundle bundle2=getIntent().getExtras();
         data2=bundle2.get("data2").toString();
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
                    str+=seat+",";
                    //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                    int seat_no= Integer.parseInt(seat);
                     i=0;
                    allocated_seats[i++]=seat_no;
                }
            });
            buttons.add(button);
        }


      /* int j=0;
       // String unallocated_seats="";
        for (int i=1;i<=72;i++){
            String num=String.valueOf(i);
            if(!str.contains(num)){
                array[j++]=i;

             //   unallocated_seats+=num;
            }
        }*/

        submit_btn=(Button) findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("+919810739882"),
                        new com.twilio.type.PhoneNumber("+19363427205"),
                        "Your message")
                        .create();*/

                for(int j=1;j<=72;j++){
                    int flag=0;
                    for(int k=0;k<i-1;k++){
                        if(j==allocated_seats[k]){
                            flag=1;
                        }

                    }
                    if(flag==0){
                        unallocated_seats[vacant++]=j;
                    }

                }
                sendSMSMessage();
                Intent intent= new Intent(Compartment1.this,CoachSelection.class);
                startActivity(intent);
            }
        });

    }

    protected void sendSMSMessage() {
        SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phoneNo[0], null, "You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
            smsManager.sendTextMessage(phoneNo[1], null, "You are allotted seat no. " + unallocated_seats[1] + " in " + data2 + " coach " + "in train " + data1, null, null);
            smsManager.sendTextMessage(phoneNo[2], null, "You are allotted seat no. " + unallocated_seats[2] + " in " + data2 + " coach " + "in train " + data1, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();


        /*if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }*/
    }

   /* @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+917011051829", null,"You are allotted seat no." + unallocated_seats[1] + " in " + data2 +" coach " + "in train "+ data1, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }*/
}

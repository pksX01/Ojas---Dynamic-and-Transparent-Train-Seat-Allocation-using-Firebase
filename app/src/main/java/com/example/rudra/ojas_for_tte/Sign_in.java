package com.example.rudra.ojas_for_tte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_in extends AppCompatActivity {
    EditText ed1,ed2;
    RadioButton simpleRadioButton,simpleRadioButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ed1=(EditText) findViewById(R.id.editText3);
        ed2=(EditText) findViewById(R.id.editText);
         simpleRadioButton = (RadioButton) findViewById(R.id.simpleRadioButton);
         simpleRadioButton1 = (RadioButton) findViewById(R.id.simpleRadioButton1);

    }

    public void sign_in(View view){
        String mail=ed1.getText().toString();
        String pass=ed2.getText().toString();
        String trim_mail=mail.trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(TextUtils.isEmpty(pass) || TextUtils.isEmpty(mail)){
            Toast.makeText(getApplicationContext(),"Enter email and password",Toast.LENGTH_LONG).show();
        }

        else if(trim_mail.matches(emailPattern)){
            if(pass.length()== 8 && Pass_validation(pass)) {

                Toast.makeText(getApplicationContext(),"You are signed in",Toast.LENGTH_LONG).show();
                if(simpleRadioButton.isChecked()) {
                    Intent intent = new Intent(Sign_in.this, CoachSelection.class);
                    startActivity(intent);
                }
                else if(simpleRadioButton1.isChecked()){
                    Intent intent = new Intent(Sign_in.this, Ticket_Booking.class);
                    startActivity(intent);
                }
            }
            else
                Toast.makeText(getApplicationContext(),"Enter valid password ",Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(getApplicationContext(),"Invalid email ",Toast.LENGTH_LONG).show();
        }




    }

    public static boolean Pass_validation(String str){
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        Pattern pattern= Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher=pattern.matcher(str);
        return matcher.matches();
    }
}

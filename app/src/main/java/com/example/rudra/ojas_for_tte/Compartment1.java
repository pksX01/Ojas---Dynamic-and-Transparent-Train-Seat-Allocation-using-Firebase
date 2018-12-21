package com.example.rudra.ojas_for_tte;


import android.content.Intent;
import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class Compartment1 extends AppCompatActivity {
    public FirebaseDatabase database;
    private DatabaseReference myRef,tteRef;
    private String seat;
    private String str = "";
    private String data1 = "";
    private String data2 = "";
    private String[] phoneNo1 = new String[]{"7011051829","7011983690" };
    private String[] phoneNo2 = new String[]{ "9069686398"};
    private String[] phoneNo3 = new String[]{"8800219145","7827827047"};
    private String[] phoneNo4 = new String[]{"9810739882"};
    private String[] phoneNo5 = new String[]{"9968882472","8368614346"};
    private String[] phoneNo6 = new String[]{"9899646353"};
    private int[] allocated_seats = new int[75];
    private int i = 0, vacant = 0;
    private int[] unallocated_seats = new int[75];

    private List<Button> buttons;
    private static final int[] BUTTON_IDS = {
            R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6,
            R.id.button7, R.id.button8, R.id.button9, R.id.button10/*, R.id.button11, R.id.button12,
            R.id.button13, R.id.button14, R.id.button15, R.id.button16, R.id.button17, R.id.button18,
            R.id.button19, R.id.button20, R.id.button21, R.id.button22, R.id.button23, R.id.button24,
            R.id.button25, R.id.button26, R.id.button27, R.id.button28, R.id.button29, R.id.button30,
            R.id.button31, R.id.button32, R.id.button33, R.id.button34, R.id.button35, R.id.button36,
            R.id.button37, R.id.button38, R.id.button39, R.id.button40, R.id.button41, R.id.button42,
            R.id.button43, R.id.button44, R.id.button45, R.id.button46, R.id.button47, R.id.button48,
            R.id.button49, R.id.button50, R.id.button51, R.id.button52, R.id.button53, R.id.button54,
            R.id.button55, R.id.button56, R.id.button57, R.id.button58, R.id.button59, R.id.button60,
            R.id.button61, R.id.button62, R.id.button63, R.id.button64, R.id.button65, R.id.button66,
            R.id.button67, R.id.button68, R.id.button69, R.id.button70, R.id.button71, R.id.button72,*/
    };

    Button submit_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartment1);
        Bundle bundle1 = getIntent().getExtras();
        data1 = bundle1.get("data1").toString();
        Bundle bundle2 = getIntent().getExtras();
        data2 = bundle2.get("data2").toString();
        database = FirebaseDatabase.getInstance();

        tteRef = database.getReference().child("Tickets checked by TTE");
        myRef=tteRef.child(data1);

       // DatabaseReference waitRef=myRef.child(data2).child("");
        //myAsyncTask myTask = new myAsyncTask();
        //myAsyncTask.execute();

        buttons = new ArrayList<Button>();
        // or slightly better
        // buttons = new ArrayList<Button>(BUTTON_IDS.length);
        for (int id : BUTTON_IDS) {
            final Button button = (Button) findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seat = button.getText().toString();
                    DatabaseReference childRef = myRef.child(data2).child("seat" + seat);
                    childRef.setValue("Yes");
                    button.setBackgroundColor(Color.GREEN);
                    str += seat + ",";
                    //Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                    int seat_no = Integer.parseInt(seat);

                    allocated_seats[i] = seat_no;
                    i++;
                }
            });
            buttons.add(button);
        }


        submit_btn = (Button) findViewById(R.id.submit_btn);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int blank = 0; blank < 12; blank++) {
                    unallocated_seats[blank] = 0;
                }

                for (int j = 1; j <= 12; j++) {
                    int count = 0;
                    for (int k = 0; k < i; k++) {
                        if (j == allocated_seats[k]) {
                            count++;

                        }

                    }
                    if (count == 0) {
                        unallocated_seats[vacant] = j;
                        vacant++;
                    }

                }
                sendSMSMessage();
                Intent intent = new Intent(Compartment1.this, CoachSelection.class);
                startActivity(intent);

            }

        });
    }


    protected void sendSMSMessage() {
        SmsManager smsManager = SmsManager.getDefault();


        //int x;
        //for (x = 0; x < 3; x++) {
        //if (unallocated_seats[x] > 0) {
        //  if (x == 0) {
        if (data1.equals("12561") && data2.equals("S1"))
            smsManager.sendTextMessage(phoneNo1[0], null, "Pavan, You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("12562") && data2.equals("S1"))
            smsManager.sendTextMessage(phoneNo2[0], null, "Piyush, You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("14013") && data2.equals("S1"))
            smsManager.sendTextMessage(phoneNo3[0], null, "Aman, You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("14014") && data2.equals("S1"))
            smsManager.sendTextMessage(phoneNo4[0], null, "Rudra, You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("14017") && data2.equals("S1"))
            smsManager.sendTextMessage(phoneNo5[0], null, "Ojas, You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("14018") && data2.equals("S1"))
            smsManager.sendTextMessage(phoneNo6[0], null, "Piyush Rai, You are allotted seat no. " + unallocated_seats[0] + " in " + data2 + " coach " + "in train " + data1, null, null);
        // }
        // else if (x == 1) {
        if (data1.equals("12561") && data2.equals("S2"))
            smsManager.sendTextMessage(phoneNo1[1], null, "Rishabh, You are allotted seat no. " + unallocated_seats[1] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("14013") && data2.equals("S2"))
            smsManager.sendTextMessage(phoneNo3[1], null, "Rishabh kr, You are allotted seat no. " + unallocated_seats[1] + " in " + data2 + " coach " + "in train " + data1, null, null);
        else if (data1.equals("14017") && data2.equals("S2"))
            smsManager.sendTextMessage(phoneNo5[1], null, "Amit, You are allotted seat no. " + unallocated_seats[1] + " in " + data2 + " coach " + "in train " + data1, null, null);
                    /*else if (x == 2)

                    smsManager.sendTextMessage(phoneNo[2], null, "You are allotted seat no. " + unallocated_seats[2] + " in " + data2 + " coach " + "in train " + data1, null, null);*/
        // }
        //}
        //}
    }
}




    //msg="You are allotted seat no. " + 15 + " in " + data2 + " coach " + "in train " + data1;
    //sendCampaign("RYTRCEI1AGI3I37J8WH2PY2S5PBBWCEA","DZ5S3RK5LUIMXDOS","test","7011051829",msg,"OjasDA");





               /* HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(
                        "https://api.twilio.com/2010-04-01/Accounts/AC6f466aff19dff5ed06db6a348218ee10/SMS/Messages");
                String base64EncodedCredentials = "Basic "
                        + Base64.encodeToString(
                        (ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(),
                        Base64.NO_WRAP);

                httppost.setHeader("Authorization",
                        base64EncodedCredentials);
                try {

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("From",
                            "+19363427205"));
                    nameValuePairs.add(new BasicNameValuePair("To",
                            "+919810739882"));
                    nameValuePairs.add(new BasicNameValuePair("Body",
                            "Welcome to Twilio"));

                    httppost.setEntity(new UrlEncodedFormEntity(
                            nameValuePairs));

                    // Execute HTTP Post Request
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    System.out.println("Entity post is: "
                            + EntityUtils.toString(entity));


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }*/



               /* try {
                    post(getApplicationContext().getString("YOUR_NGROK_URL/sms"), new  Callback(){

                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mTo.setText("");
                                    mBody.setText("");
                                    Toast.makeText(getApplicationContext(),"SMS Sent!",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }*/
   /* public  String sendCampaign(String token,String secret,String usetype, String phone, String message, String senderId){
        StringBuilder content= new StringBuilder();
        try{
            // construct data
            JSONObject urlParameters = new JSONObject();
            urlParameters.put("apikey",token);
            urlParameters.put("secret",secret);
            urlParameters.put("usetype",usetype);
            urlParameters.put("phone", phone);
            urlParameters.put("message", URLEncoder.encode(message,"UTF-8"));
            urlParameters.put("senderid", senderId);
            URL obj = new URL(url + "/api/v1/sendCampaign");
            // send data
            HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(urlParameters.toString().getBytes());
            // get the response
            BufferedReader bufferedReader = null;
            if (httpConnection.getResponseCode() == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
            }

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        }catch(Exception ex){
            //System.out.println('Exception at:',ex);
        }
        Toast.makeText(getApplicationContext(),content.toString(),Toast.LENGTH_LONG).show();
        System.out.println(content.toString());
        return content.toString();


    }*/

/*Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                try {
                    Message message = Message.creator(
                            new com.twilio.type.PhoneNumber("+919810739882"),
                            new com.twilio.type.PhoneNumber("+19363427205"),
                            "hello").create();
                    System.out.println(message.getSid());
                }
                catch(Exception e){
                   System.out.println(e);
                }*/

/* Call post(String url, Callback callback) throws IOException{
            RequestBody formBody = new FormBody.Builder()
                    .add("To", mTo.getText().toString())
                    .add("Body", mBody.getText().toString())
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            Call response = mClient.newCall(request);
            response.enqueue(callback);
            return response;
        }
*/

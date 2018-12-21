package com.example.rudra.ojas_for_tte;
import android.os.AsyncTask;
import android.util.Log;

//
// import com.example.rudra.ojas_for_tte.Compartment1;

import org.apache.http.client.HttpResponseException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class myAsyncTask extends AsyncTask<Void, Void, Void> {
    private static final String SOAP_ACTION = "http://com1/vacant_seats";
    private static final String METHOD_NAME = "vacant_seats";
    private static final String NAMESPACE = "http://com1";
    String URL = "http://localhost:9080/Ojas_Project/services/Allocation?wsdl";
    @Override
    protected Void doInBackground(Void... params) {


        //for linear parameter
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("Seat", Compartment1.class); // adding method property here serially

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.implicitTypes = true;
        envelope.setOutputSoapObject(request);
        envelope.dotNet = true;

        HttpTransportSE httpTransport = new HttpTransportSE(URL);
        httpTransport.debug = true;

        try {
            httpTransport.call(SOAP_ACTION, envelope);
        } catch (HttpResponseException e) {
            // TODO Auto-generated catch block
            Log.e("HTTPLOG", e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Log.e("IOLOG", e.getMessage());
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            Log.e("XMLLOG", e.getMessage());
            e.printStackTrace();
        } //send request

        Object  result = null;
        try {
            result = (Object )envelope.getResponse();
            Log.i("RESPONSE",String.valueOf(result)); // see output in the console
        } catch (SoapFault e) {
            // TODO Auto-generated catch block
            Log.e("SOAPLOG", e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

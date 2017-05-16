package com.acxelense.wootriccsat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.wootric.androidsdk.Wootric;
import com.wootric.androidsdk.objects.WootricCustomMessage;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText country;
    private EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSurvey(View view) {

        // Integrating segment and filters
        // Using CSAT account Client ID, Client Secret and account_token
        Wootric wootric = Wootric.init(this, "582cde53eaf427b977a11e2f7086243db79d0d29aeb5c03d10fb544e4b911c9d",
                "857c872f31b14f5f52a34b81a70cf0c25506e1aaf9fb8fd929d981dd3fdd3014",
                "NPS-344a9bc2");

        // User email address
        wootric.setEndUserEmail("enduser@email.com");

        // User sign up date
        Date date = new Date();
        Long createdAT = date.getTime()/1000;
        wootric.setEndUserCreatedAt(createdAT);

        // User external id
        wootric.setEndUserExternalId("543");

        // Segment and Filters using customer properties
        country = (EditText)findViewById(R.id.country);
        age = (EditText)findViewById(R.id.age);

        HashMap<String, String> endUserDetails = new HashMap<String, String>();
        endUserDetails.put("country", country.getText().toString());
        endUserDetails.put("age_amount", age.getText().toString());

        wootric.setProperties(endUserDetails);

        // Customize follow up message/question after getting score
        WootricCustomMessage customMessage = new WootricCustomMessage();
        customMessage.setFollowupQuestion("Thank You! Please help us by feedback");
        customMessage.setPlaceholderText("Write brief explanation behind your score for us");

        wootric.setCustomMessage(customMessage);

        // Use only for testing
        wootric.setSurveyImmediately(true);

        // Start survey
        wootric.survey();

    }
}

package com.acxelense.wootriccsat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wootric.androidsdk.Wootric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSurvey(View view) {

        // Integrating only for users as visitors

        // Using CSAT account Client ID, Client Secret and account_token
//        Wootric wootric = Wootric.init(this, "582cde53eaf427b977a11e2f7086243db79d0d29aeb5c03d10fb544e4b911c9d",
//                "857c872f31b14f5f52a34b81a70cf0c25506e1aaf9fb8fd929d981dd3fdd3014",
//                "NPS-344a9bc2");

        // Using NPS account Client ID, Client Secret and CSAT account account_token
        Wootric wootric = Wootric.init(this, "a20aa3f3771bca36cd584b823b6eaec9bcab6bcb03c074e46b180bb51c8981c9",
                "600febdef35889597d897bacd99c95ed9caff61ebcf7db1d906308f9c0982016",
                "NPS-344a9bc2");


        // Use only for testing
        wootric.setSurveyImmediately(true);

        // Start survey
        wootric.survey();

    }
}

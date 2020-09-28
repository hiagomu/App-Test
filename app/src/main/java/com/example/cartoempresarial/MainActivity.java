package com.example.cartoempresarial;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView siteTextView;
    private TextView phoneTextView;
    private TextView mapTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siteTextView = findViewById(R.id.textViewSite);
        mapTextView = findViewById(R.id.textViewMap);
        phoneTextView = findViewById(R.id.textViewPhone);

        siteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("https://www.mojang.com/");
            }
        });
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber("08009000");
            }
        });
        mapTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMap();
            }
        });
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    private final String LOCATION = "geo: -1.448335, -48.491768?z=18";

    private void showMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(LOCATION));
        startActivity(intent);
    }
}

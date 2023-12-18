package com.example.voicegear;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;


import com.example.voicegear.R;


public class MainActivity extends AppCompatActivity {

    private static final int DELAY_MILLIS = 3000; // 3 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        // Handler to delay transition to the privacy screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start PrivacyActivity after the delay
                startActivity(new Intent(MainActivity.this, Privacy.class));
                finish(); // Optional: Close MainActivity to prevent going back
            }
        }, DELAY_MILLIS);

        // Set an OnClickListener for the main screen ImageView
        ImageView mainImage = findViewById(R.id.backgroundImage);
        if (mainImage != null) {
            mainImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Navigate to PrivacyActivity when the image is clicked
                    startActivity(new Intent(MainActivity.this, Privacy.class));
                    finish(); // Optional: Close MainActivity to prevent going back
                }
            });
        }
    }


}

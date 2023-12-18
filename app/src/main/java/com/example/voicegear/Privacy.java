package com.example.voicegear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;



public class Privacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);

        // Initialize views
        CheckBox privacyCheckbox = findViewById(R.id.privacyCheckbox);
        Button agreeButton = findViewById(R.id.agreeButton);

        // Disable the "I Agree" button initially
        agreeButton.setEnabled(false);

        // Set a listener on the checkbox to enable/disable the "I Agree" button
        privacyCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            agreeButton.setEnabled(isChecked);
        });

        // Set a click listener for the "I Agree" button
        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the WelcomeActivity when "I Agree" is clicked
                startActivity(new Intent(Privacy.this, WelcomeActivity.class));
                finish(); // Optional: Close PrivacyActivity to prevent going back
            }

        });
    }
}

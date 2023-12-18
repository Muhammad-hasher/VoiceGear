package com.example.voicegear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.voicegear.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        Button connectButton = findViewById(R.id.loginButton);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to BluetoothConnectActivity
                Intent intent = new Intent(WelcomeActivity.this, BluetoothConnectionActivity.class);
                startActivity(intent);
            }
        });
    }
}

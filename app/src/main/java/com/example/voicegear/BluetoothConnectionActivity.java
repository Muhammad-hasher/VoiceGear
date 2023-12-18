package com.example.voicegear;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class BluetoothConnectionActivity extends AppCompatActivity {

    private TextView infoTextView;
    private Button connectButton;
    private ImageView bluetoothImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_connect);

        infoTextView = findViewById(R.id.Bluetoothinfo);
        connectButton = findViewById(R.id.connectButton);
        bluetoothImageView = findViewById(R.id.bluetoothImageView);
    }

    // Method to initiate Bluetooth connection
    public void initiateBluetoothConnection(View view) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Toast.makeText(this, "Bluetooth not supported on this device", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!bluetoothAdapter.isEnabled()) {
            // Bluetooth is not enabled, prompt the user to enable it
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivityForResult(enableBtIntent, 1);
        } else {
            // Bluetooth is enabled, proceed with connection logic
            // Replace "00:11:22:33:44:55" with the Bluetooth device address you want to connect to
            String deviceAddress = "00:11:22:33:44:55";
            BluetoothDevice device = bluetoothAdapter.getRemoteDevice(deviceAddress);

            // Add your Bluetooth connection logic here
            // For example, you might use BluetoothSocket and BluetoothDevice classes
            try {
                // UUID should match the UUID of your Bluetooth service
                // This is just an example UUID, replace it with your actual UUID
                java.util.UUID uuid = java.util.UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
                BluetoothSocket socket = device.createRfcommSocketToServiceRecord(uuid);
                socket.connect();
                // Now you have a connected Bluetooth socket (socket) that you can use for communication
                Toast.makeText(this, "Bluetooth connected successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                // Handle connection errors
                Toast.makeText(this, "Bluetooth connection failed", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Handle the result of enabling Bluetooth
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // Bluetooth was successfully enabled
                // Proceed with connection logic
                // Add your Bluetooth connection logic here
            } else {
                // User declined to enable Bluetooth
                Toast.makeText(this, "Bluetooth must be enabled to connect", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

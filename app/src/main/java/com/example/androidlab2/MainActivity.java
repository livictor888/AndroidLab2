package com.example.androidlab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeBackground(View view) {
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        ConstraintLayout testView = findViewById(R.id.background);
        testView.setBackgroundColor(color);
    }

    public void textToSpeech(View view) {
        Intent speechIntent = new Intent(this, SpeakActivity.class);
        startActivity(speechIntent);
    }

    public void showAPIVersion(View view) {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        int version = Build.VERSION.SDK_INT;
        String versionRelease = Build.VERSION.RELEASE;
        String messageText = " manufacturer " + manufacturer
                + " \n model " + model
                + " \n version " + version
                + " \n versionRelease " + versionRelease;
        Log.e("MainActivity", messageText);
        Toast toast = Toast.makeText(getApplicationContext(), messageText,Toast.LENGTH_SHORT);
        TextView toastView =  toast.getView().findViewById(android.R.id.message);
        toastView.setTextColor(Color.RED);
        toast.show() ;
    }

    public void showSerialNumber(View view) {
        String deviceId = Settings.System.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.e("MainActivity", deviceId);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, deviceId);
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}
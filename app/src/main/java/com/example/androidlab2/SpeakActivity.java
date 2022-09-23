package com.example.androidlab2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class SpeakActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);

        text = findViewById(R.id.textInputEditText);
        btn = findViewById(R.id.speakButton);

        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.UK);
            }
        });
    }

    public void speakButton(View view) {
        tts.speak(text.getText().toString(), TextToSpeech.QUEUE_FLUSH,null, null);
    }

    public void backButton(View view) {
        Intent speechIntent = new Intent(this, MainActivity.class);
        startActivity(speechIntent);
    }
}



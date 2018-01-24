package com.auribises.myfirstapp;

import android.app.ProgressDialog;
import android.os.Build;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyVoiceRecognitionActivity extends AppCompatActivity implements View.OnClickListener,RecognitionListener{


    @InjectView(R.id.textViewData)
    TextView txtData;

    @InjectView(R.id.buttonActivate)
    Button btnActivate;

    SpeechRecognizer speechRecognizer;
    TextToSpeech textToSpeech;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voice_recognition);

        ButterKnife.inject(this);

        btnActivate.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Listening...");

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(TextToSpeech.SUCCESS == status){
                    Toast.makeText(MyVoiceRecognitionActivity.this,"TTS Initialized",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MyVoiceRecognitionActivity.this,"TTS Not Initialized",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(this);
        speechRecognizer.startListening(RecognizerIntent.getVoiceDetailsIntent(this));


    }

    @Override
    public void onReadyForSpeech(Bundle params) {

    }

    @Override
    public void onBeginningOfSpeech() {
        progressDialog.show();
    }

    @Override
    public void onRmsChanged(float rmsdB) {

    }

    @Override
    public void onBufferReceived(byte[] buffer) {

    }

    @Override
    public void onEndOfSpeech() {
        progressDialog.dismiss();
    }

    @Override
    public void onError(int error) {

    }

    @Override
    public void onResults(Bundle results) {

        ArrayList<String> list = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        StringBuffer  buffer = new StringBuffer();

        for(String str : list){
            buffer.append(str+"\n");
        }

        txtData.setText(buffer.toString());

        if(Build.VERSION.SDK_INT >= 21) {
            textToSpeech.speak(buffer.toString(), TextToSpeech.QUEUE_FLUSH, null, null);
        }else {
            textToSpeech.speak(buffer.toString(), TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    public void onPartialResults(Bundle partialResults) {

    }

    @Override
    public void onEvent(int eventType, Bundle params) {

    }
}

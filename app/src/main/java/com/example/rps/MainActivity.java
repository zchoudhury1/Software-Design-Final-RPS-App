package com.example.rps;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //All variables for texts in the XML file
    private MultiAutoCompleteTextView message;
    private TextView Result;
    private RPSGamePlay rpsGamePlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Result=findViewById(R.id.Result);
         message=findViewById(R.id.Title_Text);
         //Initialize buttons
         Button Rock=findViewById(R.id.Rock);
         Button Paper=findViewById(R.id.Papper);
         Button Scicorrs=findViewById(R.id.Siccors);
         rpsGamePlay=new RPSGamePlay(Rock);
         //If any of these buttons are clicked the .play() function returns a string
         Rock.setOnClickListener(v -> Result.setText(rpsGamePlay.play(Rock)));
         Paper.setOnClickListener(v-> Result.setText(rpsGamePlay.play(Paper)));
         Scicorrs.setOnClickListener(v-> Result.setText(rpsGamePlay.play(Scicorrs)));

    }

}
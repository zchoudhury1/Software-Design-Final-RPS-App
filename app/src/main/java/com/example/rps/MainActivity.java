package com.example.rps;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //All variables for texts in the XML file
    private MultiAutoCompleteTextView message;
    private TextView Result;
    private RPSGamePlay rpsGamePlay;

    public static final String db = "RPS_DataBase";
    public static final String win = "Wins";
    public static final String draw = "Draws";
    public static final String loss = "Losses";


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
         Rock.setOnClickListener(new View.OnClickListener()
         {
             @Override
             public void onClick(View view)
             {
                 saveData();
             }
         });
         Paper.setOnClickListener(v-> Result.setText(rpsGamePlay.play(Paper)));
        Paper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveData();
            }
        });
         Scicorrs.setOnClickListener(v-> Result.setText(rpsGamePlay.play(Scicorrs)));
        Scicorrs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveData();
            }
        });


    }
    public void saveData()
    {
        SharedPreferences thesePreferences = getSharedPreferences(db , MODE_PRIVATE);
        SharedPreferences.Editor thesePrefEditor =  thesePreferences.edit();
        // I need to get the old data and add the current wins and losses and draws
        thesePrefEditor.putInt(win, rpsGamePlay.getWins());
        thesePrefEditor.putInt(loss, rpsGamePlay.getLosses());
        thesePrefEditor.putInt(draw, rpsGamePlay.getDraw());
    }
    public void loadData()
    {
        SharedPreferences thesePreferences = getSharedPreferences(db, MODE_PRIVATE);
        rpsGamePlay.setDraw(thesePreferences.getInt(draw, 0));
        rpsGamePlay.setWins(thesePreferences.getInt(win, 0));
        rpsGamePlay.setLosses(thesePreferences.getInt(loss, 0));
    }

}
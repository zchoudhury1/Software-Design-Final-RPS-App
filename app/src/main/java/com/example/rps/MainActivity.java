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
    public static final String numGames = "Games Played";
    public static final String rocksPlayed = "Rocks Played";
    public static final String papersPlayed = "Papers Played";
    public static final String scissorsPlayed = "scissors Played";



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
        //if it is zero check our db if it has the values and load them in
        if(rpsGamePlay.getDraw() == 0 && rpsGamePlay.getLosses() == 0 && rpsGamePlay.getWins() == 0)
        {
            loadData();
        }
        //If any of these buttons are clicked the .play() function returns a string
        Rock.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                Result.setText(rpsGamePlay.play(Rock));
                saveData();
            }
        });
        Paper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Result.setText(rpsGamePlay.play(Paper));
                saveData();
            }
        });
        Scicorrs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Result.setText(rpsGamePlay.play(Scicorrs));
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
        thesePrefEditor.putInt(rocksPlayed, rpsGamePlay.getRockCount());
        thesePrefEditor.putInt(scissorsPlayed, rpsGamePlay.getScissorCount());
        thesePrefEditor.putInt(papersPlayed, rpsGamePlay.getPaperCount());
        thesePrefEditor.putInt(numGames,rpsGamePlay.getDraw()+rpsGamePlay.getWins()+rpsGamePlay.getLosses());
        thesePrefEditor.commit();

    }
    public void loadData()
    {
        SharedPreferences thesePreferences = getSharedPreferences(db, MODE_PRIVATE);
        rpsGamePlay.setDraw(thesePreferences.getInt(draw, 0));
        rpsGamePlay.setWins(thesePreferences.getInt(win, 0));
        rpsGamePlay.setLosses(thesePreferences.getInt(loss, 0));
        rpsGamePlay.setRockCount(thesePreferences.getInt(rocksPlayed, 0));
        rpsGamePlay.setScissorCount(thesePreferences.getInt(scissorsPlayed, 0));
        rpsGamePlay.setPaperCount(thesePreferences.getInt(papersPlayed, 0));
    }

}
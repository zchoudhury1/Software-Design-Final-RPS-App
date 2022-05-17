package com.example.rps;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;


public class PlayerStats extends AppCompatActivity {
    private TextView gpNums;
    private TextView winNums;
    private TextView lossNums;
    private TextView drawNums;
    private TextView rockNums;
    private TextView paperNums;
    private TextView scissorNums;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_stats);

        gpNums = findViewById(R.id.gpNum);
        winNums = findViewById(R.id.winNum);
        lossNums= findViewById(R.id.lossNum);
        drawNums =findViewById(R.id.drawNum);
        rockNums = findViewById(R.id.rpNum);
        paperNums = findViewById(R.id.ppNum);
        scissorNums = findViewById(R.id.spNum);
        loadData(gpNums,winNums,lossNums,drawNums,rockNums,paperNums,scissorNums);

        Button reset = findViewById(R.id.RESET_STATS);
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                resetData();
                loadData(gpNums,winNums,lossNums,drawNums,rockNums,paperNums,scissorNums);
            }
        });
    }
    public void loadData(TextView gp, TextView w, TextView l, TextView d, TextView rp, TextView pp, TextView sp)
    {
        SharedPreferences thesePreferences = getSharedPreferences(MainActivity.db, MODE_PRIVATE);
        d.setText(""+thesePreferences.getInt(MainActivity.draw, 0));
        w.setText(""+thesePreferences.getInt(MainActivity.win, 0));
        l.setText(""+thesePreferences.getInt(MainActivity.loss, 0));
        rp.setText(""+thesePreferences.getInt(MainActivity.rocksPlayed, 0));
        sp.setText(""+thesePreferences.getInt(MainActivity.scissorsPlayed, 0));
        pp.setText(""+thesePreferences.getInt(MainActivity.papersPlayed, 0));
        gp.setText(""+thesePreferences.getInt(MainActivity.numGames,0));
    }
    public void resetData()
    {
        SharedPreferences thesePreferences = getSharedPreferences(MainActivity.db , MODE_PRIVATE);
        SharedPreferences.Editor thesePrefEditor =  thesePreferences.edit();
        // I need to get the old data and add the current wins and losses and draws
        thesePrefEditor.putInt(MainActivity.win, 0);
        thesePrefEditor.putInt(MainActivity.loss, 0);
        thesePrefEditor.putInt(MainActivity.draw, 0);
        thesePrefEditor.putInt(MainActivity.numGames, 0);
        thesePrefEditor.putInt(MainActivity.rocksPlayed, 0);
        thesePrefEditor.putInt(MainActivity.papersPlayed, 0);
        thesePrefEditor.putInt(MainActivity.scissorsPlayed, 0);
        thesePrefEditor.commit();
    }
}
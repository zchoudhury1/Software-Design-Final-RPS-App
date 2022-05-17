package com.example.rps;
import android.content.SharedPreferences;
import android.content.Context;
import android.preference.PreferenceManager;
import android.widget.Button;
import androidx.annotation.VisibleForTesting;
import com.example.rps.MainActivity;


import java.util.Random;
import java.util.logging.Logger;

import static android.content.Context.MODE_PRIVATE;


public class RPSGamePlay {
    private Button button;

    private int wins = 0;
    private int losses = 0;
    private int draw = 0;
    private int rockCount = 0;
    private int paperCount = 0;
    private int scissorCount = 0;


    //All possible choices for the AI to play
    final private String[] AI_Choices={"Rock","Paper","Scissor"};
    public RPSGamePlay(Button B){
        this.button=B;
    }
    //Gameplay based on button selected
    public String play(Button B){
        this.button=B;
            String Player_Choice;
        switch (button.getText().toString()) {
            case "Rock":
                Player_Choice="Rock";
                break;
            case "Scissor":
                Player_Choice="Scissor";
                break;
            case "Paper":
                Player_Choice="Paper";
                break;
            default:
                Player_Choice="Click again";
                return Player_Choice;
        }

        return RULE(Player_Choice,AI_Play());
    }

    protected String RULE(String player_Move,String opponentMove){
        handPlayedCount(player_Move);
        if(player_Move.equals(opponentMove)) {
            draw++;
            return "Computer played: " + opponentMove+ " Its a Tie :P";
        }
        //All possible cases of player winning
        else if((player_Move.equals("Rock") && opponentMove.equals("Scissor")) || (player_Move.equals("Scissor") &&
                opponentMove.equals("Paper")) || (player_Move.equals("Paper") && opponentMove.equals("Rock"))) {

            wins++;
            return "Computer played: " + opponentMove+ " You Win :)";

        }else{
            losses++;
            return "Computer played: " + opponentMove+ " You Lose :(";
        }
    }

    public void handPlayedCount(String player_Move)
    {
        if(player_Move.equals("Rock"))
        {
            rockCount++;
        }else if(player_Move.equals("Paper")) {
            paperCount++;
        }else
        {
            scissorCount++;
        }
    }

    public int getWins()
    {
        return wins;
    }
    public int getLosses()
    {
        return losses;
    }
    public int getDraw()
    {
        return draw;
    }
    public int getRockCount()
    {
        return rockCount;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public int getScissorCount() {
        return scissorCount;
    }


    public void setWins(int w)
    {

    }
    public void setLosses(int l)
    {
        losses = l;
    }
    public void setDraw(int d)
    {
        draw = d;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public void setRockCount(int rockCount) {
        this.rockCount = rockCount;
    }

    public void setScissorCount(int scissorCount) {
        this.scissorCount = scissorCount;
    }

    protected String AI_Play(){
        //Get a random from 0-2 as the AI's choice
        int randomNum=(int)(Math.random()*3);
        return AI_Choices[randomNum];
    }

}

package com.example.rps;
import android.widget.Button;
import androidx.annotation.VisibleForTesting;
import com.example.rps.MainActivity;

import java.util.Random;
import java.util.logging.Logger;

public class RPSGamePlay {
    private Button button;

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
        if(player_Move.equals(opponentMove)) {
            return "Tie....";
        }
        //All possible cases of player winning
        else if((player_Move.equals("Rock") && opponentMove.equals("Scissor")) || (player_Move.equals("Scissor") &&
                opponentMove.equals("Paper")) || (player_Move.equals("Paper") && opponentMove.equals("Rock"))) {

            return "You Win....";
        }else{
            return "You Lost...";
        }
    }

    protected String AI_Play(){
        //Get a random from 0-2 as the AI's choice
        int randomNum=(int)(Math.random()*3);
        return AI_Choices[randomNum];
    }

}

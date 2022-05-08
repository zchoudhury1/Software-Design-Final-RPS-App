package com.example.rps;

import android.widget.Button;
import androidx.annotation.VisibleForTesting;
import org.junit.Rule;
import org.junit.Test;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest extends AppCompatActivity{
    @Test
    public void RPSGamePlayTest_RULE() {

        RPSGamePlay rpsGame=new RPSGamePlay(null);

       String result=rpsGame.RULE("Rock","Scissor");

        assertEquals(result, "You Win....");
    }
}
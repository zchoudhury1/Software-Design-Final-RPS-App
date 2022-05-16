package com.example.rps;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    private Button Singleplayer;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Singleplayer=findViewById(R.id.singleplayer);
        Singleplayer.setOnClickListener(v -> {
                    openGamePlayActivity();
        });

    }
    //Creates popup menu in view
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    //Controlles iteams in popup menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.GameRules:
                openGameRules();
                 break;
            case R.id.PlayerStats:
                Toast.makeText(this, "PlayerStats", Toast.LENGTH_SHORT).show();
                break;
            default:
               return super.onOptionsItemSelected(item);
        }
        return true;
    }

    //function for opening screen with single player gameplay
    public void openGamePlayActivity(){
        Intent intent= new Intent(this, MainActivity.class );
        startActivity(intent);

    }
    //Function for opening screen with game rules
    public void openGameRules(){
        dialogbuilder= new AlertDialog.Builder(this);
        final View popup= getLayoutInflater().inflate(R.layout.rules_pop_up,null);
        dialogbuilder.setView(popup);
        dialog=dialogbuilder.create();
        dialog.show();
    }
}
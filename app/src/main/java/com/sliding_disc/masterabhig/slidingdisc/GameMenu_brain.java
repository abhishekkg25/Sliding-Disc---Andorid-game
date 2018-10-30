package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameMenu_brain extends AppCompatActivity {
public  void Brain_game(View v)
{
    Intent intent=new Intent(this,BrainGame.class);
    startActivity(intent);
}
public  void brain_introduction(View v)
{
    Intent intent=new Intent(this,brain_intro.class);
    startActivity(intent);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu_brain);
    }
}

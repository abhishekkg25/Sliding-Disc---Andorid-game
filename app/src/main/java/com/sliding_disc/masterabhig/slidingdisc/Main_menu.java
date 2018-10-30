package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Main_menu extends AppCompatActivity {
public  void sliding_disc(View v)
{
    Intent intent=new Intent(this,GameMenu.class);
    startActivity(intent);
}
    public  void brain_checker(View v)
    {
        Intent intent=new Intent(this,GameMenu_brain.class);
        startActivity(intent);
    }
    public  void flying_bro(View v)
    {
       Intent intent=new Intent(this,GameMenu_flying.class);
        startActivity(intent);
    }
    public  void introduction(View v)
    {
        Intent intent=new Intent(this,Introduction_sliding.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }
}

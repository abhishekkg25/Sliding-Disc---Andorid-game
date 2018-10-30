package com.sliding_disc.masterabhig.slidingdisc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Introduction_sliding extends AppCompatActivity {
TextView t1;
String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction_sliding);
        t1=(TextView)findViewById(R.id.textView8);
        s="INTRODUCTION:\n This game is for fun.Not too much brain is required.you have to make your continuous three slide inline to win.You can make that horizontally " +
                "Vertically or diagonaly.You can play with your friend or your mobile machine.You can play single match or series of 3 or 5 matches.Your score card will update after your each game.So play and enjoy :)";
        t1.setText(s);
    }
}

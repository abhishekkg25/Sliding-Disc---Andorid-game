package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Game_with_computer extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout r1;
    TextView t1,t2,t3;
    static MediaPlayer mp1,mp2;
    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9;
    int activePlayer=0,no1=0,no2=0,match=1;
    Button b1,b2;
    int [] gameState={2,2,2,2,2,2,2,2,2}; //slot is empty
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    LinearLayout l1;
    GridLayout g1;
    boolean gameActive=true;
    String s1,s2,s3,s4,s5,winner;
    public void Play_again(View v)
    {
        t1.setVisibility(View.VISIBLE);
        t2.setText(s3+"'s"+" turn");
        g1.setVisibility(View.VISIBLE);
        gameActive=true;
        l1.setVisibility(View.INVISIBLE);
        activePlayer=0;
        for (int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        i1.setAlpha(0f); i2.setAlpha(0f); i3.setAlpha(0f); i4.setAlpha(0f); i5.setAlpha(0f); i6.setAlpha(0f); i7.setAlpha(0f); i8.setAlpha(0f); i9.setAlpha(0f);
    }
    public  void Exitt(View v)
    {
        Intent intent=new Intent(this,GameMenu.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_computer);
        r1=(RelativeLayout)findViewById(R.id.relative_game);
        r1.getBackground().setAlpha(120);
        t1=(TextView)findViewById(R.id.textView9);
        t2=(TextView)findViewById(R.id.textView3);
        t3=(TextView)findViewById(R.id.textView10);
        b1=(Button)findViewById(R.id.Oky);
        b2=(Button)findViewById(R.id.exits);
        g1=(GridLayout)findViewById(R.id.gridLayout);
        l1=(LinearLayout)findViewById(R.id.LinearLayout);

        Animation obj= AnimationUtils.loadAnimation(this,R.animator.anim);
        t2.startAnimation(obj);
        i1=(ImageView)findViewById(R.id.imageView16);
        i2=(ImageView)findViewById(R.id.imageView17);
        i3=(ImageView)findViewById(R.id.imageView18);
        i4=(ImageView)findViewById(R.id.imageView19);
        i5=(ImageView)findViewById(R.id.imageView20);
        i6=(ImageView)findViewById(R.id.imageView21);
        i7=(ImageView)findViewById(R.id.imageView22);
        i8=(ImageView)findViewById(R.id.imageView23);
        i9=(ImageView)findViewById(R.id.imageView24);
        if(mp1==null){
            mp1=MediaPlayer.create(this,R.raw.player1);}
        if(mp2==null){
            mp2=MediaPlayer.create(this,R.raw.player2);}
        i1.setOnClickListener(this);
        i2.setOnClickListener(this);
        i3.setOnClickListener(this);
        i4.setOnClickListener(this);
        i5.setOnClickListener(this);
        i6.setOnClickListener(this);
        i7.setOnClickListener(this);
        i8.setOnClickListener(this);
        i9.setOnClickListener(this);
        l1.setVisibility(View.INVISIBLE);
        s1=getIntent().getStringExtra("Disc");
        s2=getIntent().getStringExtra("Name");
        s5=getIntent().getStringExtra("Series");
        t1.setText("Match status:\n"+"Series: "+s5+"       "+"Match: "+match+"\n"+s2+": "+no1+"       "+"Machine: "+": "+no2);
        t2.setText(s2+"'s"+" turn");
    }

    @Override
    public void onClick(View view) {

        int id=view.getId();
        int tapcounter=Integer.parseInt(view.getTag().toString());
        if(gameState[tapcounter]==2 && gameActive) {
            if (id == R.id.imageView16) {

                gameState[tapcounter]=activePlayer;
                i1.setTranslationX(-1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i1.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i1.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i1.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i1.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i1.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            i1.setImageResource(R.drawable.grey);
                        }
                    }, 2000);

                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i1.setAlpha(1f);
                i1.animate().translationXBy(1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView17) {

                gameState[tapcounter]=activePlayer;
                i2.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i2.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i2.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i2.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i2.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i2.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i2.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i2.setAlpha(1f);
                i2.animate().translationYBy(1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView18) {

                gameState[tapcounter]=activePlayer;
                i3.setTranslationX(1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i3.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i3.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i3.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i3.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i3.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i3.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i3.setAlpha(1f);
                i3.animate().translationXBy(-1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView19) {

                gameState[tapcounter]=activePlayer;
                i4.setTranslationX(-1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i4.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i4.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i4.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i4.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i4.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i4.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i4.setAlpha(1f);
                i4.animate().translationXBy(1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView20) {

                gameState[tapcounter]=activePlayer;
                i5.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i5.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i5.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i5.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i5.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i5.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i5.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i5.setAlpha(1f);
                i5.animate().translationYBy(1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView21) {

                gameState[tapcounter]=activePlayer;
                i6.setTranslationX(1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i6.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i6.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i6.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i6.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i6.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i6.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i6.setAlpha(1f);
                i6.animate().translationXBy(-1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView22) {

                gameState[tapcounter]=activePlayer;
                i7.setTranslationX(-1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i7.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i7.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i7.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i7.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i7.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i7.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i7.setAlpha(1f);
                i7.animate().translationXBy(1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView23) {

                gameState[tapcounter]=activePlayer;
                i8.setTranslationY(1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i8.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i8.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i8.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i8.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i8.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i8.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i8.setAlpha(1f);
                i8.animate().translationYBy(-1000f).rotation(360).setDuration(300);
            }
            if (id == R.id.imageView24) {

                gameState[tapcounter] = activePlayer;
                i9.setTranslationX(1000f);
                if (activePlayer == 0) {
                    mp1.start();
                    if (s1.equals("Blue"))
                        i9.setImageResource(R.drawable.blue);
                    if (s1.equals("Green"))
                        i9.setImageResource(R.drawable.green);
                    if (s1.equals("Yellow"))
                        i9.setImageResource(R.drawable.yellow);
                    if (s1.equals("Orange"))
                        i9.setImageResource(R.drawable.orange);
                    if (s1.equals("Red"))
                        i9.setImageResource(R.drawable.red);
                    activePlayer = 1;
                    t2.setText(s4+"'s"+" turn");
                } else {
                    mp2.start();
                        i9.setImageResource(R.drawable.grey);
                    activePlayer = 0;
                    t2.setText(s3+"'s"+" turn");
                }
                i9.setAlpha(1f);
                i9.animate().translationXBy(-1000f).rotation(360).setDuration(300);
            }
        }

        for(int[] winnig:winningPositions)
        {
            if((gameState[winnig[0]]==gameState[winnig[1]])&&(gameState[winnig[1]] ==gameState[winnig[2]]) && gameState[winnig[0]]!=2 ){
                if(gameState[winnig[0]]==0)
                {winner=s3; no1++;match++;
                    t1.setText("Match status:\n"+"Series: "+s5+"       "+"Match: "+match+"\n"+s3+": "+no1+"       "+"Machine: "+": "+no2);}
                if(gameState[winnig[0]]==1)
                { winner=s4; no2++;match++;
                    t1.setText("Match status:\n"+"Series: "+s5+"       "+"Match: "+match+"\n"+s3+": "+no1+"       "+"Machine: "+": "+no2);}
                l1.setVisibility(View.VISIBLE);
                t3.setText(winner+ " has won!");
                g1.setVisibility(View.INVISIBLE);
                t1.setVisibility(View.INVISIBLE);
                t2.setText("");

                gameActive=false;
            } else {
                boolean gameIsover=true;
                for(int counterState : gameState)
                {
                    if(counterState==2) gameIsover=false;
                }
                if(gameIsover)
                {
                    t3.setText("It's a Draw :D");
                    l1.setVisibility(View.VISIBLE);
                    g1.setVisibility(View.INVISIBLE);
                    t1.setVisibility(View.INVISIBLE);
                    t2.setText("");
                }
            }
        }
    }
}

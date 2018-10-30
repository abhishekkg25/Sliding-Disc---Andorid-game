package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameMenu extends AppCompatActivity implements View.OnClickListener {
    public void play_with_friend(View view){
        mp2.start();
        mp1.stop();
        Intent i=new Intent(this,Fill.class);
        startActivity(i);
    }
ImageView i1,i2,i3,i4,i5,i6;
int z=0;
static MediaPlayer mp1,mp2;
ImageButton ib1,ib2;
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);
         i1=(ImageView)findViewById(R.id.imageView7);
         i2=(ImageView)findViewById(R.id.imageView9);
         i3=(ImageView)findViewById(R.id.imageView10);
         i4=(ImageView)findViewById(R.id.imageView11);
         i5=(ImageView)findViewById(R.id.imageView12);
         i6=(ImageView)findViewById(R.id.imageView13);
         b1=(Button)findViewById(R.id.button4);
        b2=(Button)findViewById(R.id.button3);
        b3=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
             Animation_of_menu_page();
             if(mp1==null)
             {
                 mp1=MediaPlayer.create(this,R.raw.back_sliding_disc);
             }
        if(mp2==null)
        {
            mp2=MediaPlayer.create(this,R.raw.button_click);
        }
             mp1.start();
             mp1.setLooping(true);
    }

    private void Animation_of_menu_page() {
        i1.setTranslationX(-1000f);
        i3.setTranslationX(-1000f);
        i5.setTranslationX(1000f);
        i2.setTranslationY(-1000f);
        i4.setTranslationY(1000f);
        i6.setTranslationY(1000f);

        i1.animate().translationXBy(1000f).setDuration(2000);
        i3.animate().translationXBy(1000f).setDuration(2000);
        i5.animate().translationXBy(-1000f).setDuration(3000);
        i2.animate().translationYBy(1000f).setDuration(1000);
        i4.animate().translationYBy(-1000f).setDuration(5000);
        i6.animate().translationYBy(-1000f).setDuration(4000);

    Handler h = new Handler();
    h.postDelayed(new Runnable() {
        @Override
        public void run() {
            i1.animate().translationXBy(-1000f).setDuration(2000);
            i3.animate().translationXBy(-1000f).setDuration(2000);
            i5.animate().translationXBy(1000f).setDuration(3000);
            i2.animate().translationYBy(-1000f).setDuration(1000);
            i4.animate().translationYBy(1000f).setDuration(5000);
            i6.animate().translationYBy(1000f).setDuration(4000);
        }
    }, 5050 );
    Handler h1 = new Handler();
    h1.postDelayed(new Runnable() {
        @Override
        public void run() {
            i1.animate().translationXBy(1000f).setDuration(2000);
            i3.animate().translationXBy(1000f).setDuration(2000);
            i5.animate().translationXBy(-1000f).setDuration(3000);
            i2.animate().translationYBy(1000f).setDuration(1000);
            i4.animate().translationYBy(-1000f).setDuration(5000);
            i6.animate().translationYBy(-1000f).setDuration(4000);
        }
    }, 10050);
        Handler h2 = new Handler();
        h2.postDelayed(new Runnable() {
            @Override
            public void run() {
                i1.animate().translationXBy(-1000f).setDuration(2000);
                i3.animate().translationXBy(-1000f).setDuration(2000);
                i5.animate().translationXBy(1000f).setDuration(3000);
                i2.animate().translationYBy(-1000f).setDuration(1000);
                i4.animate().translationYBy(1000f).setDuration(5000);
                i6.animate().translationYBy(1000f).setDuration(4000);
            }
        }, 15050 );
        Handler h3 = new Handler();
        h3.postDelayed(new Runnable() {
            @Override
            public void run() {
                i1.animate().translationXBy(1000f).setDuration(2000);
                i3.animate().translationXBy(1000f).setDuration(2000);
                i5.animate().translationXBy(-1000f).setDuration(3000);
                i2.animate().translationYBy(1000f).setDuration(1000);
                i4.animate().translationYBy(-1000f).setDuration(5000);
                i6.animate().translationYBy(-1000f).setDuration(4000);
            }
        }, 20050);
        Handler h5 = new Handler();
        h5.postDelayed(new Runnable() {
            @Override
            public void run() {
                i1.animate().translationXBy(-1000f).setDuration(2000);
                i3.animate().translationXBy(-1000f).setDuration(2000);
                i5.animate().translationXBy(1000f).setDuration(3000);
                i2.animate().translationYBy(-1000f).setDuration(1000);
                i4.animate().translationYBy(1000f).setDuration(5000);
                i6.animate().translationYBy(1000f).setDuration(4000);
            }
        }, 25050 );
        Handler h4 = new Handler();
        h4.postDelayed(new Runnable() {
            @Override
            public void run() {
                i1.animate().translationXBy(1000f).setDuration(2000);
                i3.animate().translationXBy(1000f).setDuration(2000);
                i5.animate().translationXBy(-1000f).setDuration(3000);
                i2.animate().translationYBy(1000f).setDuration(1000);
                i4.animate().translationYBy(-1000f).setDuration(5000);
                i6.animate().translationYBy(-1000f).setDuration(4000);
            }
        }, 30050);
}


    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.button3)
        {
            mp2.start();
            Intent intent=new Intent(this,Introduction_sliding.class);
            startActivity(intent);
        }
        if(id==R.id.button4)
        {
            mp2.start();
        }
        if(id==R.id.button2)
        {
            mp2.start();
            Intent intent =new Intent(this,Fill_single.class);
            startActivity(intent);
        }
    }
}


package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView i1=(ImageView)findViewById(R.id.imageView4);
        ImageView i2=(ImageView)findViewById(R.id.imageView5);
        ImageView i3=(ImageView)findViewById(R.id.imageView6);
        TextView t1=(TextView)findViewById(R.id.textView);
        TextView t2=(TextView)findViewById(R.id.textView2);
        i1.setTranslationX(-1000f); i2.setTranslationY(1000f); i3.setTranslationX(1000f);
        i1.animate().translationXBy(1000f).setDuration(1500);
        i2.animate().translationYBy(-1000f).setDuration(1500);
        i3.animate().translationXBy(-1000f).setDuration(1500);
        t1.animate().alpha(1f).setDuration(5000);
        t2.animate().alpha(1f).rotation(1800f).setDuration(6000);
       Animation obj= AnimationUtils.loadAnimation(this,R.animator.anim);
       t2.startAnimation(obj);
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,GameMenu.class);
                startActivity(i);
            }
        },8000);

    }
}

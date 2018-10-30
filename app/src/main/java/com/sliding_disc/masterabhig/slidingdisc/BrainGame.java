package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class BrainGame extends AppCompatActivity implements View.OnClickListener {
    TextView t1, t2, t3, t4, t5;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
    int locationofcorrectanswer;
    int score = 0, noofquestions = 1;
    RelativeLayout r1, r2;
    String yes_no, s;
    GridLayout g1;
    int Stage = 1;
    ArrayList<Integer> answers = new ArrayList<Integer>();

    public void Brain_begin(View v) {
        b1.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.VISIBLE);
    }

    public void Begin(View v) {
        b2.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.VISIBLE);
        g1.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        t4.setVisibility(View.VISIBLE);
        r2.setVisibility(View.VISIBLE);
        t5.setVisibility(View.INVISIBLE);
        b12.setVisibility(View.INVISIBLE);
        generatequestions();
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisecondsuntilfinished) {
                t2.setText("Time Left: " + String.valueOf(millisecondsuntilfinished / 1000) + "sec");
            }

            @Override
            public void onFinish() {
                t2.setText("Time Over!!");
                r2.setVisibility(View.VISIBLE);
                g1.setVisibility(View.INVISIBLE);
                t2.setVisibility(View.INVISIBLE);
                t3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                if (score < 15) {
                    yes_no = "No";
                    b12.setText("Better Luck next Time :(");
                } else {
                    yes_no = "Yes";
                    b12.setText("Next Stage :D");
                }
                b12.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                t5.setText("Your Result: \nNumber of attempted questions: " + noofquestions + "\n" + "Number of correct answers: " + score + "\n" + "Qualified for next stage: " +
                        yes_no);
            }
        }.start();

    }

    public void play(View v) {
        noofquestions++;
        if (v.getTag().toString().equals(Integer.toString(locationofcorrectanswer))) {
            score++;
        } else {
        }
        t3.setText("Question No.: " + noofquestions + "/20");
        if (noofquestions < 20)
            generatequestions();
        else {
            r2.setVisibility(View.VISIBLE);
            g1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
            t3.setVisibility(View.INVISIBLE);
            t4.setVisibility(View.INVISIBLE);
            if (score < 15) {
                yes_no = "No";
                b12.setText("Better Luck next Time :(");
            } else {
                yes_no = "Yes";
                b12.setText("Next Stage :D");
            }
            b12.setVisibility(View.VISIBLE);
            t5.setVisibility(View.VISIBLE);
            t5.setText("Your Result: \nNumber of attempted questions: " + noofquestions + "\n" + "Number of correct answers: " + score + "\n" + "Qualified for next stage: " +
                    yes_no);
        }

    }

    public void generatequestions() {
        if (Stage == 1) {
            Random ran = new Random();
            int a = ran.nextInt(31);
            int b = ran.nextInt(31);
            int c = ran.nextInt(31);
            t4.setText(Integer.toString(a) + " + " + Integer.toString(b) + " + " + Integer.toString(c));
            answers.clear();
            locationofcorrectanswer = ran.nextInt(9);
            int incorrectAnswer;
            for (int i = 0; i < 9; i++) {
                if (i == locationofcorrectanswer)
                    answers.add(a + b + c);
                else {
                    incorrectAnswer = ran.nextInt(91);
                    while (incorrectAnswer == a + b + c) {
                        incorrectAnswer = ran.nextInt(91);
                    }
                    answers.add(incorrectAnswer);
                }

            }
            b3.setText(Integer.toString(answers.get(0)));
            b4.setText(Integer.toString(answers.get(1)));
            b5.setText(Integer.toString(answers.get(2)));
            b6.setText(Integer.toString(answers.get(3)));
            b7.setText(Integer.toString(answers.get(4)));
            b8.setText(Integer.toString(answers.get(5)));
            b9.setText(Integer.toString(answers.get(6)));
            b10.setText(Integer.toString(answers.get(7)));
            b11.setText(Integer.toString(answers.get(8)));
        }
        if (Stage == 2) {
            ArrayList<String> color = new ArrayList<String>();
            color.add("blue");
            color.add("light grey");
            color.add("red");
            color.add("yellow");
            color.add("black");
            color.add("gray");
            color.add("green");
            color.add("cyan(lt blue)");
            color.add("magneta");
            t4.setText("");
            Random ran = new Random();
            int a1 = ran.nextInt(10);
            if (a1 == 1) t4.setBackgroundColor(Color.BLUE);
            if (a1 == 2) t4.setBackgroundColor(Color.YELLOW);
            if (a1 == 3) t4.setBackgroundColor(Color.GREEN);
            if (a1 == 4) t4.setBackgroundColor(Color.BLACK);
            if (a1 == 5) t4.setBackgroundColor(Color.RED);
            if (a1 == 6) t4.setBackgroundColor(Color.GRAY);
            if (a1 == 7) t4.setBackgroundColor(Color.CYAN);
            if (a1 == 8) t4.setBackgroundColor(Color.LTGRAY);
            if (a1 == 9) t4.setBackgroundColor(Color.MAGENTA);
            answers.clear();
            for (int i1 = 1; i1 <= 9; i1++) {
                if (i1 == 1) b3.setBackgroundColor(Color.BLUE);
                if (i1 == 2) b4.setBackgroundColor(Color.YELLOW);
                if (i1 == 3) b5.setBackgroundColor(Color.GREEN);
                if (i1 == 4) b6.setBackgroundColor(Color.BLACK);
                if (i1 == 5) b7.setBackgroundColor(Color.RED);
                if (i1 == 6) b8.setBackgroundColor(Color.GRAY);
                if (i1 == 7) b9.setBackgroundColor(Color.CYAN);
                if (i1 == 8) b10.setBackgroundColor(Color.LTGRAY);
                if (i1 == 9) b11.setBackgroundColor(Color.MAGENTA);
            }
            int b0 = ran.nextInt(10);
            b3.setText((color.get(b0)));
            int c0 = ran.nextInt(10);
            while (c0 == b0) c0 = ran.nextInt(10);
            b4.setText((color.get(c0)));
            int d0 = ran.nextInt(10);
            while (d0 == c0 && d0 == b0) d0 = ran.nextInt(10);
            b5.setText((color.get(d0)));
            int e0 = ran.nextInt(10);
            while (e0 == c0 && e0 == b0 && e0 == d0) e0 = ran.nextInt(10);
            b6.setText((color.get(e0)));
            int f0 = ran.nextInt(10);
            while (f0 == c0 && f0 == b0 && f0 == d0 && f0 == e0) f0 = ran.nextInt(10);
            b7.setText((color.get(f0)));
            int g0 = ran.nextInt(10);
            while (g0 == b0 && g0 == c0 && g0 == d0 && g0 == e0 && g0 == f0) g0 = ran.nextInt(10);
            b8.setText((color.get(g0)));
            int h0 = ran.nextInt(10);
            while (h0 == c0 && h0 == b0 && h0 == d0 && h0 == e0 && h0 == f0 && h0 == g0)
                h0 = ran.nextInt(10);
            b9.setText((color.get(h0)));
            int i0 = ran.nextInt(10);
            while (i0 == c0 && i0 == b0 && i0 == d0 && i0 == e0 && i0 == f0 && i0 == g0 && i0 == h0)
                i0 = ran.nextInt(10);
            b10.setText((color.get(i0)));
            int j0 = ran.nextInt(10);
            while (j0 == b0 && j0 == c0 && j0 == d0 && j0 == e0 && j0 == f0 && j0 == g0 && j0 == h0 && j0 == i0)
                j0 = ran.nextInt(10);
            b11.setText((color.get(j0)));
            if(t4.getBackground().equals(Color.BLUE)){
                if(b3.getText().toString().equals("blue"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("blue"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("blue"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("blue"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("blue"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("blue"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("blue"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("blue"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("blue"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.YELLOW)){
                if(b3.getText().toString().equals("yellow"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("yellow"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("yellow"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("yellow"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("yellow"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("yellow"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("yellow"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("yellow"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("yellow"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.GREEN)){
                if(b3.getText().toString().equals("green"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("green"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("green"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("green"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("green"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("green"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("green"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("green"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("green"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.GRAY)){
                if(b3.getText().toString().equals("gray"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("gray"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("gray"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("gray"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("gray"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("gray"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("gray"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("gray"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("gray"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.BLACK)){
                if(b3.getText().toString().equals("black"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("black"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("black"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("black"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("black"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("black"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("black"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("black"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("black"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.CYAN)){
                if(b3.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("cyan(lt blue)"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.LTGRAY)){
                if(b3.getText().toString().equals("light gray"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("light gray"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("light gray"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("light gray"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("light gray"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("light gray"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("light gray"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("light gray"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("light gray"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.RED)){
                if(b3.getText().toString().equals("red"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("red"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("red"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("red"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("red"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("red"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("red"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("red"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("red"));
                locationofcorrectanswer=8;
            }
            if(t4.getBackground().equals(Color.MAGENTA)){
                if(b3.getText().toString().equals("magneta"));
                locationofcorrectanswer=0;
                if(b4.getText().toString().equals("magneta"));
                locationofcorrectanswer=1;
                if(b5.getText().toString().equals("magneta"));
                locationofcorrectanswer=2;
                if(b6.getText().toString().equals("magneta"));
                locationofcorrectanswer=3;
                if(b7.getText().toString().equals("magneta"));
                locationofcorrectanswer=4;
                if(b8.getText().toString().equals("magneta"));
                locationofcorrectanswer=5;
                if(b9.getText().toString().equals("magneta"));
                locationofcorrectanswer=6;
                if(b10.getText().toString().equals("magneta"));
                locationofcorrectanswer=7;
                if(b11.getText().toString().equals("magneta"));
                locationofcorrectanswer=8;
            }


}
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_game);
        r1 = (RelativeLayout) findViewById(R.id.rl1);
        r2 = (RelativeLayout) findViewById(R.id.rl2);
        g1=(GridLayout)findViewById(R.id.grid_brain);
        t1 = (TextView) findViewById(R.id.textView11); //introduction of stages
        t2 = (TextView) findViewById(R.id.textView15); //time
        t3 = (TextView) findViewById(R.id.textView16); //noofques
        t4 = (TextView) findViewById(R.id.textView17); //ques
        t5 = (TextView) findViewById(R.id.textView19);//result
        b1 = (Button) findViewById(R.id.button13); //begin
        b2 = (Button) findViewById(R.id.button14); //go
        b3 = (Button) findViewById(R.id.button15);
        b4 = (Button) findViewById(R.id.button16);
        b5 = (Button) findViewById(R.id.button17);
        b6 = (Button) findViewById(R.id.button18);
        b7 = (Button) findViewById(R.id.button19);
        b8 = (Button) findViewById(R.id.button20);
        b9 = (Button) findViewById(R.id.button21);
        b10 = (Button) findViewById(R.id.button22);
        b11 = (Button) findViewById(R.id.button23);
        b12= (Button) findViewById(R.id.button34);
        b12.setOnClickListener(this);
        r2.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE); t3.setVisibility(View.INVISIBLE); t4.setVisibility(View.INVISIBLE); g1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        if(Stage==1)
         s = "STAGE 1:\n\n Introduction:\nThis is the simplest stage.You have to click on the write answer of the given sum equation" +
                " and nothing else.Within 30 seconds you have to answer 20 questions.If the 70% answers are correct then you qualified to next stage :D";

        t1.setText(s);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.button34){
            String ss=b12.getText().toString();
            if(ss.equals("BETTER LUCK NEXT TIME :(")){
                Intent intent=new Intent(this,GameMenu_brain.class);
                startActivity(intent);
            }
            else {
                Stage++;
                if(Stage==2)
                    s="STAGE 2:\n\n";
                if(Stage==3)
                    s="STAGE 3:\n\n";
                t1.setText(s);
                score = 0; noofquestions = 1;
                t1.setText(s);
                t1.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.INVISIBLE);
            }
        }
    }
}
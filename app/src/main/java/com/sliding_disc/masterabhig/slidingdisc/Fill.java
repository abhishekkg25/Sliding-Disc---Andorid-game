package com.sliding_disc.masterabhig.slidingdisc;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fill extends AppCompatActivity implements View.OnClickListener {
    Spinner s1,s2;
    Button b1;
    EditText e1,e2;
RelativeLayout r1;
int x1,x2,x3;
RadioButton rb1,rb2,rb3;
RadioGroup rg1;
String ed1,ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);
        s1=(Spinner)findViewById(R.id.spinner);
        s2=(Spinner)findViewById(R.id.spinner2);
        b1=(Button)findViewById(R.id.button5);
        rb1=(RadioButton)findViewById(R.id.radioButton4);
        rb2=(RadioButton)findViewById(R.id.radioButton5);
        rb3=(RadioButton)findViewById(R.id.radioButton6);
        rg1=(RadioGroup)findViewById(R.id.radioGroup);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1.setOnClickListener(this);
r1=(RelativeLayout)findViewById(R.id.Relative_fill);

        List<String> categories1=new ArrayList<String>();
        categories1.add("Choose color:");
        categories1.add("Blue");
        categories1.add("Green");
        categories1.add("Yellow");
        categories1.add("Orange");
        categories1.add("Red");
        categories1.add("Grey");
        ArrayAdapter<String> DA=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories1);
        DA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(DA);
        s2.setAdapter(DA);
        ed1=e1.getText().toString();
        ed2=e2.getText().toString();
    }

    @Override
    public void onClick(View view) {
       int id=view.getId();
       if(id==R.id.button5)
       { Intent intent=new Intent(this,Game.class);
           intent.putExtra("Name1",e1.getText().toString());
           intent.putExtra("Name2",e2.getText().toString());
           intent.putExtra("Disc1",s1.getSelectedItem().toString());
           intent.putExtra("Disc2",s2.getSelectedItem().toString());
           if(rb1.isChecked()==true)
           intent.putExtra("Series",rb1.getText().toString());
           if(rb2.isChecked()==true)
               intent.putExtra("Series",rb2.getText().toString());
           if(rb3.isChecked()==true)
               intent.putExtra("Series",rb3.getText().toString());
           startActivity(intent);
          /* if((ed1.isEmpty()==false)&& (ed2.isEmpty()==false) && (x1==1||x2==1||x3==1)){

           }else Toast.makeText(this,"Someething is incomplete!",Toast.LENGTH_SHORT).show();*/
       }


    }
}

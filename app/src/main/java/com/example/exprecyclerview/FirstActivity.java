package com.example.exprecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity
implements View.OnClickListener {
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn1=findViewById(R.id.btnAjout);
        btn2=findViewById(R.id.btnAffichage);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       Intent it=null;
        switch (view.getId())
        {



            case R.id.btnAjout:
               it = new Intent(getApplicationContext(),addAnimalActivity.class);
                break;
            case R.id.btnAffichage:
                it = new Intent(getApplicationContext(),MainActivity.class);



        }
        startActivity(it);

    }
}
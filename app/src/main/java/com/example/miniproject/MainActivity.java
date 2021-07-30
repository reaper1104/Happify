package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView m,n;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m=findViewById(R.id.string);
        n=findViewById(R.id.file);


    }
    public void breathe(View v){
        Intent i=new Intent(this,MainActivity2.class);
        startActivity(i);
    }
    public void rem(View v){


        n.setText("nnewoifiewojnewogog");

    }
}
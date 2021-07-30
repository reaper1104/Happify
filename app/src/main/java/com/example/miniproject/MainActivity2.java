package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.service.autofill.FillEventHistory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    Button start, stop;
    TextView ctrVal;
    EditText text;
    int counter = 4;
    int flag = 0;
    int n=1;
    Handler handle = new Handler();
    MediaPlayer mp,m,mpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mp=MediaPlayer.create(MainActivity2.this,R.raw.exhale);
        mpp=MediaPlayer.create(MainActivity2.this,R.raw.breathe);
        m=MediaPlayer.create(MainActivity2.this,R.raw.hold);


        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        ctrVal = (TextView) findViewById(R.id.ctrVal);

        start.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                mpp.start();
                text.append("breathe in");
                handle.postDelayed(rn, 1000);


            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handle.removeCallbacks(rn);
                counter = 0;
                ctrVal.setText(String.valueOf("       "+counter));
                counter=4;

            }
        });
    }
    public Runnable rn = new Runnable() {
        @Override
        public void run() {
                counter--;

                if(counter==0)
                {
                    n++;
                    if(n>3)
                        n=n-3;
                    if(n==1){
                        counter=4;
                        mpp.start();
                        text.append("breathe in");

                    }
                    else if(n==2){
                        counter=7;
                        m.start();
                        text.append("hold");
                    }
                    else if(n== 3){
                        counter=8;
                        mp.start();
                        text.append("exhale");
                    }

                }

                ctrVal.setText(String.valueOf("       "+counter));

                handle.postDelayed(rn,1000);

        }
    };
}
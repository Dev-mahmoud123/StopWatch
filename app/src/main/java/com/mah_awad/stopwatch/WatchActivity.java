package com.mah_awad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class WatchActivity extends AppCompatActivity {

    Button btn_start ,btn_stop;
    ImageView icanchor;
    Animation roundimgalone;
    Chronometer timer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        icanchor =findViewById(R.id.imageAnchor);
        btn_start= findViewById(R.id.btn_Start);
        btn_stop = findViewById(R.id.btn_stop);
        timer = findViewById(R.id.chronometer);


        //create optional animation
        btn_stop.setAlpha(0);

        //Load Animation
        roundimgalone = AnimationUtils.loadAnimation(this,R.anim.roundimgalone);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                icanchor.startAnimation(roundimgalone);
                btn_stop.animate().alpha(1).translationY(80).setDuration(3000).start();
                btn_stop.animate().alpha(1).setDuration(3000).start();
                //start timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();

            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.stop();

            }
        });

    }
}
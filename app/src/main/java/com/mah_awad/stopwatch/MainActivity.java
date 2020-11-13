package com.mah_awad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_start;
    Animation anim ,anim2 , anim3;
    ImageView splashImage;
    TextView text1 , text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashImage = findViewById(R.id.imageVW1);
        text1 =findViewById(R.id.textVW1);
        text2= findViewById(R.id.textVW2);
        btn_start =findViewById(R.id.btn_getStart);

        // Load animation
        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim2 =AnimationUtils.loadAnimation(this,R.anim.anim2);
        anim3 = AnimationUtils.loadAnimation(this,R.anim.anim3);
        // passing animation
        splashImage.startAnimation(anim);
        text1.startAnimation(anim2);
        text2.startAnimation(anim2);
        btn_start.startAnimation(anim3);


        // go  to new activity
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, WatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}
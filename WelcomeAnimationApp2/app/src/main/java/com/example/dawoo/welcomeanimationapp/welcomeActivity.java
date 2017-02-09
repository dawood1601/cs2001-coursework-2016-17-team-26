package com.example.dawoo.welcomeanimationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
// Animation
public class welcomeActivity extends AppCompatActivity {
    ImageView ViewIMG;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ViewIMG=(ImageView)findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.welcome_animation);

        ViewIMG.setAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener()
        // Added the Animation
        {
            @Override
            public void onAnimationStart(Animation animation) {




            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
                // Finish the animation and open the camera which is in different branch
                startActivity(new Intent(getApplicationContext() ,MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });












        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

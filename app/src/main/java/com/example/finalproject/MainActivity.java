package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

public class MainActivity extends Activity {

    /**
     * Sets up the app
     * @param savedInstanceState the saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureNextButton();
    }

    /**
     * Defines actions for pressing each home screen button.
     */
    private void configureNextButton() {
        Button start_btn = findViewById(R.id.start_btn);
        Button exit_btn = findViewById(R.id.exit_btn);
        Button about_btn = findViewById(R.id.about_btn);

        //if start button is pressed, beging GameActivity
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
        //If exit button is pressed, kill app
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}

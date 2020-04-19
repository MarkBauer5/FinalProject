package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity {

    //Define the button
    //Button btn_Game;

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


    private void configureNextButton() {
        Button start_btn = findViewById(R.id.start_btn);
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }
}

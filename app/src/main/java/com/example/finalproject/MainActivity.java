package com.example.finalproject;

//import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    //Define the button
    Button btn_Game;

    /**
     * Sets up the app
     * @param savedInstanceState the saved state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Game = findViewById(R.id.start_btn);

        // sets the on click listener for the button, calls onClick
        btn_Game.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId()== R.id.start_btn){
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("Start", true);
            startActivity(intent);
        }
    }
}

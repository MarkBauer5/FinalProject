package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        configureButtons();
    }
    private void configureButtons() {
        Button toggle_animation = findViewById(R.id.animation_toggle);
        Button toggle_undo = findViewById(R.id.undo_toggle);

        toggle_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GameActivity.animationEnabled) {
                    GameActivity.animationEnabled = false;
                } else {
                    GameActivity.animationEnabled = true;
                }
            }
        });
        toggle_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GameActivity.undoEnabled) {
                    GameActivity.undoEnabled = false;
                } else {
                    GameActivity.undoEnabled = true;
                }
            }
        });
    }
}

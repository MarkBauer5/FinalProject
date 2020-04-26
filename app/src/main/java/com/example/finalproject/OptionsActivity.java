package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
        final ImageView unchecked_top = findViewById(R.id.unchecked_top);
        final ImageView checked_top = findViewById(R.id.checked_top);
        final ImageView unchecked_bottom = findViewById(R.id.unchecked_bottom);
        final ImageView checked_bottom = findViewById(R.id.checked_bottom);

        //saves state for animation enabled if options tab is closed,
        //but does not save data if app is closed
        if (!GameActivity.animationEnabled) {
            checked_top.setVisibility(View.VISIBLE);
            unchecked_top.setVisibility(View.GONE);
        } else {
            checked_top.setVisibility(View.GONE);
            unchecked_top.setVisibility(View.VISIBLE);
        }

        //saves state for undo enabled if options tab is closed,
        //but does not save data if app is closed
        if (!GameActivity.undoEnabled) {
            checked_bottom.setVisibility(View.VISIBLE);
            unchecked_bottom.setVisibility(View.GONE);
        } else {
            checked_bottom.setVisibility(View.GONE);
            unchecked_bottom.setVisibility(View.VISIBLE);
        }

        toggle_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GameActivity.animationEnabled) {
                    GameActivity.animationEnabled = false;
                    checked_top.setVisibility(View.VISIBLE);
                    unchecked_top.setVisibility(View.GONE);
                } else {
                    GameActivity.animationEnabled = true;
                    checked_top.setVisibility(View.GONE);
                    unchecked_top.setVisibility(View.VISIBLE);
                }
            }
        });
        toggle_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GameActivity.undoEnabled) {
                    GameActivity.undoEnabled = false;
                    checked_bottom.setVisibility(View.VISIBLE);
                    unchecked_bottom.setVisibility(View.GONE);
                } else {
                    GameActivity.undoEnabled = true;
                    checked_bottom.setVisibility(View.GONE);
                    unchecked_bottom.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

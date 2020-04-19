package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements View.OnClickListener {
    TextView turn_txt;
    Button undo_btn;
    Button restart_btn;
    private int rows = 6;
    private int columns = 7;
    private GameEngine gameEngine;
    private int buttons[] = {R.drawable.red_chip, R.drawable.green_chip};
    private String[] s_Turns = {"Red", "Green"};
    private int win_buttons[] = { R.drawable.red_win, R.drawable.green_win};
    private int temp_buttons[] ={ R.drawable.empty_t, R.drawable.green_chip, R.drawable.red_chip};

    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        setContentView(R.layout.activity_game);
        turn_txt = findViewById(R.id.txt_Turn);
        undo_btn = findViewById(R.id.btn_Undo);
        restart_btn = findViewById(R.id.btn_Restart);
        undo_btn.setOnClickListener(this);
        restart_btn.setOnClickListener(this);

        gridview = findViewById(R.id.gridview);
        gridview.setNumColumns(7);
        gridview.setAdapter(new ImageAdapter(this, rows*columns));
        turn_txt.setText(s_Turns[0]);

        gameEngine = new GameEngine(rows, columns);
        gridview.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // System.out.println(gridview.getAdapter().);

                if(!gameEngine.finished){

                    int addPosition = gameEngine.addToColumn(position);
                    turn_txt.setText(s_Turns[(gameEngine.getCount()+1)%2]);
                    if(addPosition<rows*columns){
                        ImageView chosen =  (ImageView) parent.getChildAt(addPosition);
                        chosen.setImageResource(buttons[getTurn()]);
                        if(gameEngine.finished){
                            if(!gameEngine.win.isEmpty())
                                for(int i : gameEngine.win){
                                    chosen = (ImageView) parent.getChildAt(i);
                                    chosen.setImageResource(win_buttons[getTurn()]);
                                    Toast.makeText(GameActivity.this, "Game Over  "+ s_Turns[getTurn()] + " Won",
                                            Toast.LENGTH_SHORT).show();
                                    undo_btn.setEnabled(false);
                                }
                            else{
                                Toast.makeText(GameActivity.this, "Game Over Nobody Won - You both suck ",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }

                    }
                    // Toast.makeText(GameActivity.this, "" + position +" "+ gE.getRow(position) +" "+gE.getColumn(position) +" "+ gE.getRow(gE.getLastPos()) +" "+ gE.getColumn(gE.getLastPos()), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}

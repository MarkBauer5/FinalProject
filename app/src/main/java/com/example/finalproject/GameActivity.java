package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends Activity implements View.OnClickListener  {



    TextView txt_Turn;
    Button btn_Undo;
    Button btn_Restart;
    ImageView theBoard;
    GridView gridframe;
    RelativeLayout gridviewHolder;
    private int rows = 6 ;
    private int columns =  7;
    private GameEngine gameEngine;
    private int buttons[] = {R.drawable.red_chip, R.drawable.green_chip};
    private String[] s_Turns = {"Red's Turn", "Green's Turn"};
    private int win_buttons[] = { R.drawable.red_win,R.drawable.green_win};
//    private int temp_buttons[] ={ R.drawable.empty_t,R.drawable.green_chip, R.drawable.red_chip};

    GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        txt_Turn = findViewById(R.id.txt_Turn);
        btn_Undo = findViewById(R.id.btn_Undo);
        btn_Restart = findViewById(R.id.btn_Restart);
        btn_Undo.setOnClickListener(this);
        btn_Restart.setOnClickListener(this);
        theBoard = findViewById(R.id.board);

        gridframe = findViewById(R.id.gridframe);
        gridview = findViewById(R.id.gridview);
        gridviewHolder = findViewById(R.id.gridviewHolder);
        gridview.setNumColumns(7);
        gridview.setAdapter(new ImageAdapter(this, rows*columns, this));
        gridframe.setNumColumns(7);
        gridframe.setAdapter(new FrameAdapter(this, rows*columns, this));
        txt_Turn.setText(s_Turns[0]);

//        ImageView board = findViewById(R.id.board);
//        board.setImageResource(R.drawable.test_board);

        // Create GameEngine
        gameEngine = new GameEngine(rows,columns, this);
        gridview.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(!gameEngine.finished){

                    int addPosition = gameEngine.addToColumn(position);
                    txt_Turn.setText(s_Turns[(gameEngine.getCount()+1)%2]);
                    if(addPosition<rows*columns){
                        ImageView chosen =  (ImageView) parent.getChildAt(addPosition);
                        if (addPosition == 0) {
                            chosen = (ImageView) parent.getChildAt(0);
                        }
                        System.out.println(position + "WWWHHHAAATTT");
                        Random r = new Random();
                        int rot = r.nextInt(2000 - 65) - 65;
                        chosen.setTranslationY(2000);
                        chosen.animate().translationYBy(-2000).rotation(rot).setDuration(800);
                        chosen.setImageResource(buttons[getTurn()]);
                        if(gameEngine.finished){
                            if(!gameEngine.win.isEmpty())
                                for(int i : gameEngine.win){
                                    chosen = (ImageView) parent.getChildAt(i);
                                    chosen.setImageResource(win_buttons[getTurn()]);
                                    Toast.makeText(GameActivity.this, "Game Over  "+ s_Turns[getTurn()] + " Won",
                                            Toast.LENGTH_SHORT).show();
                                    btn_Undo.setEnabled(false);
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

//        if(v.getId()== R.id.btn_Test){
//            placeButtons();
//        }
        System.out.println(gridview.getChildAt(0));
        if(v.getId()== R.id.btn_Undo){
            btn_Undo.setEnabled(true);
            unDo();
        }
        else if(v.getId()== R.id.btn_Restart){
            txt_Turn.setText(s_Turns[0]);
            btn_Undo.setEnabled(true);
            gameEngine.restart();
            for(int i = 0; i<rows*columns; i++){
                ImageView l = (ImageView) gridview.getChildAt(i);
                l.setImageResource(R.drawable.empty_t);
            }

        }


    }

    public void unDo(){
        if(gameEngine.getCount()>-1){
            int pos = gameEngine.unDo();
            ImageView v = (ImageView) gridview.getChildAt(pos);
            v.setImageResource(R.drawable.empty_t);

        }

    }


//    public void placeButtons(){
//        //int[][]b=  { { 0, 0, 0, 1, 1, 2, 1, },{ 0, 0, 0, 0, 2, 2, 2, },{ 0, 0, 0, 0, 1, 1, 1, },{ 0, 0, 0, 0, 0, 2, 1, },{ 0, 0, 0, 0, 0, 0, 2, },{ 0, 0, 0, 0, 0, 0, 1}};
//        //int [][]b = { { 1, 2, 1, 1, 1, 0, 0, },{ 0, 1, 2, 2, 2, 0, 0, },{ 0, 0, 0, 2, 1, 0, 0, },{ 0, 0, 0, 0, 0, 0, 0, },{ 0, 0, 0, 0, 0, 0, 0, },{ 0, 0, 0, 0, 0, 0, 0}};
//        int[][]b= { { 2, 1, 2, 1, 2, 1, 1, },{ 1, 1, 1, 2, 1, 1, 1, },{ 2, 1, 2, 1, 1, 1, 1, },{ 1, 1, 1, 1, 1, 1, 1 },{ 1, 1,1, 1, 1, 1, 1 },{ 1, 1, 1, 1, 1, 1, 0}};
//        gameEngine.setBoard(b,0);
//        for(int i = 0; i<rows;i++){
//            for(int j = 0; j<columns; j++){
//                //System.out.print(gE.getPosition(i,j));
//                ImageView temp = (ImageView) gridview.getChildAt(gameEngine.getPosition(i,j));
//                temp.setImageResource(temp_buttons[b[i][j]]);
//                //temp.setImageResource(R.drawable.red_wint);
//
//            }
//            System.out.println("");
//        }
//
//    }

    private int getTurn(){
        return gameEngine.getCount()%2;
    }





}
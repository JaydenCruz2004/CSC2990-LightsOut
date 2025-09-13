package com.example.lightsout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final int GRID_SIZE = 3;
    private GridLayout grid;
    private boolean cellState[][];

    private TextView scoreText;

    private Button resetB;

    private Button randoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cellState = new boolean[][]{{true, true, true}, {true, true, true}, {true, true, true}};

        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.light_grid);
        scoreText = findViewById(R.id.textViewScore);
        resetB = findViewById(R.id.buttonReset);
        randoB = findViewById(R.id.buttonRando);
        //register the listener to button
        resetB.setOnClickListener(bottomListener);
        randoB.setOnClickListener(bottomListener);




        randomize();

        recolor();
        for(int i=0; i < grid.getChildCount();i++){
            Button currButton = (Button) grid.getChildAt(i);
            currButton.setOnClickListener(buttonListener);
        }
    }


    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button current = (Button) v;
            for (int i = 0; i < grid.getChildCount(); i++) {
                Button gridButton = (Button) grid.getChildAt(i);

                if (gridButton == current){
                    int row = i / GRID_SIZE;
                    int col = i % GRID_SIZE;
                    //toggle the state
                    cellState[row][col] = !cellState[row][col];
                    //always recolor after a toggle
                    recolor();
                }

                }
            }
        };

    View.OnClickListener bottomListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.buttonReset){
                resetAllOff();
                recolor();
            }
            if (view.getId() == R.id.buttonRando){
                randomize();
                recolor();
            }
        }
    };

    public void resetAllOff() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                cellState[i][j] = false; // turn everything OFF
            }
        }
    }



    public int howManyOn() {
        int onCount = 0;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (cellState[i][j]) {
                    onCount++;
                }
            }
        }
        return onCount;
    }


    public void recolor() {
            for (int i = 0; i < grid.getChildCount(); i++) {
                Button gridButton = (Button) grid.getChildAt(i);

                // Find the button's row and col
                int row = i / GRID_SIZE;
                int col = i % GRID_SIZE;

                if (cellState[row][col] == true) {
                    gridButton.setBackgroundColor(getColor(R.color.blue_500));
                } else {
                    gridButton.setBackgroundColor(getColor(R.color.black));
                }

                // Update score after recoloring
                int lightsOn = howManyOn();
                scoreText.setText("Score: " + lightsOn);
            }
        }


        public void randomize() {
            Random random = new Random();
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    cellState[i][j] = random.nextBoolean();
                }
            }
        }


    }
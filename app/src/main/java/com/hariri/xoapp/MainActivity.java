// TODO: 11/8/2017 36:20 
package com.hariri.xoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.xml.xpath.XPath;

public class MainActivity extends AppCompatActivity {
    // 0 = X ---- 1 = O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean gameIsActive = true;

    public void dropIn (View view) {



        ImageView XO = (ImageView) view;

        int isTapped = Integer.parseInt(XO.getTag().toString());

        // The 8 winning combinations

        int[][] gamewinning = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7,}, {2, 5, 8},
                {0, 4, 8,}, {2 ,4 ,6} };



        if (gameState[isTapped] == 2 && gameIsActive){

            gameState[isTapped] = activePlayer;
            XO.setTranslationY(-1000f);

            if (activePlayer == 0) {

                XO.setImageResource(R.mipmap.xx);

                activePlayer = 1;
            } else {

                XO.setImageResource(R.drawable.oo);

                activePlayer = 0;

            }

            XO.animate().translationYBy(1000f).rotation(360).setDuration(750);
            for(int[] winningPosition : gamewinning) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2) {

                    String winner = "O";

                    if(gameState[winningPosition[0]] == 0) {

                        winner = "X";

                    }
                    gameIsActive = false;

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                    winnerMessage.setText(winner + " has Won!");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);


                }else {

                    boolean gameIsOver = true;

                    for (int counterState :gameState) {

                        if (counterState == 2) gameIsOver = false;

                    }




                        if (gameIsOver) {

                            TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);

                            winnerMessage.setText("It's a draw!");
                            LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                            layout.setVisibility(View.VISIBLE);

                        }

                    }

                }

            }
        }


    public void playAgain(View view) {

        gameIsActive = true;


        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
//        gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

        for (int i = 0;i<gameState.length; i++) {

            gameState[i] = 2;

        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.grid);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        System.out.println("Hello");
        
        for(int si = 0; si <6 ; si++) {
            
            System.out.println("Hello, " + si);
            
    }
}

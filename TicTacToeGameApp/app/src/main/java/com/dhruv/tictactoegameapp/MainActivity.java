package com.dhruv.tictactoegameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int [] gamestate ={2,2,2,2,2,2,2,2,2};
    int [][] winningpositions ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activeplayer = 0;
    boolean gameactive=true;
        public void dropin (View view){
        // 0 is circle and 1 is cross
        ImageView counter = (ImageView) view;
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappedcounter] == 2 && gameactive) {
            gamestate[tappedcounter] = activeplayer;
            counter.setTranslationY(-1500);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.circle);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.cross);
                activeplayer = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
            for (int[] x : winningpositions) {
                if (gamestate[x[0]] == gamestate[x[1]] && gamestate[x[1]] == gamestate[x[2]] && gamestate[x[0]] != 2) {
                    String winner = "";
                    gameactive = false;
                    if (activeplayer == 1) {
                        winner = "circle";
                    }
                    else {
                        winner = "cross";
                    }
                    //Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();
                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                    winnerTextView.setText(winner + " has won ! ");
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }
    }
        public void playAgain (View view){
            activeplayer = 0;
            gameactive = true;
            for (int i = 0; i < gamestate.length; i++) {
                gamestate[i] = 2;
            }
            ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

            TextView status = findViewById(R.id.winnerTextView);
            status.setText("Tap to play");
       /* Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
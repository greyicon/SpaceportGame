package com.sgoldwax.spaceport;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView logView;
    private TextView resView;
    private TextView modView;

    private GameInfoManager infoManager;
    private int gameClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spaceport_view);

        // Initialize text views
        logView = (TextView) findViewById(R.id.logView);
        resView = (TextView) findViewById(R.id.resView);
        modView = (TextView) findViewById(R.id.moduleView);
        initTextViews();

        // Initialize GameInfoManager
        infoManager = new GameInfoManager(logView, resView);

        // Update game state every 10 (delay) milliseconds
        // Clock runs even when activity is switched
        gameClock = 0;
        final Handler handler = new Handler();
        final int delay = 10;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do on-tick stuff

                if (gameClock % 100 == 0) {
                    // Do every-second stuff

                }
                gameClock++;
            }
        }, delay);
    }

    private void initTextViews() {
        logView.setText("Welcome to your spaceport, commander. \n\n");
        resView.setText("Resources: \n\n");
        modView.setText("Modules: \n\n");
    }
}

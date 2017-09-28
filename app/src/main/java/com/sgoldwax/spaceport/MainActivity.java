package com.sgoldwax.spaceport;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sgoldwax.spaceport.Enums.GameLocations;

public class MainActivity extends AppCompatActivity {

    private TextView logView;
    private TextView resView;
    private TextView relView;

    // Spaceport ButtonSet
    private Button btnSpaceportToPlanetView;
    private Button testAddBuilding;

    // Planet ButtonSet
    private Button btnPlanetToSpaceportView;

    private GameInfoManager infoManager;
    private int gameClock;

    private GameLocations currentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spaceport_view);

        // Initialize text views
        logView = (TextView) findViewById(R.id.logView);
        resView = (TextView) findViewById(R.id.resView);
        relView = (TextView) findViewById(R.id.releativeView);
        initTextViews();

        // Initialize buttons
        btnSpaceportToPlanetView = (Button) findViewById(R.id.fromSpaceportToPlanet);
        btnSpaceportToPlanetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocations(GameLocations.PLANET);
            }
        });
        btnPlanetToSpaceportView = (Button) findViewById(R.id.fromPlanetToSpaceport);
        btnPlanetToSpaceportView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLocations(GameLocations.SPACEPORT);
            }
        });

        currentLocation = GameLocations.SPACEPORT;

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
                    // Generate resources
                    ResHolder gen = infoManager.planetManager.getPlanetResourceGen();
                    infoManager.resourceManager.resources.add(gen);
                    resView.setText(infoManager.resourceManager.toString());
                }
                gameClock++;
                handler.postDelayed(this, delay);
            }
        }, delay);
    }

    private void initTextViews() {
        logView.setText("Welcome to your spaceport, commander. \n\n");
        resView.setText("Resources: \n\n");
        relView.setText("TODO");
    }

    private void changeLocations(GameLocations loc) {
        ScrollView s1 = getScrollViewForLocation(currentLocation);
        ScrollView s2 = getScrollViewForLocation(loc);
        s1.setVisibility(View.GONE);
        s1.setClickable(false);
        s2.setVisibility(View.VISIBLE);
        s2.setClickable(true);
        currentLocation = loc;
    }

    private ScrollView getScrollViewForLocation(GameLocations loc) {
        ScrollView ret = null;
        switch (loc) {
            case SPACEPORT:
                ret = (ScrollView) findViewById(R.id.spaceportButtonSet);
                break;
            case PLANET:
                ret = (ScrollView) findViewById(R.id.planetButtonSet);
                break;
        }
        return ret;
    }
}

package com.example.android.hockeytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int homeScore = 0;
    int homeSOG = 0;
    int homeHits = 0;
    float homeSavePercentage = 1;
    int awayScore = 0;
    int awaySOG = 0;
    int awayHits = 0;
    float awaySavePercentage = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Home Team scoring methods

    public void homeTeamGoal(View view) {
        homeScore += 1;
        homeSOG += 1;
        awaySavePercentage = ((float) (homeSOG - homeScore) / homeSOG);
        displayHomeScore(homeScore);
        displayHomeSOG(homeSOG);
        displayAwaySavePercentage(awaySavePercentage);
    }

    public void homeTeamSOG(View view) {
        homeSOG += 1;
        awaySavePercentage = ((float) (homeSOG - homeScore) / homeSOG);
        displayHomeSOG(homeSOG);
        displayAwaySavePercentage(awaySavePercentage);
    }

    public void homeTeamHit(View view) {
        homeHits += 1;
        displayHomeHits(homeHits);
    }


    //Displays the given score for The Home Team.

    public void displayHomeScore(int homeScore) {
        TextView scoreView = findViewById(R.id.team_home_score);
        scoreView.setText(String.valueOf(homeScore));
    }

    //Displays the given shots on goal (SOG) for The Home Team.

    public void displayHomeSOG(int homeSOG) {
        TextView scoreView = findViewById(R.id.team_home_sog);
        scoreView.setText(String.valueOf(homeSOG));
    }

    //Displays the given hits for The Home Team.

    public void displayHomeHits(int homeHits) {
        TextView scoreView = findViewById(R.id.team_home_hits);
        scoreView.setText(String.valueOf(homeHits));
    }

    //Displays save percentage for the home team

    public void displayHomeSavePercentage(double homeSavePercentage) {
        DecimalFormat df = new DecimalFormat(".000");
        df.setRoundingMode(RoundingMode.CEILING);
        TextView scoreView = findViewById(R.id.team_home_svp);
        scoreView.setText(df.format(homeSavePercentage));

    }

    //Away Team scoring methods

    public void awayTeamGoal(View view) {
        awayScore += 1;
        awaySOG += 1;
        homeSavePercentage = ((float) (awaySOG - awayScore) / awaySOG);
        displayAwayScore(awayScore);
        displayAwaySOG(awaySOG);
        displayHomeSavePercentage(homeSavePercentage);
    }

    public void awayTeamSOG(View view) {
        awaySOG += 1;
        homeSavePercentage = ((float) (awaySOG - awayScore) / awaySOG);
        displayAwaySOG(awaySOG);
        displayHomeSavePercentage(homeSavePercentage);
    }

    public void awayTeamHit(View view) {
        awayHits += 1;
        displayAwayHits(awayHits);
    }


    //Displays the given score for The away Team.

    public void displayAwayScore(int awayScore) {
        TextView scoreView = findViewById(R.id.team_away_score);
        scoreView.setText(String.valueOf(awayScore));
    }

    //Displays the given shots on goal (SOG) for The Home Team.

    public void displayAwaySOG(int awaySOG) {
        TextView scoreView = findViewById(R.id.team_away_sog);
        scoreView.setText(String.valueOf(awaySOG));
    }

    //Displays the given hits for The away Team.

    public void displayAwayHits(int awayHits) {
        TextView scoreView = findViewById(R.id.team_away_hits);
        scoreView.setText(String.valueOf(awayHits));
    }

    //Calculates and displays save percentage

    public void displayAwaySavePercentage(double awaySavePercentage) {
        DecimalFormat df = new DecimalFormat(".000");
        df.setRoundingMode(RoundingMode.CEILING);
        TextView scoreView = findViewById(R.id.team_away_svp);
        scoreView.setText(df.format(awaySavePercentage));


    }


    //reset button
    public void resetBothScores(View v) {
        homeScore -= homeScore;
        homeSOG -= homeSOG;
        homeHits -= homeHits;
        homeSavePercentage -= homeSavePercentage;

        awayScore -= awayScore;
        awaySOG -= awaySOG;
        awayHits -= awayHits;
        awaySavePercentage -= awaySavePercentage;

        displayHomeScore(homeScore);
        displayHomeSOG(homeSOG);
        displayHomeHits(homeHits);
        displayHomeSavePercentage(homeSavePercentage);

        displayAwayScore(awayScore);
        displayAwaySOG(awaySOG);
        displayAwayHits(awayHits);
        displayAwaySavePercentage(awaySavePercentage);
    }


}

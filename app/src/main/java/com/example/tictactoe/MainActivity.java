package com.example.tictactoe;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import controller.GridButtonListener;
import controller.MainController;
import controller.NextGameButtonListener;
import model.Position;
import view.GridButtonView;
import view.TextViewView;

public class MainActivity extends AppCompatActivity
{
    Button[] grid = new Button[9];
    Button nextGame;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridButtonView gbv = new GridButtonView();
        TextViewView tvv = new TextViewView(this);

        MainController mc = new MainController();
        mc.setGridButtonView(new GridButtonView());
        mc.setTextViewView(new TextViewView(this));
        mc.setTextViewView(tvv);
        mc.setGridButtonView(gbv);

        NextGameButtonListener.setMainController(mc);
        GridButtonListener.setMainController(mc);

        nextGame = findViewById(R.id.StartNewGame);
        nextGame.setOnClickListener(new NextGameButtonListener());
        nextGame.setBackgroundColor(0xFF00AA00);

        grid[0] = findViewById(R.id.GridButton00);
        grid[1] = findViewById(R.id.GridButton01);
        grid[2] = findViewById(R.id.GridButton02);
        grid[3] = findViewById(R.id.GridButton10);
        grid[4] = findViewById(R.id.GridButton11);
        grid[5] = findViewById(R.id.GridButton12);
        grid[6] = findViewById(R.id.GridButton20);
        grid[7] = findViewById(R.id.GridButton21);
        grid[8] = findViewById(R.id.GridButton22);

        for(int i = 0; i < grid.length; i++)
        {
            int row = i / 3;
            int col = i % 3;
            grid[i].setOnClickListener(new GridButtonListener(row, col));
            gbv.addButton(grid[i], new Position(row, col));
            gbv.setColor(0xFF0000FF, new Position(row, col));
            gbv.setText(" ", new Position(row, col));
        }

        tvv.setXWinsTextView(findViewById(R.id.xPlayerWins));
        tvv.setOWinsTextView(findViewById(R.id.oPlayerWins));
        tvv.setDrawsTextView(findViewById(R.id.drawsCounter));
        tvv.setStatusTextView(findViewById(R.id.CurrentTurn));

        tvv.displayXWins("Player X wins: 0");
        tvv.displayOWins("Player O Wins: 0");
        tvv.displayDraws("Draws: 0");
        tvv.displayStatus("Ready player " + mc.getCurrentMarker().toString());
    }
}
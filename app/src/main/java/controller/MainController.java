/**
 * MainController is the main controller for the Tic Tac Toe game.
 * It manages the game state, handles player moves, and updates the game view.
 *
 * The controller keeps track of the current player, the game over state, and the number of wins for each player.
 * It also holds references to the game model and the game views.
 *
 * @author John Benfield
 */
package controller;


import java.util.Arrays;

import model.Marker;
import model.Position;
import model.TicTacToeBoard;
import view.GridButtonView;
import view.TextViewView;

public class MainController {
    TicTacToeBoard model;
    GridButtonView gridButtonView;
    TextViewView textViewView;
    Marker startingMarker;
    Marker currentMarker;
    boolean gameOver;
    int numXWins;
    int numOWins;
    int numDraws;



    /**
     * Constructor for MainController. Initializes the game state.
     */
    public MainController() {
        model = new TicTacToeBoard();
        startingMarker = Marker.X;
        currentMarker = startingMarker;
        gameOver = false;
        numXWins = 0;
        numOWins = 0;
        numDraws = 0;
    }
    /**
     * Sets the GridButtonView for this MainController.
     * @param gridButtonView the GridButtonView to be set
     */
    public void setGridButtonView(GridButtonView gridButtonView) {
        this.gridButtonView = gridButtonView;
    }

    /**
     * Sets the TextViewView for this MainController.
     * @param textViewView the TextViewView to be set
     */
    public void setTextViewView(TextViewView textViewView) {
        this.textViewView = textViewView;
    }


    /**
     * Handles the next move of the game.
     * @param row the row of the move
     * @param col the column of the move
     */
    public void nextMove(int row, int col) {
    if (row < 0 || row >= 3 || col < 0 || col >= 3) {
        throw new IllegalArgumentException("Row and column values must be between 0 and 2 inclusive.");
    }
    Position position = new Position(row, col);
    if (model.getMarker(position) != null || gameOver) {
        return;
    }

    model.setMarker(currentMarker, position);
    String markerName = currentMarker.name().toUpperCase();
    gridButtonView.setText(markerName, position);

        Position[] winCheck = model.winningPositions(currentMarker);
        if (winCheck != null) {
            System.out.println("Winning condition met. Winning positions: " + Arrays.toString(winCheck));
            gameOver = true;
            for (Position winPosition : winCheck) {
                System.out.println("Setting color for position: " + winPosition);
                gridButtonView.setColor(0xFFFF0000, winPosition);
            }

            if (currentMarker == Marker.X) {
                numXWins++;
            } else {
                numOWins++;
            }
        } else if (model.numUnplayedSquares() == 0) {
            numDraws++;
        }

    updateDisplay();
    currentMarker = (currentMarker == Marker.X) ? Marker.O : Marker.X;
    textViewView.displayStatus("Ready Player " + currentMarker);
}
    /**
     * Updates the game display.
     */
    private void updateDisplay() {
        System.out.println("Updating display. X wins: " + numXWins + ", O wins: " + numOWins + ", Draws: " + numDraws);
        textViewView.displayDraws("Draws: " + numDraws);
        textViewView.displayXWins("Player X wins: " + numXWins);
        textViewView.displayOWins("Player O wins: " + numOWins);
    }


    /**
     * Starts a new game.
     */
    public void startNewGame(){
        for (int i = 0; i < gridButtonView.getButtons().length * gridButtonView.getButtons()[0].length; i++){
            gridButtonView.setColor(0xFF0000FF, new Position(i / 3, i % 3));
            gridButtonView.setText(" ", new Position(i / 3, i % 3));
        }

        System.out.println("Resetting the game");
        model.clearBoard();
        startingMarker = (startingMarker == Marker.X) ? Marker.O : Marker.X;
        currentMarker = startingMarker;
        gameOver = false;
    }

    /**
     * Returns the current marker.
     * @return the current marker
     */
    public Marker getCurrentMarker() {
        return currentMarker;
    }
}
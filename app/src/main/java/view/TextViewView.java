/**
 * TextViewView is a class representing a view of text views for a Tic Tac Toe game.
 * It contains several TextViews for displaying game status, wins, and draws.
 *
 * The class provides methods for initializing text views, setting text views, and updating the display of game status, wins, and draws.
 *
 * @author John Benfield
 */
package view;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import com.example.tictactoe.R;

import controller.MainController;

public class TextViewView {
    private TextView statusTextView;
    private TextView xWinsTextView;
    private TextView oWinsTextView;
    private TextView drawsTextView;
    private Context context;
    /**
     * Constructor for TextViewView with context.
     * @param context the context of the application
     */
    public TextViewView(Context context) {
        this.context = context;
    }

    /**
     * Constructor for TextViewView with text views.
     * @param statusTextView the text view for game status
     * @param xWinsTextView the text view for X player wins
     * @param oWinsTextView the text view for O player wins
     * @param drawsTextView the text view for draws
     */
    public TextViewView(TextView statusTextView, TextView xWinsTextView, TextView oWinsTextView, TextView drawsTextView) {
        this.statusTextView = statusTextView;
        this.xWinsTextView = xWinsTextView;
        this.oWinsTextView = oWinsTextView;
        this.drawsTextView = drawsTextView;
    }
    /**
     * Initializes the text views.
     */
    public void initializeTextViews() {
        xWinsTextView = ((Activity) context).findViewById(R.id.xPlayerWins);
        oWinsTextView = ((Activity) context).findViewById(R.id.oPlayerWins);
        drawsTextView = ((Activity) context).findViewById(R.id.drawsCounter);
        statusTextView = ((Activity) context).findViewById(R.id.CurrentTurn);
    }

    /**
     * Sets the status text view.
     * @param statusTextView the status text view to be set
     */
    public void setStatusTextView(TextView statusTextView) {
        this.statusTextView = statusTextView;
    }

    /**
     * Sets the X wins text view.
     * @param xWinsTextView the X wins text view to be set
     */
    public void setXWinsTextView(TextView xWinsTextView) {
        this.xWinsTextView = xWinsTextView;
    }


    /**
     * Sets the O wins text view.
     * @param oWinsTextView the O wins text view to be set
     */
    public void setOWinsTextView(TextView oWinsTextView) {
        this.oWinsTextView = oWinsTextView;
    }

    /**
     * Sets the draws text view.
     * @param drawsTextView the draws text view to be set
     */
    public void setDrawsTextView(TextView drawsTextView) {
        this.drawsTextView = drawsTextView;
    }

    /**
     * Updates the status display.
     * @param status the status to be displayed
     */
    public void updateStatus(String status) {
        statusTextView.setText(status);
    }

    /**
     * Displays the X wins.
     * @param text the text to be displayed
     */
    public void displayXWins(String text){
        xWinsTextView.setText(text);
    }
    /**
     * Displays the O wins.
     * @param text the text to be displayed
     */
    public void displayOWins(String text){
        oWinsTextView.setText(text);
    }

    /**
     * Displays the draws.
     * @param text the text to be displayed
     */
    public void displayDraws(String text){
        drawsTextView.setText(text);
    }

    /**
     * Displays the game status.
     * @param status the status to be displayed
     */
    public void displayStatus(String status) {
        statusTextView.setText(status);
    }
}
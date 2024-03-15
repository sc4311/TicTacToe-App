/**
 * NextGameButtonListener is a class that implements the OnClickListener interface for handling the start of a new game.
 * It contains a reference to the MainController.
 *
 * When the associated view is clicked, it informs the MainController to start a new game.
 *
 * @author John Benfield
 */

package controller;

import android.view.View;

public class NextGameButtonListener implements View.OnClickListener {
    private static MainController mainController;

    /**
     * Sets the MainController for this NextGameButtonListener.
     * @param controller the MainController to be set
     */
    public static void setMainController(MainController controller) {
        NextGameButtonListener.mainController = controller;
    }

    /**
     * Handles the click event. If the MainController is not null, it starts a new game.
     * @param v the View that was clicked
     */
    @Override
    public void onClick(View v) {
        if (mainController != null) {
            mainController.startNewGame();
        }
    }
}
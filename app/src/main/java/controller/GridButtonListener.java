/**
 * GridButtonListener is a class that implements the OnClickListener interface for handling button clicks in the game grid.
 * It contains the row and column of the button in the grid and a reference to the MainController.
 *
 * When a button is clicked, it informs the MainController to make the next move at the button's position.
 *
 * @author John Benfield
 */

package controller;
import android.view.View;

public class GridButtonListener implements View.OnClickListener {
    private static MainController mainController;
    private int row;
    private int col;

    /**
     * Constructor for GridButtonListener.
     * @param row the row of the button in the grid
     * @param col the column of the button in the grid
     */
    public GridButtonListener(int row, int col) {
        this.row = row;
        this.col = col;
    }
    /**
     * Sets the MainController for this GridButtonListener.
     * @param controller the MainController to be set
     */
    public static void setMainController(MainController controller) {
        GridButtonListener.mainController = controller;
    }
    /**
     * Handles the click event. If the MainController is not null, it makes the next move at the button's position.
     * @param v the View that was clicked
     */
    @Override
    public void onClick(View v) {
        if (mainController != null) {
            mainController.nextMove(row, col);
        }
    }
}
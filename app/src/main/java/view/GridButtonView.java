/**
 * GridButtonView is a class representing a grid of buttons for a Tic Tac Toe game.
 * It contains a 2D array of Buttons and provides methods for adding buttons, setting text and color of a button, and getting all buttons.
 *
 * @author John Benfield
 */

package view;

import android.widget.Button;
import android.graphics.Color;

import model.Position;

public class GridButtonView {
    private Button[][] buttons = new Button[3][3];
    /**
     * Adds a button at the given position.
     * @param button the button to be added
     * @param position the position of the button
     */
    public void addButton(Button button, Position position) {
        int row = position.getRow();
        int column = position.getCol();
        buttons[row][column] = button;
    }
    /**
     * Sets the text of the button at the given position.
     * @param space the text to be set
     * @param position the position of the button
     */
    public void setText(String space, Position position) {
        int row = position.getRow();
        int column = position.getCol();
        if (buttons[row][column] != null) {
            buttons[row][column].setText(space);
        }
    }
    /**
     * Sets the color of the button at the given position.
     * @param color the color to be set
     * @param position the position of the button
     */
    public void setColor(int color, Position position) {
        int row = position.getRow();
        int column = position.getCol();
        if (buttons[row][column] != null) {
            buttons[row][column].setBackgroundColor(color);
        }
    }
    /**
     * Returns all buttons.
     * @return a 2D array of all buttons
     */
    public Button[][] getButtons() {
        return buttons;
    }
}
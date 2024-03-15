/**
 * Position is a class representing a position on a Tic Tac Toe board.
 * It contains a row and a column, both of which must be between 0 and 2 inclusive.
 *
 * @author John Benfield
 */
package model;

public class Position {
    private int row;
    private int column;
    /**
     * Constructor for Position.
     * @param row the row of the position
     * @param col the column of the position
     * @throws IllegalArgumentException if row or column values are not between 0 and 2 inclusive
     */
    public Position(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            throw new IllegalArgumentException("Row and column values must be between 0 and 2 inclusive.");
        }
        this.row = row;
        this.column = col;
    }

    /**
     * Returns the row of the position.
     * @return the row of the position
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of the position.
     * @return the column of the position
     */
    public int getCol() {
        return column;
    }
}

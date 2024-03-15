/**
 * TicTacToeBoard is a class representing a Tic Tac Toe game board.
 * It contains a 2D array of Markers representing the state of the game board.
 *
 * The class provides methods for setting and getting markers at specific positions,
 * checking for winning positions, counting unplayed squares, and clearing the board.
 *
 * @author John Benfield
 */

package model;
import java.util.Objects;

/**
 * Constructor for TicTacToeBoard. Initializes the game board.
 */
public class TicTacToeBoard {

    /**
     * Returns the marker at the given position.
     * @param position the position of the marker
     * @return the marker at the given position
     */
    private Marker[][] board;
    public TicTacToeBoard(){
        board = new Marker[3][3];
    }


    /**
     * Returns the marker at the given position.
     * @param position the position of the marker
     * @return the marker at the given position
     */
    public Marker getMarker(Position position){
        return board[position.getRow()][position.getCol()];
    }

    /**
     * Sets the marker at the given position.
     * @param marker the marker to be set
     * @param position the position of the marker
     */
    public void setMarker(Marker marker, Position position){
        if(Objects.isNull(board[position.getRow()][position.getCol()])) board[position.getRow()][position.getCol()] = marker;
        else System.out.println("Position already taken");
    }

    /**
     * Sets the marker at the given row and column.
     * @param row the row of the marker
     * @param column the column of the marker
     * @param marker the marker to be set
     */
    public void setMarker(int row, int column, Marker marker) {
        board[row][column] = marker;
    }


    /**
     * Returns the winning positions for the given marker.
     * @param marker the marker to check for winning positions
     * @return an array of winning positions, or null if there are no winning positions
     */
    public Position[] winningPositions(Marker marker) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (checkRow(i, marker)) {
                return new Position[]{new Position(i, 0), new Position(i, 1), new Position(i, 2)};
            }
            if (checkColumn(i, marker)) {
                return new Position[]{new Position(0, i), new Position(1, i), new Position(2, i)};
            }
        }
        if (board[2][0] == marker && board[1][1] == marker && board[0][2] == marker) {
            return new Position[] { new Position(2, 0), new Position(1, 1), new Position(0, 2) };
        }
        if (checkDiagonals(marker)) {
            return new Position[]{new Position(0, 0), new Position(1, 1), new Position(2, 2)};
        }
        return null;
    }

    /**
     * Returns true if the game board is full.
     * @return true if the game board is full
     */
    private boolean checkRow(int row, Marker marker) {
        return board[row][0] == marker && board[row][1] == marker && board[row][2] == marker;
    }

    /**
     * Returns true if the game board is full.
     * @return true if the game board is full
     */
    private boolean checkColumn(int column, Marker marker) {
        return board[0][column] == marker && board[1][column] == marker && board[2][column] == marker;
    }

    /**
     * Returns true if the game board is full.
     * @return true if the game board is full
     */
    private boolean checkDiagonals(Marker marker) {
        return (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
                (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker);
    }


    /**
     * Returns the number of unplayed squares on the board.
     * @return the number of unplayed squares
     */
    public int numUnplayedSquares() {
        int count = 0;
        for (Marker[] row : board) {
            for (Marker m : row) {
                if (m == null) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Clears the game board.
     */
    public void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = null;
            }
        }
    }
}
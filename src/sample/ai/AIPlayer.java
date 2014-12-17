package sample.ai;

import sample.Board.Board;
import sample.Square;

/**
 * Created by mokanarangant on 12/17/2014.
 */
public abstract class AIPlayer {
    protected int ROWS = 3;  // number of rows
    protected int COLS = 3;  // number of columns

    protected Square[][] cells; // the board's ROWS-by-COLS array of Cells
    protected Square.State mySeed= Square.State.NOUGHT;    // computer's seed
    protected Square.State oppSeed= Square.State.CROSS;   // opponent's seed

    /** Constructor with reference to game board */
    public AIPlayer(Board board) {
        cells = board.squares;
    }

    /** Set/change the seed used by computer and opponent */
    public void setSeed(Square.State seed) {
        this.mySeed = seed;
        oppSeed = (mySeed == Square.State.CROSS) ? Square.State.NOUGHT : Square.State.CROSS;
    }

    /** Abstract method to get next move. Return int[2] of {row, col} */
    public abstract int[] move();  // to be implemented by subclasses
}
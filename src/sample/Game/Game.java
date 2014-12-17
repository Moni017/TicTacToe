package sample.Game;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.Parent;
import javafx.stage.Stage;
import sample.Board.Board;
import sample.Square;
import sample.WinningStrategy;
import sample.ai.AIPlayer;
import sample.ai.AIPlayerAlphaBetaPruning;
import sample.ai.AIPlayerMinimax;
import sample.ai.AIPlayerTableLookup;

/**
 * Created by mokanarangant on 12/16/2014.
 */
public class Game {
    private boolean isSinglePlayer;
    private AIPlayer aiPlayer;

    public void setMode(int level){
        switch (level){
            case 0:aiPlayer = new AIPlayerTableLookup(board);break;
            case 1:aiPlayer = new AIPlayerMinimax(board); break;
            case 2: aiPlayer = new AIPlayerAlphaBetaPruning(board); break;
        }
    }

    public void setSinglePlayer(boolean isSinglePlayer) {
        this.isSinglePlayer = isSinglePlayer;
    }

    private GameSkin skin;
    private Board board = new Board(this);
    private WinningStrategy winningStrategy = new WinningStrategy(board);

    private ReadOnlyObjectWrapper<Square.State> currentPlayer = new ReadOnlyObjectWrapper<>(Square.State.CROSS);
    public ReadOnlyObjectProperty<Square.State> currentPlayerProperty() {
        return currentPlayer.getReadOnlyProperty();
    }
    public Square.State getCurrentPlayer() {
        return currentPlayer.get();
    }

    private ReadOnlyObjectWrapper<Square.State> winner = new ReadOnlyObjectWrapper<>(Square.State.EMPTY);
    public ReadOnlyObjectProperty<Square.State> winnerProperty() {
        return winner.getReadOnlyProperty();
    }

    private ReadOnlyBooleanWrapper drawn = new ReadOnlyBooleanWrapper(false);
    public ReadOnlyBooleanProperty drawnProperty() {
        return drawn.getReadOnlyProperty();
    }
    public boolean isDrawn() {
        return drawn.get();
    }

    private ReadOnlyBooleanWrapper gameOver = new ReadOnlyBooleanWrapper(false);
    public ReadOnlyBooleanProperty gameOverProperty() {
        return gameOver.getReadOnlyProperty();
    }
    public boolean isGameOver() {
        return gameOver.get();
    }

    public Game(GameManager gameManager,Stage stage) {
        gameOver.bind(
                winnerProperty().isNotEqualTo(Square.State.EMPTY)
                        .or(drawnProperty())
        );

        skin = new GameSkin(gameManager, this,stage);
    }

    public Board getBoard() {
        return board;
    }

    public void nextTurn() {
        if (isGameOver()) return;

        switch (currentPlayer.get()) {
            case EMPTY:
            case NOUGHT:

                currentPlayer.set(Square.State.CROSS);

                 break;
            case CROSS:

                currentPlayer.set(Square.State.NOUGHT);
                if(isSinglePlayer){
                int move[] =aiPlayer.move();
                board.getSquare(move[0],move[1]).pressed();}
                break;
        }
    }

    private void checkForWinner() {
        winner.set(winningStrategy.getWinner());
        if(winnerProperty().isEqualTo(Square.State.CROSS).get()){

        }
        drawn.set(winningStrategy.isDrawn());

        if (isDrawn()) {
            currentPlayer.set(Square.State.EMPTY);
        }
    }

    public void boardUpdated() {
        checkForWinner();
    }

    public Parent getSkin() {
        return skin;
    }
}

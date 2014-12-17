package sample.Board;

import javafx.scene.Node;
import sample.Game.Game;
import sample.Square;

/**
 * Created by mokanarangant on 12/16/2014.
 */
public class Board {
    private final BoardSkin skin;

    public final Square[][] squares = new Square[3][3];

    public Board(Game game) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squares[i][j] = new Square(game);
            }
        }

        skin = new BoardSkin(this);
    }

    public Square getSquare(int i, int j) {
        return squares[i][j];
    }

    public Node getSkin() {
        return skin;
    }
}
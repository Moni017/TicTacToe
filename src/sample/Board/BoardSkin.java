package sample.Board;

import javafx.scene.layout.GridPane;

/**
 * Created by mokanarangant on 12/16/2014.
 */
class BoardSkin extends GridPane {
    BoardSkin(Board board) {
        getStyleClass().add("board");
        setWidth(550);
        setHeight(650);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                add(board.getSquare(i, j).getSkin(), i, j);
            }
        }
    }
}

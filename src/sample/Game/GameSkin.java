package sample.Game;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.StatusIndicator;

/**
 * Created by mokanarangant on 12/16/2014.
 */
public class GameSkin extends VBox {
    GameSkin(GameManager gameManager, Game game,Stage stage) {
        getChildren().addAll(
                game.getBoard().getSkin(),
                new StatusIndicator(game),
                new GameControls(gameManager, game,stage)
        );
    }
}

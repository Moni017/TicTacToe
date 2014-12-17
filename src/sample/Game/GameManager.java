package sample.Game;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GameLoader.GameLoader;

/**
 * Created by mokanarangant on 12/16/2014.
 */
public class GameManager {
    private Scene gameScene;
    private Game  game;
    public GameLoader gameLoader;
    private Stage stage;
    private String userName;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public GameManager(Stage stage) {
        this.stage=stage;
        newGame();
    }

    public void newGame() {
        game = new Game(this,stage);

        if (gameScene == null) {
            gameScene = new Scene(game.getSkin());
        } else {
            gameScene.setRoot(game.getSkin());
        }
    }

    public void quit() {
        gameScene.getWindow().hide();
    }

    public Game getGame() {
        return game;
    }

    public Scene getGameScene() {
        return gameScene;
    }
}

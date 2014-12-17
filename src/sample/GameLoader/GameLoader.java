package sample.GameLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Game.Game;
import sample.Game.GameManager;

/**
 * Created by mokanarangant on 12/17/2014.
 */
public class GameLoader {
    private Scene gameScene;
    public Parent skin;
    private Stage stage;


    public GameLoader(GameManager gameManager,Stage stage){
        this.stage=stage;
        skin = new GameLoaderSkin(gameManager,gameManager.getGame(),stage);
        newGame(gameManager);
    }

    public void newGame(GameManager gameManager) {

        if (gameScene == null) {
            gameScene = new Scene(skin);
        } else {
            gameScene.setRoot(new GameLoaderSkin(gameManager,gameManager.getGame(),stage));
        }
    }

    public Parent getSkin() {
        return skin;
    }

    public Scene getGameScene() {
        return gameScene;
    }
}

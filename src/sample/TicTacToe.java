package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Game.GameManager;
import sample.GameLoader.GameLoader;

public class TicTacToe extends Application {
    @Override public void start(Stage stage) throws Exception {
        stage.setWidth(550);
        stage.setHeight(650);
        GameManager gameManager = new GameManager(stage);
        GameLoader gameLoader = new GameLoader(gameManager,stage);
        gameManager.gameLoader = gameLoader;


        Scene scene = gameLoader.getGameScene();
        scene.getStylesheets().add(
                getResource(
                        "tictactoe-blueskin.css"
                )
        );
        stage.setFullScreen(true);
        stage.setTitle("Tic-Tac-Toe");
        stage.getIcons().add(SquareSkin.crossImage);
        stage.setScene(scene);
        stage.show();
    }

    private String getResource(String resourceName) {
        return getClass().getResource(resourceName).toExternalForm();
    }

    public static void main(String[] args) {
        Application.launch(TicTacToe.class);
    }
}



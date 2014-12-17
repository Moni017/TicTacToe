package sample.Game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.GameLoader.GameLoader;
import sample.SquareSkin;

/**
 * Created by mokanarangant on 12/16/2014.
 */
public class GameControls extends HBox {
    Stage stage;

    public Stage getStage() {
        return stage;
    }

    GameControls(final GameManager gameManager, final Game game,Stage stage) {
        this.stage=stage;
        getStyleClass().add("game-controls");

        visibleProperty().bind(game.gameOverProperty());

        Label playAgainLabel = new Label("Play Again?");
        playAgainLabel.getStyleClass().add("info");

        Button playAgainButton = new Button("Yes");
        playAgainButton.getStyleClass().add("play-again");
        playAgainButton.setDefaultButton(true);
        playAgainButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent actionEvent) {
                GameManager gameManager = new GameManager(getStage());
                GameLoader gameLoader = new GameLoader(gameManager,getStage());
                gameManager.gameLoader = gameLoader;


                Scene scene = gameLoader.getGameScene();
                scene.getStylesheets().add(
                        getResource(
                                "tictactoe-blueskin.css"
                        )
                );
                getStage().setFullScreen(true);
                getStage().setTitle("Tic-Tac-Toe");
                getStage().getIcons().add(SquareSkin.crossImage);
                getStage().setScene(scene);
                getStage().show();

            }
        });

        Button exitButton = new Button("No");
        playAgainButton.getStyleClass().add("exit");
        exitButton.setCancelButton(true);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameManager.quit();
            }
        });

        getChildren().setAll(
                playAgainLabel,
                playAgainButton,
                exitButton
        );
    }

    private String getResource(String resourceName) {
        return getClass().getResource(resourceName).toExternalForm();
    }
}

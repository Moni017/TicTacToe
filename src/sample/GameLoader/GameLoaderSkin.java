package sample.GameLoader;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.Game.Game;
import sample.Game.GameControls;
import sample.Game.GameManager;
import sample.SquareSkin;
import sample.StatusIndicator;



/**
 * Created by mokanarangant on 12/17/2014.
 */
public class GameLoaderSkin extends VBox {
    private Game game;
    private GameManager gameManager;
    private Stage stage;

    GameLoaderSkin(final GameManager gameManager, final Game game, final Stage stage) {
        this.game = game;
        this.gameManager = gameManager;
        this.stage=stage;
        Text text = new Text("Welcome to Tic Tac Toe");
        Button singlePlayer = new Button("Single Player");



        Button multiPlayer = new Button("Multi Player");

        multiPlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                game.setSinglePlayer(false);
                stage.setScene(gameManager.getGameScene());
                gameManager.getGameScene().getStylesheets().add(
                        getResource(
                                "tictactoe-blueskin.css"
                        )
                );
                stage.getIcons().add(SquareSkin.crossImage);
                stage.setWidth(550);
                stage.setHeight(650);
            }
        });

        final ToggleGroup group = new ToggleGroup();

        final RadioButton rb1 = new RadioButton("Easy");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);

        final RadioButton rb2 = new RadioButton("Medium");
        rb2.setToggleGroup(group);

        final RadioButton rb3 = new RadioButton("Difficult");
        rb3.setToggleGroup(group);

        singlePlayer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                game.setSinglePlayer(true);
                if(rb1.isSelected()){
                    game.setMode(0);
                }else if(rb2.isSelected()){
                    game.setMode(1);
                }else {
                    game.setMode(2);
                }

                stage.setScene(gameManager.getGameScene());
                gameManager.getGameScene().getStylesheets().add(
                        getResource(
                                "tictactoe-blueskin.css"
                        )
                );
                stage.getIcons().add(SquareSkin.crossImage);
                stage.setWidth(550);
                stage.setHeight(650);
            }
        });
        TextField playerName1=new TextField();
        playerName1.setPromptText("Enter Player Name");

        getChildren().addAll(
                text,
                new Text(""),
                singlePlayer,
                playerName1,
                new Text("Difficulty Level:"),
                rb1,
                rb2,
                rb3,
                new Text(""),
                multiPlayer
        );
    }

    private String getResource(String resourceName) {
        return getClass().getResource(resourceName).toExternalForm();
    }
}

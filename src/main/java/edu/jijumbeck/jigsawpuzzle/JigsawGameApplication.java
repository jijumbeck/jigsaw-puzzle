package edu.jijumbeck.jigsawpuzzle;

import edu.jijumbeck.jigsawpuzzle.model.JigsawPuzzleGame;
import edu.jijumbeck.jigsawpuzzle.view.JigsawGameView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class JigsawGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(JigsawGameApplication.class.getResource("game-view.fxml"));

        JigsawPuzzleGame jigsawPuzzleGame = new JigsawPuzzleGame();
        JigsawGameView jigsawGameView = new JigsawGameView(jigsawPuzzleGame.startNewGame());

        Scene scene = new Scene(jigsawGameView);

        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth() / 2.5);
        stage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
        stage.setTitle("TETRIS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
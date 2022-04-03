package edu.jijumbeck.jigsawpuzzle.view;


import edu.jijumbeck.jigsawpuzzle.model.JigsawPuzzleGameSession;
import edu.jijumbeck.jigsawpuzzle.model.figures.Coord;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class JigsawGameView extends GridPane {
    Label scoreTextLabel;

    Button restartGameButton;
    Button endGameButton;
    Button exitGameButton;

    Label timeTextLabel;

    JigsawField gameField;
    FigureNode figureToLocateNode;
    Rectangle rectangle;


    public JigsawGameView(JigsawPuzzleGameSession jigsawPuzzleGameSession) {
        super();

        this.setPadding(new Insets(30, 30, 30, 30));
        this.setVgap(30);
        this.setHgap(30);

        scoreTextLabel = new Label("Score: ");
        this.add(scoreTextLabel, 0, 0);

        restartGameButton = new Button("Restart");
        this.add(restartGameButton, 2, 0);
        endGameButton = new Button("End");
        this.add(endGameButton, 3, 0);
        exitGameButton = new Button("Exit");
        this.add(exitGameButton, 4, 0);

        timeTextLabel = new Label("00:00");
        this.add(timeTextLabel, 1, 1);

        gameField = new JigsawField();
        gameField.setField(jigsawPuzzleGameSession.getField());
        this.add(gameField, 1, 2);

        figureToLocateNode = new FigureNode(jigsawPuzzleGameSession.getFigure());
        figureToLocateNode.setOnMouseReleased(e -> {
            figureMoving(jigsawPuzzleGameSession, e);
        });
        this.add(figureToLocateNode, 1, 3);
    }

    private void figureMoving(JigsawPuzzleGameSession jigsawPuzzleGameSession, MouseEvent e) {
        double nowX = e.getSceneX();
        double nowY = e.getSceneY();

        if ((nowX < gameField.getLayoutX()) || (nowY < gameField.getLayoutY()) ||
                (nowX > gameField.getLayoutX() + gameField.getWidth()) ||
                (nowY > gameField.getLayoutY() + gameField.getHeight())) {
            System.out.println("aaa");
            figureToLocateNode.setTranslateX(0);
            figureToLocateNode.setTranslateY(0);
        } else {
            figureToLocateNode.setTranslateX(0);
            figureToLocateNode.setTranslateY(0);

            double fieldX = gameField.getLayoutX();
            double fieldY = gameField.getLayoutY();

            int localFigureX = (int)e.getX() / MatchedFieldCell.CELL_SIZE;
            int localFigureY = (int)e.getY() / MatchedFieldCell.CELL_SIZE;

            int x = (int)(nowX - fieldX) / MatchedFieldCell.CELL_SIZE;
            int y = (int)(nowY - fieldY) / MatchedFieldCell.CELL_SIZE;

            x -= localFigureX;
            y -= localFigureY;

            if ((x < 0) || (y < 0)) {
                return;
            }

            if (jigsawPuzzleGameSession.setFigure(new Coord(x, y))) {
                gameField.setField(jigsawPuzzleGameSession.getField());
                this.getChildren().remove(figureToLocateNode);
                figureToLocateNode = new FigureNode(jigsawPuzzleGameSession.getFigure());
                figureToLocateNode.setOnMouseReleased(event -> {
                    figureMoving(jigsawPuzzleGameSession, event);
                });
                this.add(figureToLocateNode, 1, 3);
            }
        }
    }

    private void onClickEndGameButton() {

    }

    private void onClickGameExitButton() {

    }
}

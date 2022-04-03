package edu.jijumbeck.jigsawpuzzle.view;

import edu.jijumbeck.jigsawpuzzle.model.figures.Coord;
import edu.jijumbeck.jigsawpuzzle.model.figures.Figure;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;

public class FigureNode extends GridPane {
    Figure figure;

    double startX;
    double startY;
    double oldX;
    double oldY;

    FigureNode(Figure figure) {
        super();
        this.figure = figure;
        this.setBackground(Background.EMPTY);
        for (Coord coord : figure.getFigurePoints()) {
            this.add(new MatchedFieldCell(true), coord.coordX, coord.coordY);
        }

        this.setOnMousePressed(e -> {
            this.startX = e.getSceneX() - this.getTranslateX();
            this.startY = e.getSceneY() - this.getTranslateY();
        });
        this.setOnMouseDragged(e -> {
            this.setTranslateX(e.getSceneX() - this.startX);
            this.setTranslateY(e.getSceneY() - this.startY);
        });
    }

    void setNewFigure(Figure figure) {

    }
}

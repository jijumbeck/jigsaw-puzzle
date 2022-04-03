package edu.jijumbeck.jigsawpuzzle.view;

import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class MatchedFieldCell extends Rectangle {
    final static int CELL_SIZE = 40;

    MatchedFieldCell(boolean isMatched) {
        super();
        this.setHeight(CELL_SIZE);
        this.setWidth(CELL_SIZE);
        if (isMatched) {
            this.setFill(Color.BLUE);
        } else {
            this.setFill(Color.WHITESMOKE);
        }
        this.setVisible(true);
        this.setArcHeight(10);
        this.setArcWidth(10);
    }
}

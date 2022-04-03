package edu.jijumbeck.jigsawpuzzle.view;

import edu.jijumbeck.jigsawpuzzle.model.Field;
import edu.jijumbeck.jigsawpuzzle.model.figures.Coord;
import javafx.scene.layout.GridPane;


public class JigsawField extends GridPane {
    Field field;
    MatchedFieldCell[][] fieldCells;

    JigsawField() {
        super();
        this.setGridLinesVisible(true);
    }

    public void setField(Field field) {
        this.field = field;
        fieldCells = new MatchedFieldCell[field.FIELD_SIZE][field.FIELD_SIZE];
        for (int i = 0; i < fieldCells.length; ++i) {
            for (int j = 0; j < fieldCells.length; ++j) {
                fieldCells[i][j] = new MatchedFieldCell(field.getField()[i][j].isOccupied());
                this.add(fieldCells[i][j], j, i);
            }
        }
    }

    public boolean setFigure(FigureNode figureNode, Coord coordToSet) {
        return true;
    }
}

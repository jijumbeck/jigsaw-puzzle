package edu.jijumbeck.jigsawpuzzle.model;

import edu.jijumbeck.jigsawpuzzle.model.figures.Coord;
import edu.jijumbeck.jigsawpuzzle.model.figures.Figure;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Field implements Observable {
    public final int FIELD_SIZE = 9;
    private Cell[][] field;

    public Field() {
        field = new Cell[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; ++i) {
            for (int j = 0; j < FIELD_SIZE; ++j) {
                field[i][j] = new Cell();
            }
        }
    }

    /**
     * Setting the figure on the field.
     * @param figure the figure that is about to set on field.
     * @param coordToSet the coordinate of the left upper angle of a bound box for given figure.
     * @throws IllegalArgumentException if figure is not able to be set on field.
     */
    public void setFigureOnField(Figure figure, Coord coordToSet) throws IllegalArgumentException {
        Cell[][] testField = field.clone();
        for (Coord coord : figure.getFigurePoints()) {
            if ((coord.coordX + coordToSet.coordX < FIELD_SIZE) && (coord.coordY + coordToSet.coordY < FIELD_SIZE)) {
                if (!testField[coord.coordY + coordToSet.coordY][coord.coordX + coordToSet.coordX].isOccupied()) {
                    testField[coord.coordY + coordToSet.coordY][coord.coordX + coordToSet.coordX].setOccupied();
                    continue;
                }
                throw new IllegalArgumentException();
            }
        }
        this.field = testField;
    }

    public Cell[][] getField() {
        return field;
    }

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}

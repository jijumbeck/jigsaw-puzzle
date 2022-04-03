package edu.jijumbeck.jigsawpuzzle.model.figures;

import java.util.LinkedList;

public class IFigure extends Figure {
    public IFigure(Rotation rotation) {
        figurePoints = new LinkedList<Coord>();

        switch (rotation) {
            case angle0, angle180 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(2, 0));
            }
            case angle90, angle270 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(0, 2));
            }
        }
    }
}

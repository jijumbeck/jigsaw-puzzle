package edu.jijumbeck.jigsawpuzzle.model.figures;

import java.util.LinkedList;

public class SmallLFigure extends Figure {
    public SmallLFigure(Rotation rotation) {
        figurePoints = new LinkedList<Coord>();

        switch (rotation) {
            case angle0 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(0, 1));
            }
            case angle90 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(1, 1));
            }
            case angle180 -> {
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(1, 1));
                figurePoints.add(new Coord(1, 0));
            }
            case angle270 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(1, 1));
            }
        }
    }
}

package edu.jijumbeck.jigsawpuzzle.model.figures;

import java.util.LinkedList;

public class ZFigure extends Figure {
    public ZFigure(Rotation rotation, boolean isReflected) {
        figurePoints = new LinkedList<Coord>();

        if (!isReflected) {
            switch (rotation) {
                case angle0, angle180 -> {
                    figurePoints.add(new Coord(0, 0));
                    figurePoints.add(new Coord(1, 0));
                    figurePoints.add(new Coord(1, 1));
                    figurePoints.add(new Coord(2, 1));
                }
                case angle90, angle270 -> {
                    figurePoints.add(new Coord(1, 0));
                    figurePoints.add(new Coord(0, 1));
                    figurePoints.add(new Coord(1, 1));
                    figurePoints.add(new Coord(0, 2));
                }
            }
            return;
        }

        switch (rotation) {
            case angle0, angle180 -> {
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(1, 1));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(2, 0));
            }
            case angle90, angle270 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(1, 1));
                figurePoints.add(new Coord(1, 2));
            }
        }
    }
}

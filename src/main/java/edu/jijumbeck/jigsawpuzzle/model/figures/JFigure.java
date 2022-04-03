package edu.jijumbeck.jigsawpuzzle.model.figures;

import java.util.LinkedList;
import java.util.List;

public class JFigure extends Figure {
    public JFigure(Rotation rotation, boolean isReflected) {
        figurePoints = new LinkedList<Coord>();

        if (!isReflected) {
            switch (rotation) {
                case angle0 -> {
                    figurePoints.add(new Coord(0, 0));
                    figurePoints.add(new Coord(1, 0));
                    figurePoints.add(new Coord(2, 0));
                    figurePoints.add(new Coord(0, 1));
                }
                case angle90 -> {
                    figurePoints.add(new Coord(0, 0));
                    figurePoints.add(new Coord(0, 1));
                    figurePoints.add(new Coord(1, 2));
                    figurePoints.add(new Coord(0, 2));
                }
                case angle180 -> {
                    figurePoints.add(new Coord(0, 1));
                    figurePoints.add(new Coord(1, 1));
                    figurePoints.add(new Coord(2, 1));
                    figurePoints.add(new Coord(2, 0));
                }
                case angle270 -> {
                    figurePoints.add(new Coord(0, 0));
                    figurePoints.add(new Coord(1, 0));
                    figurePoints.add(new Coord(1, 1));
                    figurePoints.add(new Coord(1, 2));
                }
            }
            return;
        }

        switch (rotation) {
            case angle0 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(1, 1));
                figurePoints.add(new Coord(2, 1));
            }
            case angle90 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(0, 1));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(0, 2));
            }
            case angle180 -> {
                figurePoints.add(new Coord(0, 0));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(2, 1));
                figurePoints.add(new Coord(2, 0));
            }
            case angle270 -> {
                figurePoints.add(new Coord(0, 2));
                figurePoints.add(new Coord(1, 0));
                figurePoints.add(new Coord(1, 1));
                figurePoints.add(new Coord(1, 2));
            }
        }
    }
}

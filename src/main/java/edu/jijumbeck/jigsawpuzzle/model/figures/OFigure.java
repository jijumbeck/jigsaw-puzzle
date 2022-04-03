package edu.jijumbeck.jigsawpuzzle.model.figures;

import java.util.LinkedList;

public class OFigure extends Figure {
    public OFigure() {
        figurePoints = new LinkedList<Coord>();
        figurePoints.add(new Coord(0, 0));
    }
}

package edu.jijumbeck.jigsawpuzzle.model.figures;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class Figure {
    protected final static int COUNT_OF_TYPES = 31;

    protected List<Coord> figurePoints;
    private int height;
    private int width;

    protected Figure(List<Coord> figurePoints) {
        this.figurePoints = Objects.requireNonNull(figurePoints);
        if (figurePoints.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    protected Figure() {
    }

    public List<Coord> getFigurePoints() {
        return figurePoints;
    }

    public Pair<Coord, Coord> getBoundBox() {
        int xLeftUpper = figurePoints.get(0).coordX;
        int yLeftUpper = figurePoints.get(0).coordY;
        int xRightLower = figurePoints.get(0).coordX;
        int yRightLower = figurePoints.get(0).coordY;

        for (int i = 1; i < figurePoints.size(); ++i) {
            if (xLeftUpper < figurePoints.get(i).coordX) {
                xLeftUpper = figurePoints.get(i).coordX;
            }
            if (yLeftUpper < figurePoints.get(i).coordY) {
                yLeftUpper = figurePoints.get(i).coordY;
            }
            if (xRightLower > figurePoints.get(i).coordX) {
                xRightLower = figurePoints.get(i).coordX;
            }
            if (yRightLower > figurePoints.get(i).coordY) {
                yRightLower = figurePoints.get(i).coordY;
            }
        }

        return new Pair<Coord, Coord>(new Coord(xLeftUpper, yLeftUpper), new Coord(xRightLower, yRightLower));
    }

/*    public void rotateFigure(Rotation rotation) {
        switch (rotation) {
            case angle0 -> {
                return;
            }
            case angle90 -> {
                for (Coord coord : figurePoints) {
                    rotatedFigurePoints.add(new Coord())
                }
            }
            case angle180 -> {
                for (Coord coord : figurePoints) {
                    rotatedFigurePoints.add(new Coord())
                }
            }
            case angle270 -> {
                for (Coord coord : figurePoints) {
                    rotatedFigurePoints.add(new Coord())
                }
            }
        }

        List<Coord> rotatedFigurePoints = new LinkedList<>();
        for (int i = 0; i < rotation.; ++i) {
            for (Coord coord : figurePoints) {
                rotatedFigurePoints.add(new Coord())
            }
        }
        this.figurePoints = rotatedFigurePoints;
    }*/
}

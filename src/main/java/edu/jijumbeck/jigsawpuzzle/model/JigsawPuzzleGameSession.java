package edu.jijumbeck.jigsawpuzzle.model;

import edu.jijumbeck.jigsawpuzzle.model.figures.Coord;
import edu.jijumbeck.jigsawpuzzle.model.figures.Figure;
import edu.jijumbeck.jigsawpuzzle.model.figures.FigureFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class JigsawPuzzleGameSession {
    private final FigureFactory figureFactory;
    private final Field field;
    private Figure figure;
    private final LocalDateTime startGameTime;
    private int score = 0;

    public JigsawPuzzleGameSession() {
        figureFactory = new FigureFactory();
        field = new Field();
        figure = figureFactory.getRandomFigure();
        startGameTime = LocalDateTime.now();
    }

    public boolean setFigure(Coord coordToSet) {
        try {
            field.setFigureOnField(this.figure, coordToSet);
        } catch (IllegalArgumentException exception) {
            return false;
        }

        figure = figureFactory.getRandomFigure();
        return true;
    }

    public Figure getFigure() {
        if (figure == null) {
            figure = figureFactory.getRandomFigure();
        }
        return figure;
    }

    public long endGame() {
        LocalDateTime endTime = LocalDateTime.now();
        return ChronoUnit.SECONDS.between(startGameTime, endTime);
    }

    public Field getField() {
        return field;
    }
}

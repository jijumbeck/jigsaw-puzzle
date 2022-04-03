package edu.jijumbeck.jigsawpuzzle.model;

import java.util.Timer;
import java.util.TimerTask;

public class JigsawPuzzleGame {
    private final static long TIME_OF_GAME_SESSION_IN_SECONDS = 60;
    private int bestScore = 0;
    private JigsawPuzzleGameSession currentGameSession;

    public JigsawPuzzleGame() { }

    public JigsawPuzzleGameSession startNewGame() {
        currentGameSession = new JigsawPuzzleGameSession();
        return currentGameSession;
    }

    public void endGame() {

    }

    public int getBestScore() {
        return bestScore;
    }
}

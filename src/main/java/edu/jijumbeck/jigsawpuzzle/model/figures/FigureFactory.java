package edu.jijumbeck.jigsawpuzzle.model.figures;

import java.util.Random;

public class FigureFactory {
    Random random = new Random();

    public Figure getRandomFigure() {
        int figureID = random.nextInt(Figure.COUNT_OF_TYPES);

        Figure figure = new OFigure();
       if (figureID < FigureType.J) {
           switch (figureID % 4) {
               case 0 -> figure = new JFigure(Rotation.angle0, figureID % 2 == 0);
               case 1 -> figure = new JFigure(Rotation.angle90, figureID % 2 == 0);
               case 2 -> figure = new JFigure(Rotation.angle180, figureID % 2 == 0);
               case 3 -> figure = new JFigure(Rotation.angle270, figureID % 2 == 0);
           }
        } else if (figureID < FigureType.Z) {
           figureID -= FigureType.J;
           switch (figureID / 2) {
               case 0 -> figure = new ZFigure(Rotation.angle0, figureID % 2 == 0);
               case 1 -> figure = new ZFigure(Rotation.angle90, figureID % 2 == 0);
           }
        } else if (figureID < FigureType.L) {
           figureID -= FigureType.Z;
           switch (figureID % 4) {
               case 0 -> figure = new LFigure(Rotation.angle0);
               case 1 -> figure = new LFigure(Rotation.angle90);
               case 2 -> figure = new LFigure(Rotation.angle180);
               case 3 -> figure = new LFigure(Rotation.angle270);
           }
        } else if (figureID < FigureType.T) {
           figureID -= FigureType.L;
           switch (figureID % 4) {
               case 0 -> figure = new TFigure(Rotation.angle0);
               case 1 -> figure = new TFigure(Rotation.angle90);
               case 2 -> figure = new TFigure(Rotation.angle180);
               case 3 -> figure = new TFigure(Rotation.angle270);
           }
        } else if (figureID < FigureType.I) {
           figureID -= FigureType.T;
           switch (figureID % 2) {
               case 0 -> figure = new IFigure(Rotation.angle0);
               case 1 -> figure = new IFigure(Rotation.angle90);
           }
        } else if (figureID < FigureType.O) {
           figure = new OFigure();
        } else if (figureID < FigureType.littleL) {
           figureID -= FigureType.O;
           switch (figureID % 4) {
               case 0 -> figure = new SmallLFigure(Rotation.angle0);
               case 1 -> figure = new SmallLFigure(Rotation.angle90);
               case 2 -> figure = new SmallLFigure(Rotation.angle180);
               case 3 -> figure = new SmallLFigure(Rotation.angle270);
           }
        } else {
           figureID -= FigureType.littleL;
           switch (figureID % 4) {
               case 0 -> figure = new SmallTFigure(Rotation.angle0);
               case 1 -> figure = new SmallTFigure(Rotation.angle90);
               case 2 -> figure = new SmallTFigure(Rotation.angle180);
               case 3 -> figure = new SmallTFigure(Rotation.angle270);
           }
        }

        return figure;
    }
}

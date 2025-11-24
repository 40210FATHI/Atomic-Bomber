package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class SmallBomb extends Rectangle {
    public final double WIDTH = 11;
    public final double HEIGHT = 5;

    public SmallBomb(Airplane airplane) {
        super(11, 5);
        this.setX(airplane.getTranslateX() + 50);
        this.setY(airplane.getTranslateY() + 170);
        this.setFill(new ImagePattern(
                new Image(SmallBomb.class.getResource("/Images/ironbomb.png").toExternalForm())));

    }
}

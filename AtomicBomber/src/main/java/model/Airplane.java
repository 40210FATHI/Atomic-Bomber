package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Airplane extends Polygon {
    private double angle;
    public final Game game;


    public Airplane(Game game) {
        super(90.0, 170.0, 90.0, 180.0, 30.0, 180.0, 30.0, 160.0, 90.0, 160.0);
        this.game = game;
        setFill(new ImagePattern(new Image(Airplane.class.getResource("/Images/plane.png").toExternalForm())));
        this.setScaleX(0.57); // smaller
        this.setScaleY(0.57);
        this.angle = 0;
    }


    public void setPositive() {
        this.angle += 5;
    }

    public void setNegative() {
        this.angle -= 5;
    }

    public double getAngle() {
        return angle % 360;
    }

}

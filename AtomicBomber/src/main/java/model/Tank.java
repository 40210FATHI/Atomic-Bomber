package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Animation.TankAnimation;
import view.Animation.TankAnimation;

public class Tank extends Rectangle {
    public final double WIDTH = 32;
    public final double HEIGHT = 16;
    public boolean isHit = false;
    private TankAnimation tankAnimation;

    public TankAnimation getTankAnimation() {
        return tankAnimation;
    }

    public void setTankAnimation(TankAnimation tankAnimation) {
        this.tankAnimation = tankAnimation;
    }

    public Tank(double x, double y) {
        super(x, y, 32, 16);
        this.setFill(new ImagePattern(new Image
                (Truck.class.getResource("/Images/tank1.png").toExternalForm())));
    }
}

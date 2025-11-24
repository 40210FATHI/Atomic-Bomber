package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Animation.TruckAnimation;

public class Truck extends Rectangle {
    public final double WIDTH = 36;
    public final double HEIGHT = 17;
    public boolean isHit = false;

    private TruckAnimation truckAnimation;

    public void setTruckAnimation(TruckAnimation truckAnimation) {
        this.truckAnimation = truckAnimation;
    }

    public TruckAnimation getTruckAnimation() {
        return truckAnimation;
    }

    public Truck(double x, double y) {
        super(x, y, 36, 17);

        this.setFill(new ImagePattern(new Image
                (Truck.class.getResource("/Images/truck.png").toExternalForm())));
    }

//    public void stopTheAnimation() {
//        TruckAnimation.stop();
//    }
}

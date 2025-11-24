package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Animation.BuildingAnimation;
import view.Animation.TreeAnimation;
import view.Animation.TrenchAnimation;

public class Trench extends Rectangle {

    public final double WIDTH = 48;
    public final double HEIGHT = 40;
    public boolean isHit = false;

    private TrenchAnimation trenchAnimation;

    public TrenchAnimation getTrenchAnimation() {
        return trenchAnimation;
    }

    public void setTrenchAnimation(TrenchAnimation trenchAnimation) {
        this.trenchAnimation = trenchAnimation;
    }

    public Trench(double x, double y) {
        super(x, y, 48, 40);

        this.setFill(new ImagePattern(new Image
                (Trench.class.getResource("/Images/bunker1.png").toExternalForm())));
    }
}

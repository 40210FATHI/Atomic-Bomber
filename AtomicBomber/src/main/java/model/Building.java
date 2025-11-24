package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Animation.BuildingAnimation;
import view.Animation.TreeAnimation;

public class Building extends Rectangle {
    public final double WIDTH = 48;
    public final double HEIGHT = 40;
    public boolean isHit = false;

    private BuildingAnimation buildingAnimation;

    public BuildingAnimation getBuildingAnimation() {
        return buildingAnimation;
    }

    public void setBuildingAnimation(BuildingAnimation buildingAnimation) {
        this.buildingAnimation = buildingAnimation;
    }

    public Building(double x, double y) {
        super(x, y, 48, 40);

        this.setFill(new ImagePattern(new Image
                (Building.class.getResource("/Images/building.png").toExternalForm())));
    }
}

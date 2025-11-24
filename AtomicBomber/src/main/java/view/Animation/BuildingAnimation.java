package view.Animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Airplane;
import model.Building;
import model.Game;
import model.Tree;

public class BuildingAnimation extends Transition {
    private final Game game;
    private final Airplane airplane;
    private final Pane pane;
    private final Building building;
    private double vSpeed = 0;
    private double hSpeed = 0;
    private final int duration = 10000;

    public BuildingAnimation(Pane pane, Game game, Airplane airplane, Building building) {
        this.airplane = airplane;
        this.game = game;
        this.pane = pane;
        this.building = building;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        double y = building.getY();
        double x = building.getX();
        building.setY(y);
        building.setX(x);

    }
}

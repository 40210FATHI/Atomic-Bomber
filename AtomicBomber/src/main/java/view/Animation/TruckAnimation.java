package view.Animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Airplane;
import model.Game;
import model.Truck;

public class TruckAnimation extends Transition {
    private final Game game;
    private final Airplane airplane;
    private final Pane pane;
    private final Truck truck;
    private double vSpeed = 0.15;
    private double hSpeed = 0;
    private final int duration = 10000;

    public TruckAnimation(Pane pane, Game game, Airplane airplane, Truck truck) {
        this.airplane = airplane;
        this.game = game;
        this.pane = pane;
        this.truck = truck;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        double y = truck.getY();
        double x = truck.getX() + vSpeed;
        truck.setY(y);
        truck.setX(x);
        if (truck.getX() >= 569) {
            truck.setX(0);
        }
    }
}

package view.Animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Airplane;
import model.Game;
import model.Tank;
import model.Truck;

public class TankAnimation extends Transition {
    private final Game game;
    private final Airplane airplane;
    private final Pane pane;
    private final Tank tank;
    private double vSpeed = 0.35;
    private double hSpeed = 0;
    private final int duration = 10000;

    public TankAnimation(Pane pane, Game game, Airplane airplane, Tank tank) {
        this.airplane = airplane;
        this.game = game;
        this.pane = pane;
        this.tank = tank;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        double y = tank.getY();
        double x = tank.getX() + vSpeed;
        tank.setY(y);
        tank.setX(x);
        if (tank.getX() >= 569) {
            tank.setX(0);
        }
    }
}

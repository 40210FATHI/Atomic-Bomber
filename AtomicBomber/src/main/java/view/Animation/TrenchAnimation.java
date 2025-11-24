package view.Animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Airplane;
import model.Building;
import model.Game;
import model.Trench;

public class TrenchAnimation extends Transition {
    private final Game game;
    private final Airplane airplane;
    private final Pane pane;
    private final Trench trench;
    private double vSpeed = 0;
    private double hSpeed = 0;
    private final int duration = 10000;

    public TrenchAnimation(Pane pane, Game game, Airplane airplane, Trench trench) {
        this.airplane = airplane;
        this.game = game;
        this.pane = pane;
        this.trench = trench;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        double y = trench.getY();
        double x = trench.getX();
        trench.setY(y);
        trench.setX(x);

    }
}

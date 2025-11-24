package view.Animation;

import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import model.Airplane;
import model.Game;
import model.Tank;
import model.Tree;

public class TreeAnimation extends Transition {
    private final Game game;
    private final Airplane airplane;
    private final Pane pane;
    private final Tree tree;
    private double vSpeed = 0;
    private double hSpeed = 0;
    private final int duration = 10000;

    public TreeAnimation(Pane pane, Game game, Airplane airplane, Tree tree) {
        this.airplane = airplane;
        this.game = game;
        this.pane = pane;
        this.tree = tree;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(duration));
    }

    @Override
    protected void interpolate(double v) {
        double y = tree.getY();
        double x = tree.getX();
        tree.setY(y);
        tree.setX(x);

    }
}

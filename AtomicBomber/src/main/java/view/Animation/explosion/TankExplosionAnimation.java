package view.Animation.explosion;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Tank;
import model.Truck;
import view.Animation.TankAnimation;

public class TankExplosionAnimation extends Transition {
    private final Tank tank;
    private final Group tanks;
    private final Pane pane;

    public TankExplosionAnimation(Tank tank, Pane pane, Group tanks) {
        this.tank = tank;
        this.pane = pane;
        this.tanks = tanks;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        int number = 1;
        if (0 <= v && v <= 0.33) number = 1;
        else if (0.33 < v && v <= 0.66) number = 2;
        else if (0.66 < v && v <= 0.8) number = 3;
        else if (0.8 < v && v <= 1) number = 4;
        else if (1 < v && v <= 1.02) number = 5;

        tank.setFill(new ImagePattern(new Image(
                TankAnimation.class.getResource("/Images/deadtank" + number + ".png").toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tanks.getChildren().remove(tank);
            }
        });

    }
}

package view.Animation.explosion;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Truck;
import view.Animation.TruckAnimation;

public class TruckExplosionAnimation extends Transition {
    private final Truck truck;
    private final Group trucks;
    private final Pane pane;

    public TruckExplosionAnimation(Truck truck, Pane pane, Group trucks) {
        this.truck = truck;
        this.pane = pane;
        this.trucks = trucks;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        int number = 1;
        if (0 <= v && v <= 0.33) number = 1;
        else if (0.33 < v && v <= 0.66) number = 2;
        else if (0.66 < v && v <= 1) number = 3;

        truck.setFill(new ImagePattern(new Image(
                TruckAnimation.class.getResource("/Images/fire" + number + ".png").toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                trucks.getChildren().remove(truck);
            }
        });

    }
}

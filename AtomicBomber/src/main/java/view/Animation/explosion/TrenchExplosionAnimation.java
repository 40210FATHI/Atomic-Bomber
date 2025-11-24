package view.Animation.explosion;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Building;
import model.Trench;
import view.Animation.BuildingAnimation;
import view.Animation.TrenchAnimation;

public class TrenchExplosionAnimation extends Transition {

    private final Trench trench;
    private final Group trenches;
    private final Pane pane;

    public TrenchExplosionAnimation(Trench trench, Pane pane, Group trenches) {
        this.trench = trench;
        this.pane = pane;
        this.trenches = trenches;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        int number = 1;
        if (0 <= v && v <= 0.33) number = 1;
        else if (0.33 < v && v <= 0.66) number = 2;
        else if (0.66 < v && v <= 1) number = 3;

        trench.setFill(new ImagePattern(new Image(
                TrenchAnimation.class.getResource("/Images/fire" + number + ".png").toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                trenches.getChildren().remove(trench);
            }
        });

    }
}

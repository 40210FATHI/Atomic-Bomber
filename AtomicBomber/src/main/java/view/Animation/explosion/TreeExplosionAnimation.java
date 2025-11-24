package view.Animation.explosion;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import model.Tree;
import model.Truck;
import view.Animation.TreeAnimation;
import view.Animation.TruckAnimation;

public class TreeExplosionAnimation extends Transition {

    private final Tree tree;
    private final Group trees;
    private final Pane pane;

    public TreeExplosionAnimation(Tree tree, Pane pane, Group trees) {
        this.tree = tree;
        this.pane = pane;
        this.trees = trees;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        int number = 1;
        if (0 <= v && v <= 0.33) number = 1;
        else if (0.33 < v && v <= 0.66) number = 2;
        else if (0.66 < v && v <= 1) number = 3;

        tree.setFill(new ImagePattern(new Image(
                TreeAnimation.class.getResource("/Images/fire" + number + ".png").toExternalForm())));

        this.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                trees.getChildren().remove(tree);
            }
        });

    }

}

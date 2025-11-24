package model;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import view.Animation.TreeAnimation;
import view.Animation.TruckAnimation;

public class Tree extends Rectangle {

    public final double WIDTH = 18;
    public final double HEIGHT = 35;
    public boolean isHit = false;

    private TreeAnimation treeAnimation;

    public TreeAnimation getTreeAnimation() {
        return treeAnimation;
    }

    public void setTreeAnimation(TreeAnimation treeAnimation) {
        this.treeAnimation = treeAnimation;
    }

    public Tree(double x, double y) {
        super(x, y, 18, 35);

        this.setFill(new ImagePattern(new Image
                (Tree.class.getResource("/Images/tree.png").toExternalForm())));
    }
}

package view.Animation;

import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import model.*;
import view.Animation.explosion.*;

import java.util.Objects;

public class ShootingAnimation extends Transition {
    private final Game game;
    private final Pane pane;
    private final SmallBomb smallBomb;
    private final double speed = 3;
    private final int duration = 100;
    public String username1;

    public ShootingAnimation(Pane pane, Game game, SmallBomb smallBomb, Airplane airplane) {
        this.pane = pane;
        this.game = game;
        this.smallBomb = smallBomb;
        this.setCycleDuration(Duration.millis(duration));
        this.setCycleCount(-1);
        username1 = Player.getLoggedInPlayer().getUsername();
    }

    public double i = 0;

    @Override
    protected void interpolate(double v) {
        double y = smallBomb.getY() + speed;
        double x = smallBomb.getX() + i;


        //for truck
        for (Node child : game.trucks.getChildren()) {
            Truck truck = (Truck) child;
            if (truck.getBoundsInParent().intersects(smallBomb.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                if (truck.isHit) continue;
                truck.isHit = true;

                game.kill += 1;
                game.getGameLauncher().scoreBoard.setText(username1 + "'s kill: " + game.kill + "   (wave 1)");
                truck.getTruckAnimation().stop();

                TruckExplosionAnimation explosionAnimation = new TruckExplosionAnimation(truck, pane, game.trucks);
                game.animations.add(explosionAnimation);
                explosionAnimation.play();

                pane.getChildren().remove(smallBomb);
                this.stop();
                break;
            }
        }

        //for tank
        for (Node child : game.tanks.getChildren()) {
            Tank tank = (Tank) child;
            if (tank.getBoundsInParent().intersects(smallBomb.getBoundsInParent())) {
                Media media = new Media(Objects.requireNonNull(getClass().getResource("/Media/explosion.wav")).toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                if (tank.isHit) continue;
                tank.isHit = true;
                game.kill += 2;
                game.getGameLauncher().scoreBoard.setText(username1 + "'s kill: " + game.kill + "   (wave 1)");

                tank.getTankAnimation().stop();

                TankExplosionAnimation tankExplosionAnimation = new TankExplosionAnimation(tank, pane, game.tanks);
                game.animations.add(tankExplosionAnimation);
                tankExplosionAnimation.play();

                pane.getChildren().remove(smallBomb);
                this.stop();
                break;
            }
        }

        //for trees
        for (Node child : game.trees.getChildren()) {
            Tree tree = (Tree) child;
            if (tree.getBoundsInParent().intersects(smallBomb.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                if (tree.isHit) continue;
                tree.isHit = true;
                game.getGameLauncher().scoreBoard.setText(username1 + "'s kill: " + game.kill + "   (wave 1)");
                tree.getTreeAnimation().stop();

                TreeExplosionAnimation treeExplosionAnimation = new TreeExplosionAnimation(tree, pane, game.trees);
                game.animations.add(treeExplosionAnimation);
                treeExplosionAnimation.play();

                pane.getChildren().remove(smallBomb);
                this.stop();
                break;
            }
        }


        //for trench
        for (Node child : game.trenches.getChildren()) {
            Trench trench = (Trench) child;
            if (trench.getBoundsInParent().intersects(smallBomb.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                if (trench.isHit) continue;
                trench.isHit = true;

                game.kill += 3;
                game.getGameLauncher().scoreBoard.setText(username1 + "'s kill: " + game.kill + "   (wave 1)");
                trench.getTrenchAnimation().stop();

                TrenchExplosionAnimation trenchExplosionAnimation = new TrenchExplosionAnimation(trench, pane, game.trenches);
                game.animations.add(trenchExplosionAnimation);
                trenchExplosionAnimation.play();

                pane.getChildren().remove(smallBomb);
                this.stop();
                break;
            }
        }

        //for building
        for (Node child : game.buildings.getChildren()) {
            Building building = (Building) child;
            if (building.getBoundsInParent().intersects(smallBomb.getBoundsInParent())) {
                Media media = new Media(getClass().getResource("/Media/explosion.wav").toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);

                if (building.isHit) continue;
                building.isHit = true;

                game.kill += 4;
                game.getGameLauncher().scoreBoard.setText(username1 + "'s kill: " + game.kill + "   (wave 1)");
                building.getBuildingAnimation().stop();

                BuildingExplosionAnimation buildingExplosionAnimation = new BuildingExplosionAnimation(building, pane, game.buildings);
                game.animations.add(buildingExplosionAnimation);
                buildingExplosionAnimation.play();

                pane.getChildren().remove(smallBomb);
                this.stop();
                break;
            }
        }


        if (y >= 280) {
            pane.getChildren().remove(smallBomb);
            this.stop();
        }
        smallBomb.setY(y);
        smallBomb.setX(x);
        i = i + 0.03;
    }
}

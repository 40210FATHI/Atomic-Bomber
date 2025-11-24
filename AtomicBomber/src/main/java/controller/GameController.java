package controller;

import javafx.scene.layout.Pane;
import model.Airplane;
import model.Game;
import model.SmallBomb;
import view.Animation.ShootingAnimation;

public class GameController {

    public static void shoot(Pane pane, Airplane airplane, Game game) {
        SmallBomb smallBomb = new SmallBomb(airplane);
        int airplaneIndex = pane.getChildren().indexOf(airplane);
        pane.getChildren().add(airplaneIndex, smallBomb);
        ShootingAnimation shootingAnimation = new ShootingAnimation(pane, game, smallBomb, airplane);
        game.animations.add(shootingAnimation);
        shootingAnimation.play();
    }
}

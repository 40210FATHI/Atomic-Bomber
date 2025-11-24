package controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Player;
import view.PrintAvatarMenu;
import javafx.fxml.FXML;
import view.PregameMenu;
import view.Profile;
import view.loginMenu;

public class PrintAvatarController {
    public ImageView avatar;

    @FXML
    public void initialize() {
        Image image = new Image(Player.getLoggedInPlayer().getAvatar().getUrl());
        avatar.setImage(image);
        avatar.setFitWidth(150);
        avatar.setFitHeight(150);
        avatar.setPreserveRatio(false);
    }

    public void back(MouseEvent mouseEvent) {
        PregameMenu pregameMenu = new PregameMenu();
        try {
            pregameMenu.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

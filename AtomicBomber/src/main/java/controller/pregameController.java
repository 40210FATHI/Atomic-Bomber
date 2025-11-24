package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import model.Game;
import model.Player;
import view.*;

public class pregameController {
    //attention
    public TextField username;

    public void showCurrentUsername(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("show username");
        alert.setHeaderText("your username:");
        alert.setContentText(Player.getLoggedInPlayer().getUsername());
        alert.showAndWait();
    }


    public void startNewGame(MouseEvent mouseEvent) {
        try {
            new GameLauncher(Player.getLoggedInPlayer().getUsername()).start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAvatars(MouseEvent mouseEvent) {
        PrintAvatarMenu avatarMenu = new PrintAvatarMenu();

        try {
            avatarMenu.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void goToScoreTable(MouseEvent mouseEvent) {
        ScoreTable scoreBordMenu = new ScoreTable();

        try {
            scoreBordMenu.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToSettingMenu(MouseEvent mouseEvent) {
        Setting setting = new Setting();
        try {
            setting.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToProfile(MouseEvent mouseEvent) {
        Profile profile = new Profile();
        try {
            profile.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit(MouseEvent mouseEvent) {
        loginMenu loginMenu1 = new loginMenu();

        try {
            loginMenu1.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Game;
import view.PregameMenu;
import view.loginMenu;

import java.util.Objects;

public class SettingController {

    public void back(MouseEvent mouseEvent) {
        PregameMenu pregameMenu = new PregameMenu();
        try {
            pregameMenu.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WhiteBlack(MouseEvent mouseEvent) {
    }

    public void changeButtons(MouseEvent mouseEvent) {
    }


    public void mute(MouseEvent mouseEvent) {

    }

    public void unmute(MouseEvent mouseEvent) {

    }


}

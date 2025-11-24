package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Player;
import view.*;

public class ProfileController {
    public PasswordField password;
    public TextField newPassword;
    public TextField newUsername;

    public void changePassword(MouseEvent mouseEvent) {
        if (this.password.getText().equals(Player.getLoggedInPlayer().getPassword())) {
            Player.getLoggedInPlayer().setPassword(this.newPassword.getText());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("password is wrong");
            alert.setHeaderText("password is wrong");
            alert.setContentText("Please enter the correct password");
            alert.show();
        }
    }

    public void changeUsername(MouseEvent mouseEvent) {
        Player.getLoggedInPlayer().setUsername(this.newUsername.getText());
    }

    public void deleteAccount(MouseEvent mouseEvent) {
        Player.removePlayer(Player.getLoggedInPlayer());
        Player.setLoggedInPlayer(null);
        loginMenu loginMenu1 = new loginMenu();

        try {
            loginMenu1.start(Profile.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void back(MouseEvent mouseEvent) {
        PregameMenu pregameMenu = new PregameMenu();

        try {
            pregameMenu.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(MouseEvent mouseEvent) {
        Player.setLoggedInPlayer(null);
        loginMenu loginMenu1 = new loginMenu();

        try {
            loginMenu1.start(Profile.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToAvatarMenu(MouseEvent mouseEvent) {
        AvatarMenu avatarMenu = new AvatarMenu();

        try {
            avatarMenu.start(Profile.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

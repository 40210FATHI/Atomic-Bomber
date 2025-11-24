package controller;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Player;
import view.AvatarMenu;
import view.GameLauncher;
import view.PregameMenu;
import view.loginMenu;

import java.util.Objects;

public class loginMenuController {
    public PasswordField password;
    public TextField username;

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public void login(MouseEvent mouseEvent) {
        if (Player.getPlayerByUsername(this.username.getText()) == null) {
            //the Alert is for error
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong username!");
            alert.setHeaderText("username not found!");
            alert.setContentText("Please enter your username correctly");
            alert.show();
        } else if (!(Player.getPasswordByPlayer(Objects.requireNonNull(Player.getPlayerByUsername(this.username.getText()))).equals(this.password.getText()))
                && this.username.getText() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong password!");
            alert.setHeaderText("Wrong password!");
            alert.setContentText("Please enter your password correctly");
            alert.show();
        } else if (this.password.getText() != null && this.username.getText() != null) {
            Player player = Player.getPlayerByUsername(this.username.getText());
            Player.setLoggedInPlayer(player);
            PregameMenu pregameMenu = new PregameMenu();
            try {
                pregameMenu.start(loginMenu.stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public void register(MouseEvent mouseEvent) {
        if (Player.isTherePlayerWithUsername(this.username.getText()) && this.password.getText() != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("Invalid username");
            alert.setContentText("This username has already been used");
            alert.show();
        } else if (this.password.getText() != null && this.username.getText() != null) {
            String username1 = this.username.getText();
            String password1 = this.password.getText();
            Player player = new Player(username1, password1);
            Player.addToPlayers(player);
            Player.setLoggedInPlayer(player);
            Image image = new Image(Objects.requireNonNull(getClass().getResource("/Images/Avatar1.PNG")).toString());
            player.setAvatar(image);
            PregameMenu pregameMenu = new PregameMenu();
            try {
                pregameMenu.start(loginMenu.stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void StartingForGuest(MouseEvent mouseEvent) {
        try {
            Player player = new Player("Guest", "empty");
            Player.setLoggedInPlayer(player);
            new GameLauncher(player.getUsername()).start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //without
    }


}

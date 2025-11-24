package controller;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import model.Player;
import view.AvatarMenu;
import view.Profile;
import view.dragDrop;

import java.io.File;
import java.util.Objects;
import java.util.Random;

public class AvatarMenuController {

    public void back(MouseEvent mouseEvent) {
        Profile profile = new Profile();
        try {
            profile.start(AvatarMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAvatar(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        Player.getLoggedInPlayer().setAvatar(imageView.getImage());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Your avatar has been set successfully");
        alert.setTitle("you have new avatar!");
        alert.show();
    }

    public void ChooseFile(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        File currentFile = fileChooser.showOpenDialog(null);
        if (currentFile != null) {
            try {
                Player.getLoggedInPlayer().setAvatar(new Image(currentFile.toURI().toString()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Your avatar has been set successfully");
                alert.setTitle("you have new avatar!");
                alert.show();
            } catch (Exception e) {
                System.out.println("Error loading image: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }

    public void newWindows(MouseEvent mouseEvent) {
        dragDrop dragDrop1 = new dragDrop();

        try {
            dragDrop1.start(AvatarMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getRandomImage(MouseEvent mouseEvent) {
        Image[] staticDefault = {
                new Image(Objects.requireNonNull(getClass().getResource("/Images/Avatar1.PNG")).toString()),
                new Image(Objects.requireNonNull(getClass().getResource("/Images/Avatar2.png")).toString()),
                new Image(Objects.requireNonNull(getClass().getResource("/Images/Avatar3.png")).toString()),
                new Image(Objects.requireNonNull(getClass().getResource("/Images/Avatar4.png")).toString())
        };
        Random random = new Random();
        int length = staticDefault.length;
        Player.getLoggedInPlayer().setAvatar(staticDefault[random.nextInt(length)]);
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setContentText("Your avatar has been set successfully");
        alert1.setTitle("you have new avatar.");
        alert1.show();
    }
}

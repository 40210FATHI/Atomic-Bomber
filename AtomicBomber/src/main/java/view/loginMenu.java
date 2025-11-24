package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Game;

import java.security.PublicKey;
import java.util.Objects;
import java.util.Random;

public class loginMenu extends Application {
    public loginMenu controller;
    public static Stage stage;

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Media media = new Media(Objects.requireNonNull(getClass().getResource("/Media/Assassin’sCreed2.mp3")).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
        loginMenu.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader();
        Image image = new Image(Game.class.getResource("/Images/instructions.png").toExternalForm(), 569, 320, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        Pane pane = FXMLLoader.load(Objects.requireNonNull(loginMenu.class.getResource("/FXML/LoginMenu.fxml")));
        pane.setBackground(background);
        Scene scene = new Scene(pane, 569, 320);
        controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.show();
    }

}

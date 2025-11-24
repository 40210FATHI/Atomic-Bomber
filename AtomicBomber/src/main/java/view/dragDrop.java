package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Game;

import java.util.Objects;

public class dragDrop extends Application {

    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {
        dragDrop.stage = stage;
        Image image = new Image(Objects.requireNonNull(Game.class.getResource("/Images/instructions.png")).toExternalForm(), 569, 320, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        Pane pane = FXMLLoader.load(Objects.requireNonNull(dragDrop.class.getResource("/FXML/dragDrop.fxml")));
        pane.setBackground(background);
        Scene scene = new Scene(pane, 569, 320);
        stage.setScene(scene);
        stage.show();
    }

}

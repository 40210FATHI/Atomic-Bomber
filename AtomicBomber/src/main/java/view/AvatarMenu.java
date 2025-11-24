package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class AvatarMenu extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        AvatarMenu.stage = stage;
        Pane pane = FXMLLoader.load(Objects.requireNonNull(AvatarMenu.class.getResource("/FXML/Avatar.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

}

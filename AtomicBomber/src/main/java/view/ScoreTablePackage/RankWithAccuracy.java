package view.ScoreTablePackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.ScoreTable;
import view.loginMenu;

import java.util.Objects;

public class RankWithAccuracy extends Application {
    public static Stage stage;

    public void back(MouseEvent mouseEvent) {
        ScoreTable scoreTable = new ScoreTable();
        try {
            scoreTable.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        RankWithAccuracy.stage = stage;
        Pane pane = FXMLLoader.load(Objects.requireNonNull(RankWithAccuracy.class.getResource("/FXML/RankWithAccuracy.fxml")));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

}

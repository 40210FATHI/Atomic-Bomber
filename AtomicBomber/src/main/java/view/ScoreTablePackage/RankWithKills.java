package view.ScoreTablePackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RankWithKills extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        RankWithKills.stage = stage;
        Pane pane = FXMLLoader.load(RankWithKills.class.getResource("/FXML/RankWithKills.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}

package view.ScoreTablePackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.ScoreTable;

import java.io.IOException;

public class RankWithScore extends Application {
    public static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        ScoreTable.stage = stage;
        Pane pane = FXMLLoader.load(RankWithScore.class.getResource("/FXML/RankWithScore.fxml"));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

}

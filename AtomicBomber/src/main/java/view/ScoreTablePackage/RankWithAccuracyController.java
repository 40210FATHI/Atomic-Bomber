package view.ScoreTablePackage;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import model.Player;
import view.ScoreTable;
import view.loginMenu;

public class RankWithAccuracyController {

    public VBox players;

    public void back(MouseEvent mouseEvent) {
        ScoreTable scoreTable = new ScoreTable();

        try {
            scoreTable.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        forFXML();
    }

    public void forFXML() {
        int num = 1;
        for (Player player : Player.getBestPlayerWithAccuracy()) {
            Label label = new Label(num + "- " + player.getUsername() + "    Accuracy: " + player.getAccuracy());
            players.getChildren().add(label);
            num++;
        }
    }
}

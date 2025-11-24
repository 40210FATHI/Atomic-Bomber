package view.ScoreTablePackage;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.Player;
import javafx.fxml.FXML;
import view.ScoreTable;
import view.loginMenu;

public class RankWithScoreController {

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
        int num = 1;
        for (Player player : Player.getTenBestPlayers()) {
            Label label = new Label(num + "- " + player.getUsername() + "    Score: " + player.getScore());
            players.getChildren().add(label);
            num++;
        }
    }

}

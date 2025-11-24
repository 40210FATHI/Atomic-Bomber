package view.ScoreTablePackage;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import model.Player;
import view.ScoreTable;
import view.loginMenu;

public class RankWithKillsController {

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
        for (Player player : Player.getBestPlayerWithKills()) {
            Label label = new Label(num + "- " + player.getUsername() + "    Kills: " + player.getKills());
            players.getChildren().add(label);
            num++;
        }
    }
}

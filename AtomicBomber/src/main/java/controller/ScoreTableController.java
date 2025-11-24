package controller;

import javafx.scene.input.MouseEvent;
import view.PregameMenu;
import view.Profile;
import view.ScoreTable;
import view.ScoreTablePackage.RankWithAccuracy;
import view.ScoreTablePackage.RankWithKills;
import view.loginMenu;

public class ScoreTableController {

    public void back(MouseEvent mouseEvent) {
        PregameMenu pregameMenu = new PregameMenu();
        try {
            pregameMenu.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void killsRank(MouseEvent mouseEvent) {
        RankWithKills rankWithKills = new RankWithKills();
        try {
            rankWithKills.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scoresRank(MouseEvent mouseEvent) {
        ScoreTable scoreTable = new ScoreTable();
        try {
            scoreTable.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void accuraciesRank(MouseEvent mouseEvent) {
        RankWithAccuracy rankWithAccuracy = new RankWithAccuracy();
        try {
            rankWithAccuracy.start(loginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package controller;

import javafx.scene.input.MouseEvent;
import view.Profile;
import view.dragDrop;

public class dragDropController {

    public void goToProfileMenu(MouseEvent mouseEvent) {
        Profile profile = new Profile();

        try {
            profile.start(dragDrop.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

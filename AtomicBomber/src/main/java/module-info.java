module AtomicBomber {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports view;
    opens view to javafx.fxml;
    exports view.Animation;
    opens view.Animation to javafx.fxml;
    exports view.Animation.explosion;
    opens view.Animation.explosion to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;

}
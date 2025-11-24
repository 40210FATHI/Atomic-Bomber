package view;

import controller.GameController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import view.Animation.*;

public class GameLauncher extends Application {
    public final double WIDTH = 569;
    public final double HEIGHT = 320;
    public Airplane airplane;
    public Game game;
    public String username1;
    public Timeline createTrucks;
    public Timeline createTanks;
    public Timeline createTrees;
    public Timeline createBuildings;
    public Timeline createTrenches;
    public Pane pane;
    public Text scoreBoard;

    public GameLauncher(String username) {
        game = new Game(Player.getPlayerByUsername(username));
        game.setGameLauncher(this);
        Game.setCurrentGame(game);
        game.setPlayer(Player.getPlayerByUsername(username));
        username1 = username;
    }

    @Override
    public void start(Stage stage) throws Exception {
        pane = new Pane();
        setSize(pane);
        createAirplane();
        pane.getChildren().add(airplane);
        Scene scene = new Scene(pane);
        pane.setBackground(new Background(createBackgroundImage()));

        pane.getChildren().add(game.trees);
        createTrees = new Timeline(new KeyFrame(Duration.seconds(0.01), actionEvent -> createTree()));
        createTrees.setCycleCount(1);
        createTrees.play();

        pane.getChildren().add(game.trenches);
        createTrenches = new Timeline(new KeyFrame(Duration.seconds(0.01), actionEvent -> createTrench()));
        createTrenches.setCycleCount(1);
        createTrenches.play();

        pane.getChildren().add(game.buildings);
        createBuildings = new Timeline(new KeyFrame(Duration.seconds(0.01), actionEvent -> createBuilding()));
        createBuildings.setCycleCount(1);
        createBuildings.play();

        pane.getChildren().add(game.trucks);
        createTrucks = new Timeline(new KeyFrame(Duration.seconds(6), actionEvent -> createTruck()));
        createTrucks.setCycleCount(2);
        createTrucks.play();

        pane.getChildren().add(game.tanks);
        createTanks = new Timeline(new KeyFrame(Duration.seconds(5), actionEvent -> createTank()));
        createTanks.setCycleCount(3);
        createTanks.play();


        pane.getChildren().add(createScoreHbox());

        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        airplane.requestFocus();

    }

    private void setSize(Pane pane) {
        pane.setMinHeight(HEIGHT);
        pane.setMaxHeight(HEIGHT);
        pane.setMinWidth(WIDTH);
        pane.setMaxWidth(WIDTH);
    }

    private void setBackground(Pane pane) {
        Image backgroundImage = new Image(GameLauncher.class.getResource("/Images/newSky.png").toExternalForm());
        ImageView background = new ImageView(backgroundImage);
        background.setX((game.WIDTH / 2) - (backgroundImage.getWidth() / 2));
        pane.getChildren().add(background);
    }

    private BackgroundImage createBackgroundImage() {
        Image image = new Image(Game.class.getResource("/Images/newSky.png").toExternalForm(), WIDTH, HEIGHT, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return backgroundImage;
    }



    //Reyhaneh Alavi --> rotate airplane

    private void createAirplane() {
        Airplane airplane1 = new Airplane(game);
        this.airplane = airplane1;
        this.airplane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                this.airplane.setNegative();
                this.airplane.setRotate(this.airplane.getAngle());
            } else if (event.getCode() == KeyCode.DOWN) {
                this.airplane.setPositive();
                this.airplane.setRotate(this.airplane.getAngle());
            } else if ((event.getCode() == KeyCode.RIGHT && airplane.getAngle() >= 90 && airplane.getAngle() <= 180) ||
                    (event.getCode() == KeyCode.RIGHT && airplane.getAngle() >= -180 && airplane.getAngle() <= -90)) {
                if (airplane.getTranslateX() >= 569) {
                    airplane.setTranslateX(-19);
                } else if (airplane.getTranslateX() <= -20) {
                    airplane.setTranslateX(559);
                } else {
                    double x = this.airplane.getTranslateX() - (10 * Math.cos(Math.toRadians(this.airplane.getAngle())));
                    double y = this.airplane.getTranslateY() - (10 * Math.sin(Math.toRadians(this.airplane.getAngle())));
                    this.airplane.setTranslateX(x);
                    this.airplane.setTranslateY(y);
                }
            } else if ((event.getCode() == KeyCode.LEFT && airplane.getAngle() >= 90 && airplane.getAngle() <= 270) ||
                    (event.getCode() == KeyCode.LEFT && airplane.getAngle() >= -270 && airplane.getAngle() <= -90)) {
                if (airplane.getTranslateX() <= -20) {
                    airplane.setTranslateX(559);
                } else {
                    double x = this.airplane.getTranslateX() + (10 * Math.cos(Math.toRadians(this.airplane.getAngle())));
                    double y = this.airplane.getTranslateY() + (10 * Math.sin(Math.toRadians(this.airplane.getAngle())));
                    this.airplane.setTranslateX(x);
                    this.airplane.setTranslateY(y);
                }
            } else if (event.getCode() == KeyCode.RIGHT) {
                if (airplane.getTranslateX() >= 569) {
                    airplane.setTranslateX(-19);
                } else if (airplane.getTranslateX() <= -20) {
                    airplane.setTranslateX(559);
                } else {
                    double x = this.airplane.getTranslateX() + (10 * Math.cos(Math.toRadians(this.airplane.getAngle())));
                    double y = this.airplane.getTranslateY() + (10 * Math.sin(Math.toRadians(this.airplane.getAngle())));
                    this.airplane.setTranslateX(x);
                    this.airplane.setTranslateY(y);
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                if (airplane.getTranslateX() >= 569) {
                    airplane.setTranslateX(-19);
                } else if (airplane.getTranslateX() <= -20) {
                    airplane.setTranslateX(559);
                } else {
                    double x = this.airplane.getTranslateX() - (10 * Math.cos(Math.toRadians(this.airplane.getAngle())));
                    double y = this.airplane.getTranslateY() - (10 * Math.sin(Math.toRadians(this.airplane.getAngle())));
                    this.airplane.setTranslateX(x);
                    this.airplane.setTranslateY(y);
                }
            } else if (event.getCode() == KeyCode.SPACE) {
                GameController.shoot(pane, airplane, game);
            }
        });
    }


    private void createTruck() {
        Truck truck = new Truck(0, 270);
        truck.setTruckAnimation(new TruckAnimation(pane, game, airplane, truck));
        game.animations.add(truck.getTruckAnimation());
        truck.getTruckAnimation().play();
        game.trucks.getChildren().add(truck);
    }

    private void createTank() {
        Tank tank = new Tank(0, 275);
        tank.setTankAnimation(new TankAnimation(pane, game, airplane, tank));
        game.animations.add(tank.getTankAnimation());
        tank.getTankAnimation().play();
        game.tanks.getChildren().add(tank);
    }

    private void createTree() {
        Tree tree = new Tree(60, 237);
        Tree tree1 = new Tree(100, 237);
        Tree tree2 = new Tree(350, 237);
        tree.setTreeAnimation(new TreeAnimation(pane, game, airplane, tree));
        game.animations.add(tree.getTreeAnimation());
        tree.getTreeAnimation().play();
        game.trees.getChildren().add(tree);

        tree1.setTreeAnimation(new TreeAnimation(pane, game, airplane, tree1));
        game.animations.add(tree1.getTreeAnimation());
        tree1.getTreeAnimation().play();
        game.trees.getChildren().add(tree1);

        tree2.setTreeAnimation(new TreeAnimation(pane, game, airplane, tree2));
        game.animations.add(tree2.getTreeAnimation());
        tree2.getTreeAnimation().play();
        game.trees.getChildren().add(tree2);
    }

    private void createBuilding() {
        Building building = new Building(400, 237);
        building.setBuildingAnimation(new BuildingAnimation(pane, game, airplane, building));
        game.animations.add(building.getBuildingAnimation());
        building.getBuildingAnimation().play();
        game.buildings.getChildren().add(building);
    }

    private void createTrench() {
        Trench trench = new Trench(500, 237);
        trench.setTrenchAnimation(new TrenchAnimation(pane, game, airplane, trench));
        game.animations.add(trench.getTrenchAnimation());
        trench.getTrenchAnimation().play();
        game.trenches.getChildren().add(trench);
    }

    private HBox createScoreHbox() {
        HBox hBox = new HBox();
        scoreBoard = new Text(360, 50, username1 + "'s score: 0" + "   (wave 1)");
        scoreBoard.setFill(Color.MEDIUMSLATEBLUE);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(scoreBoard);
        hBox.setLayoutX(10);
        return hBox;
    }
}

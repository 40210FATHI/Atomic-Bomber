package model;

import javafx.animation.Transition;
import javafx.scene.Group;
import view.GameLauncher;

import java.util.ArrayList;

public class Game {
    public final double WIDTH = 569;
    public final double HEIGHT = 320;
    private Player player;
    public int kill = 0;
    private static Game currentGame;


    private GameLauncher gameLauncher;
    public final Group trucks = new Group();
    public final Group tanks = new Group();
    public final Group trees = new Group();
    public final Group buildings = new Group();
    public final Group trenches = new Group();
    public final ArrayList<Transition> animations = new ArrayList<>();


    public Game(Player player) {
        this.player = player;
        setPlayer(player);
    }

    public void setGameLauncher(GameLauncher gameLauncher) {
        this.gameLauncher = gameLauncher;
    }

    public GameLauncher getGameLauncher() {
        return gameLauncher;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Game.currentGame = currentGame;
    }
}

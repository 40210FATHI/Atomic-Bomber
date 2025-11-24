package model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Player {
    private static ArrayList<Player> players = new ArrayList<>();
    private static ArrayList<Game> games = new ArrayList<>();
    private static Player loggedInPlayer;
    private int kills;
    private Image Avatar;
    private String username;
    private String password;
    private double accuracy;
    private int numberOfShooting;
    private int numberOfSuccessfulShot;
    private int currentRank;
    private double score;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.accuracy = 0;
        this.numberOfShooting = 0;
        this.numberOfSuccessfulShot = 0;
        this.currentRank = 0;
        this.kills = 0;
    }

    public Image getAvatar() {
        return Avatar;
    }

    public void setAvatar(Image avatar) {
        Avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public static Player getLoggedInPlayer() {
        return loggedInPlayer;
    }

    public static void setLoggedInPlayer(Player loggedInPlayer) {
        Player.loggedInPlayer = loggedInPlayer;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumberOfShooting() {
        return numberOfShooting;
    }

    public void setNumberOfShooting(int numberOfShooting) {
        this.numberOfShooting = this.numberOfShooting + 1;
        this.accuracy = (this.numberOfSuccessfulShot / this.numberOfShooting);
    }

    public int getNumberOfSuccessfulShot() {
        return numberOfSuccessfulShot;
    }

    public void setNumberOfSuccessfulShot(int numberOfSuccessfulShot) {
        this.numberOfSuccessfulShot++;
        this.numberOfShooting++;
        this.accuracy = (this.numberOfSuccessfulShot / this.numberOfShooting);
    }

    public int getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(int currentRank) {
        this.currentRank += currentRank;
    }

    public static void addToPlayers(Player player) {
        players.add(player);
    }

    public static boolean isTherePlayerWithUsername(String username) {
        ArrayList<Player> playersForCheck = new ArrayList<>(players);
        for (Player player : playersForCheck)
            if (player.getUsername().equals(username))
                return true;
        return false;
    }

    public static Player getPlayerByUsername(String username) {
        ArrayList<Player> playersForCheck = new ArrayList<>(players);
        for (Player player : playersForCheck)
            if (player.getUsername().equals(username))
                return player;
        return null;
    }

    public static void removePlayer(Player player) {
        ArrayList<Player> playerForCheck = new ArrayList<>(players);
        for (Player player1 : playerForCheck)
            if (player1.equals(player))
                players.remove(player1);
    }

    public static String getPasswordByPlayer(Player player) {
        return player.getPassword();
    }

    public static ArrayList<Player> getTenBestPlayers() {
        ArrayList<Player> playerForCheck = new ArrayList<>(players);
        Collections.sort(playerForCheck, Comparator.comparingDouble(Player::getScore).reversed());
        if (playerForCheck.size() > 10) {
            return (ArrayList<Player>) playerForCheck.subList(0, 10);
        } else {
            return playerForCheck;
        }
    }

    public static ArrayList<Player> getBestPlayerWithKills() {
        ArrayList<Player> playerForCheck = new ArrayList<>(players);
        Collections.sort(playerForCheck, Comparator.comparingDouble(Player::getKills).reversed());
        return playerForCheck;
    }

    public static ArrayList<Player> getBestPlayerWithAccuracy() {
        ArrayList<Player> playerForCheck = new ArrayList<>(players);
        Collections.sort(playerForCheck, Comparator.comparingDouble(Player::getAccuracy).reversed());
        return playerForCheck;
    }


}

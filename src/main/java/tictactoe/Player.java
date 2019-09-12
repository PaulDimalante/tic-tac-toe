package tictactoe;

public class Player {
    private String player;

    public Player() {
        reset();
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void reset() {
        this.player = "X";
    }

    public String move() {
        String current = this.player;
        if("X" == this.player) {
            this.player = "O";
        } else {
            this.player = "X";
        }
        return current;
    }

    public void displayCurrentPlayer() {
        System.out.println("Player "+this.player+" moves next");
    }
}

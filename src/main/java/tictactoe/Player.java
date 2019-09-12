package tictactoe;

public class Player {
    private String player;

    public Player() {
        reset();
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
}

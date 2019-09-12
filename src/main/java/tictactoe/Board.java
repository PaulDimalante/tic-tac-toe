package tictactoe;

public class Board {
    private String[][] boxes = new String[3][3];

    public Board() {
        reset();
    }

    public String toString() {
        String board = "";
        for (int r=0; r<this.boxes.length; r++) {
            for (int c=0; c<this.boxes[r].length; c++) {
                board += this.boxes[r][c];
            }
        }
        return board;
    }

    public void reset() {
        for (int r=0; r<this.boxes.length; r++) {
            for (int c=0; c<this.boxes[r].length; c++) {
                this.boxes[r][c] = ".";
            }
        }
    }
    public boolean move(Player player, int row, int col) {
        boolean valid;
        int r = row - 1;
        int c = col - 1;
        valid = "." == this.boxes[r][c];
        if(valid) {
            this.boxes[r][c] = player.move();
        }
        return valid;
    }
}

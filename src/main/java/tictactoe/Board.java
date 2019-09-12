package tictactoe;

import java.util.Scanner;

public class Board {
    private String[][] boxes = new String[3][3];
    private int count;
    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public String getWinner() {
        return winner;
    }

    private String winner;

    public Board() {
        reset();
    }

    public String toString() {
        String board = "";
        for (int r = 0; r < this.boxes.length; r++) {
            for (int c = 0; c < this.boxes[r].length; c++) {
                board += this.boxes[r][c];
            }
        }
        return board;
    }

    public void reset() {
        this.count = 0;
        this.gameOver = false;
        this.winner = "";
        for (int r = 0; r < this.boxes.length; r++) {
            for (int c = 0; c < this.boxes[r].length; c++) {
                this.boxes[r][c] = ".";
            }
        }
    }

    public boolean move(Player player, int row, int col) {
        boolean valid;
        if (row<1 || row>3 || col<1 || col>3) return false;
        int r = row - 1;
        int c = col - 1;
        valid = "." == this.boxes[r][c];
        if (valid) {
            this.boxes[r][c] = player.move();
            this.count++;
            calcGameOver();
        }
        return valid;
    }

    private void calcGameOver() {
        String[] r0 = {boxes[0][0], boxes[0][1], boxes[0][2]};
        String[] r1 = {boxes[1][0], boxes[1][1], boxes[1][2]};
        String[] r2 = {boxes[2][0], boxes[2][1], boxes[2][2]};
        String[] c0 = {boxes[0][0], boxes[1][0], boxes[2][0]};
        String[] c1 = {boxes[0][1], boxes[1][1], boxes[2][1]};
        String[] c2 = {boxes[0][2], boxes[1][2], boxes[2][2]};
        String[] d0 = {boxes[0][0], boxes[1][1], boxes[2][2]};
        String[] d1 = {boxes[0][2], boxes[1][1], boxes[2][0]};

        if (checkForWinner(c0)) {
            this.gameOver = true;
            this.winner = c0[0] + " wins";
            return;
        }
        if (checkForWinner(c1)) {
            this.gameOver = true;
            this.winner = c1[0] + " wins";
            return;
        }
        if (checkForWinner(c2)) {
            this.gameOver = true;
            this.winner = c2[0] + " wins";
            return;
        }
        if (checkForWinner(r0)) {
            this.gameOver = true;
            this.winner = r0[0] + " wins";
            return;
        }
        if (checkForWinner(r1)) {
            this.gameOver = true;
            this.winner = r1[0] + " wins";
            return;
        }
        if (checkForWinner(r2)) {
            this.gameOver = true;
            this.winner = r2[0] + " wins";
            return;
        }
        if (checkForWinner(d0)) {
            this.gameOver = true;
            this.winner = d0[0] + " wins";
            return;
        }
        if (checkForWinner(d1)) {
            this.gameOver = true;
            this.winner = d1[0] + " wins";
            return;
        }
        if (this.count >= 9) {
            this.gameOver = true;
            this.winner = "Nobody wins";
            return;
        }
    }

    private boolean checkForWinner(String[] boxes) {
        String v = boxes[0];
        return ! v.equals(".") && v.equals(boxes[1]) && v.equals(boxes[2]);
    }

    public void displayBoard() {
        String board = toString();
        String s = board.substring(0, 3);
        s = board.substring(3, 6);
        s = board.substring(6, 9);
        System.out.println(board.substring(0, 3));
        System.out.println(board.substring(3, 6));
        System.out.println(board.substring(6, 9));
    }

    public void displayWinner() {
        System.out.println(this.winner);
    }

    public void promptMove(Scanner scanner, Player player) {
        System.out.print("row col");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        System.out.println("");
        move(player, row, col);
    }
}

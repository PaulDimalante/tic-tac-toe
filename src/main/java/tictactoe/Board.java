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
        for (int r=0; r<this.boxes.length; r++) {
            for (int c=0; c<this.boxes[r].length; c++) {
                board += this.boxes[r][c];
            }
        }
        return board;
    }

    public void reset() {
        this.count = 0;
        this.gameOver = false;
        this.winner = "";
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
            this.count++;
            calcGameOver();
        }
        return valid;
    }

    private void calcGameOver() {
        this.gameOver = this.count>=9;
    }

    public void displayBoard() {
        String board = toString();
        String s = board.substring(0,3);
        s = board.substring(3,6);
        s = board.substring(6,9);
        System.out.println(board.substring(0,3));
        System.out.println(board.substring(3,6));
        System.out.println(board.substring(6,9));
    }

    public void promptMove(Scanner scanner, Player player) {
        System.out.print("row col");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        System.out.println("");
        move(player, row, col);
    }
}
